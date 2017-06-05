package edu.elka.peakadvisor.calculator;

import org.junit.jupiter.api.Test;
import weka.core.Instances;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Created by apiotro on 27.04.17.
 */
class CalculatorTest {

    private Calculator calculator = new Calculator();

    @Test
    void predictRatesMonotonic () {
        ArrayList<Rate> testRates = new ArrayList<>();
        testRates.add(new Rate (1234, 5.6));
        testRates.add(new Rate (3456, 5.6));
        ArrayList<Rate> result = calculator.predictRates(testRates, 4000, 7603);
        assertEquals(5.6, result.get(0).getPrice());
    }

    @Test
    void predictRatesLinear () {
        ArrayList<Rate> testRates = new ArrayList<>();
        testRates.add(new Rate (0, 10));
        testRates.add(new Rate (3600, 20));
        ArrayList<Rate> result = calculator.predictRates(testRates, 3600, 7200);
        assertEquals(30, result.get(0).getPrice());
    }


}