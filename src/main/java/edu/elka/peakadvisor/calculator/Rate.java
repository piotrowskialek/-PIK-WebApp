package edu.elka.peakadvisor.calculator;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.io.Serializable;

/**
 * Created by sylwia on 5/26/17.
 */
public class Rate implements Serializable {

    public Rate (long timestamp, double price)
    {
        this.timestamp = timestamp;
        this.price = price;
    }

    private long timestamp;
    private double price;

    public long getTimestamp () {
        return timestamp;
    }

    public double getPrice () {
        return price;
    }
}