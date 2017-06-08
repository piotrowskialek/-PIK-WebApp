package edu.elka.peakadvisor.calculator;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;
import weka.classifiers.functions.SMOreg;
import weka.classifiers.functions.supportVector.Kernel;
import weka.classifiers.functions.supportVector.RegOptimizer;
import weka.classifiers.functions.supportVector.RegSMOImproved;
import weka.core.Attribute;
import weka.core.DenseInstance;
import weka.core.Instance;
import weka.core.Instances;
import weka.classifiers.functions.LinearRegression;

/**
 * Created by apiotro on 27.04.17.
 */

@Component
public class Calculator {

    public Calculator () {
    }

    public List<Rate> predictRatesLinear (List<Rate> rates, long begin, long end) {
        List<Rate> predictedRates = new ArrayList<>();
        try {
            Instances data = createRegressionModel(rates);

            LinearRegression model = new LinearRegression();
            model.buildClassifier(data);

            int i = 0;
            double predictedPrice = 0.0;
            for (long timestamp = begin; timestamp <= end; timestamp += 900, ++i) {
                addRateToInstances(new Rate(timestamp, 0.0), data);
                Instance predictedRate = data.get(rates.size() + i);

                predictedPrice = formatPrice(model.classifyInstance(predictedRate));
                predictedRates.add(new Rate(timestamp, predictedPrice));
            }

        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return predictedRates;
    }

    public List<Rate> predictRatesPolynomial (List<Rate> rates, long begin, long end, int power) {
        List<Rate> predictedRates = new ArrayList<>();
        try {
            Instances data = createRegressionModel(rates);

            SMOreg predictor = new SMOreg();
            String[] polyOptions = {
                    "-E", Integer.toString(power),
                    "-C", "250007"
            };
            String[] smoOptions = {
                    "-T", "0.00001",
                    "-V 2 -P", "1.0E-12",
                    "-L", "0.00001",
                    "-W", "1",
                    "-E", Integer.toString(power)
            };

            Kernel polyKernel = predictor.getKernel();
            polyKernel.setOptions(polyOptions);

            RegOptimizer smo = new RegSMOImproved();
            smo.setSMOReg(predictor);
            smo.setOptions(smoOptions);

            predictor.setKernel(polyKernel);
            predictor.setRegOptimizer(smo);

            predictor.buildClassifier(data);

            int i = 0;
            double predictedPrice = 0.0;
            for (long timestamp = begin; timestamp <= end; timestamp += 900, ++i) {
                addRateToInstances(new Rate(timestamp, 0.0), data);
                Instance predictedRate = data.get(rates.size() + i);

                predictedPrice = formatPrice(predictor.classifyInstance(predictedRate));
                predictedRates.add(new Rate(timestamp, predictedPrice));
            }

        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return predictedRates;
    }

    private void addRateToInstances (Rate rate, Instances data) {
        double [] instance = new double [data.numAttributes()];
        instance[0] = rate.getTimestamp();
        instance[1] = rate.getPrice();
        data.add(new DenseInstance (1.0, instance));
    }

    private Instances createRegressionModel (List<Rate> rates) {
        if (rates.size() < 2)
            return null;

        ArrayList<Attribute> attributes = new ArrayList<>(2);
        attributes.add (new Attribute("timestamp"));
        attributes.add(new Attribute("price"));

        Instances data = new Instances("Rates", attributes,0);
        data.setClassIndex(data.numAttributes() - 1);

        rates.stream().forEach((r)->addRateToInstances(r, data));
        return data;
    }

    private Double formatPrice (double price) {
        if (price < 0)
            price = 0.0;
        if (price > (10^10))
            price = 10^10;

        return price;
    }

}
