package edu.elka.peakadvisor.calculator;

import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Component;
import weka.classifiers.functions.SMOreg;
import weka.core.Attribute;
import weka.core.DenseInstance;
import weka.core.Instance;
import weka.core.Instances;
import weka.classifiers.functions.LinearRegression;
import edu.elka.peakadvisor.calculator.Rate;

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
            for (long timestamp = begin; timestamp <= end; timestamp += 900, ++i) {
                addRateToInstances(new Rate(timestamp, 0.0), data);
                Instance predictedRate = data.get(rates.size() + i);
                predictedRates.add(new Rate(timestamp, model.classifyInstance(predictedRate)));
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
            String [] options = {"-C", "1.0",
                                "-N", "0",
                                "-I", "weka.classifiers.functions.supportVector.RegSMOImproved -T 0.001 -V -P 1.0E-12 -L 0.001 -W 1",
                                "-K", "weka.classifiers.functions.supportVector.PolyKernel -E " + power + " -C 250007"};
            predictor.setOptions(options);
            predictor.buildClassifier(data);

            int i = 0;
            Double predictedPrice = 0.0;
            for (long timestamp = begin; timestamp <= end; timestamp += 900, ++i) {
                addRateToInstances(new Rate(timestamp, 0.0), data);
                Instance predictedRate = data.get(rates.size() + i);
                predictedPrice = predictor.classifyInstance(predictedRate);
                predictedPrice = (double)Math.round(predictedPrice * 100000d / 100000d);
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

        ArrayList<Attribute> attributes = new ArrayList<Attribute>(2);
        attributes.add (new Attribute("timestamp"));
        attributes.add(new Attribute("price"));

        Instances data = new Instances("Rates", attributes,0);
        data.setClassIndex(data.numAttributes() - 1);

        rates.stream().forEach((r)->addRateToInstances(r, data));
        return data;
    }

}
