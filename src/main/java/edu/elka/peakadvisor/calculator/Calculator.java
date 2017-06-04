//package edu.elka.peakadvisor.calculator;
//
//import java.util.Collection;
//import org.apache.commons.math3.stat.regression.SimpleRegression;
//import edu.elka.peakadvisor.calculator.Rate;
//
///**
// * Created by apiotro on 27.04.17.
// */
//public class Calculator {
//
//    public double calculateProfit(Collection<Rate> collection, Double predictedValue){
//        SimpleRegression simpleRegression = new SimpleRegression();
//
//        collection.forEach((r)-> {
//            simpleRegression.addData(r.getTimestamp(), r.getPrice());
//        });
//
//        return simpleRegression.predict(predictedValue);
//    }
//
//}
