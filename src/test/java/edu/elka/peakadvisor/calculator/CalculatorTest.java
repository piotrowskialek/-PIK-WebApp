package edu.elka.peakadvisor.calculator;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Created by apiotro on 27.04.17.
 */
class CalculatorTest {

    private Calculator calculator = new Calculator();

    @Test
    void predictRatesMonotonicLinearRegression () {
        ArrayList<Rate> testRates = new ArrayList<>();
        testRates.add(new Rate (1234, 5.6));
        testRates.add(new Rate (3456, 5.6));
        List<Rate> result = calculator.predictRatesLinear(testRates, 4000, 7603);
        assertEquals(true, (5.58 < result.get(0).getPrice()) && (result.get(0).getPrice() < 5.62));
    }

    @Test
    void predictRatesLinearLinearRegression () {
        ArrayList<Rate> testRates = new ArrayList<>();
        testRates.add(new Rate (0, 10));
        testRates.add(new Rate (3600, 20));
        List<Rate> result = calculator.predictRatesLinear(testRates, 3600, 7200);
        assertEquals(true, (14.9 < result.get(2).getPrice()) && (result.get(2).getPrice() < 15.1));
    }

    @Test
    void predictRatesMonotonicPolynomialRegression7 () {
        ArrayList<Rate> testRates = new ArrayList<>();
        testRates.add(new Rate (1234, 5.6));
        testRates.add(new Rate (3456, 5.6));
        List<Rate> result = calculator.predictRatesPolynomial(testRates, 4000, 7603, 7);
        Throwable exception = assertThrows(java.lang.Exception.class, () -> {
            throw new java.lang.Exception("All class values are the same. At least two class values should be different");
        });
        assertEquals("All class values are the same. At least two class values should be different", exception.getMessage());
    }

    @Test
    void predictRatesLinearPolynomialRegression3 () {
        ArrayList<Rate> testRates = new ArrayList<>();
        testRates.add(new Rate (0, 10));
        testRates.add(new Rate (3600, 20));
        List<Rate> result = calculator.predictRatesPolynomial(testRates, 3600, 7200, 3);
        assertEquals(true, (10 < result.get(0).getPrice()) && (result.get(0).getPrice() < 60));
    }

    @Test
    void predictRatesPolynomialRegression9 () {
        ArrayList<Rate> rates = new ArrayList<>();
        rates.add(new Rate (0, 7.4));
        rates.add(new Rate (3600, 5.4));
        rates.add(new Rate (7200, 8.9));
        rates.add(new Rate (10800, 8.1));
        rates.add(new Rate(14400, 7.5));
        List<Rate> result = calculator.predictRatesPolynomial(rates, 14401, 21600, 9);
        assertEquals(true, (5 < result.get(0).getPrice()) && (result.get(0).getPrice() < 20));
    }
}