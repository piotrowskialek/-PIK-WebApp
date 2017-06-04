package edu.elka.peakadvisor.calculator;

import java.io.BufferedReader;
import java.io.FileReader;
import java.sql.Time;
import java.sql.Timestamp;
import java.util.ArrayList;

import weka.core.Attribute;
import weka.core.Instance;
import weka.core.Instances;
import weka.classifiers.functions.LinearRegression;
import edu.elka.peakadvisor.calculator.Rate;

/**
 * Created by apiotro on 27.04.17.
 */
public class Calculator {

    public Calculator (String datasetFN) {
        datasetFilename = datasetFN;
    }

    public ArrayList<Rate> predictRates (int nrRates) {
        ArrayList<Rate> results = new ArrayList<>();
        try {
            Instances data = new Instances (new BufferedReader(new FileReader(datasetFilename)));
            data.setClassIndex(data.numAttributes() - 1);

            LinearRegression model = new LinearRegression();
            model.buildClassifier(data);

            Instance predictedRate;
            Attribute timestampAttr = new Attribute("timestamp");
            for (int i = nrRates; i < data.size(); ++i) {
                predictedRate = data.get(i);
                double timestampDouble = data.instance(i).value(0);
                long timestampLong = (long) timestampDouble;
                Rate rate = new Rate(new Timestamp(timestampLong), model.classifyInstance(predictedRate));
                results.add(rate);
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return results;
    }

    private void buildARFF (Timestamp begin, Timestamp end, String currency) {

    }


    private String datasetFilename;

}