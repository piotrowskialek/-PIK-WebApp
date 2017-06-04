package edu.elka.peakadvisor.calculator;

import java.io.Serializable;
import java.sql.Timestamp;

/**
 * Created by sylwia on 5/26/17.
 */
public class Rate implements Serializable {

    public Rate (Timestamp timestamp, double price)
    {
        this.timestamp = timestamp;
        this.price = price;
    }

    private Timestamp timestamp;
    private double price;

    public Timestamp getTimestamp () {
        return timestamp;
    }

    public double getPrice () {
        return price;
    }
}