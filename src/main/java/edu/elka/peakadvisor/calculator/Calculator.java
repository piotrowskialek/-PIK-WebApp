package edu.elka.peakadvisor.calculator;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.math3.fitting.PolynomialCurveFitter;
import org.apache.commons.math3.fitting.WeightedObservedPoints;
import org.springframework.stereotype.Component;
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
        WeightedObservedPoints data = new WeightedObservedPoints();
        rates.stream().forEach((r)->data.add(r.getTimestamp(), r.getPrice()));

        PolynomialCurveFitter fitter = PolynomialCurveFitter.create(power);
        double[] coeffs = fitter.fit(data.toList());

        for (long timestamp = begin; timestamp <= end; timestamp += 900) {
            double price = 0;
            int i = 0;
            for (double coeff : coeffs) {

                price += (coeff * power(timestamp, i++));
                price = formatPrice(price);
            }

            predictedRates.add(new Rate(timestamp, price));
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
        if (price > Math.pow(10, 10))
            price = Math.pow(10, 10);

        return price;
    }

    double power(double x, int n){
        if(n==0)
            return 1;

        if(n<0){
            x = 1.0/x;
            n = -n;
        }
        double ret = power(x,n/2);
        ret = ret * ret;
        if(n%2!=0)
            ret = ret * x;
        return ret;
    }

}
