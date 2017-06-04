package edu.elka.peakadvisor.calculator;

import java.io.Serializable;

/**
 * Created by sylwia on 5/26/17.
 */
public class Rate implements Serializable {

    public Rate (Double timestamp, Double price)
    {
        this.timestamp = timestamp;
        this.price = price;
    }

    private Double timestamp;
    private Double price;

    public Double getTimestamp () {
        return timestamp;
    }

    public Double getPrice () {
        return price;
    }
}
