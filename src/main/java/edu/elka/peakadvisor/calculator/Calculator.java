package edu.elka.peakadvisor.calculator;

import java.util.ArrayList;

import org.springframework.stereotype.Component;
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

    public ArrayList<Rate> predictRatesLinear (ArrayList<Rate> rates, long begin, long end) {
        ArrayList<Rate> results = new ArrayList<>();
        try {
            if (rates.size() < 2)
                return null;

            ArrayList<Attribute> attributes = new ArrayList<Attribute>(2);
            attributes.add (new Attribute("timestamp"));
            attributes.add(new Attribute("price"));

            Instances data = new Instances("Rates", attributes,0);
            data.setClassIndex(data.numAttributes() - 1);

            for (Rate rate : rates) {
                addRateToInstances(rate, data);
            }

            LinearRegression model = new LinearRegression();
            model.buildClassifier(data);

            int i = 0;
            for (long timestamp = begin; timestamp <= end; timestamp += 3600, ++i) {
                addRateToInstances(new Rate(timestamp, 0.0), data);
                Instance predictedRate = data.get(rates.size() + i);
                results.add(new Rate(timestamp, model.classifyInstance(predictedRate)));
            }

        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return results;
    }

    public ArrayList<Rate> predictRatesPolynomial3 (ArrayList<Rate> rates, long begin, long end) {
        ArrayList<Rate> results = new ArrayList<>();
        try {
            if (rates.size() < 2)
                return null;

            ArrayList<Attribute> attributes = new ArrayList<Attribute>(2);
            attributes.add (new Attribute("timestamp"));
            attributes.add(new Attribute("price"));
            attributes.add(new Attribute("pricePower2"));

            Instances data = new Instances("Rates", attributes,0);
            data.setClassIndex(data.numAttributes() - 1);

            for (Rate rate : rates) {
                addRateToInstances(rate, data);
            }

            LinearRegression model = new LinearRegression();
            model.buildClassifier(data);

            int i = 0;
            for (long timestamp = begin; timestamp <= end; timestamp += 3600, ++i) {
                addRateToInstances(new Rate(timestamp, 0.0), data);
                Instance predictedRate = data.get(rates.size() + i);
                results.add(new Rate(timestamp, model.classifyInstance(predictedRate)));
            }

        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return results;
    }

    private void addRateToInstances (Rate rate, Instances data) {
        double [] instance = new double [data.numAttributes()];
        instance[0] = rate.getTimestamp();
        instance[1] = rate.getPrice();
        data.add(new DenseInstance (1.0, instance));
    }

}