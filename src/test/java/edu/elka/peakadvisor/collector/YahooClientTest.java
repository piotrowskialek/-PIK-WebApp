package edu.elka.peakadvisor.collector;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Created by apiotro on 27.04.17.
 */
class YahooClientTest {

    private YahooClient yahooClient=new YahooClient();

    @Test
    void checkCommunication() {
        assertEquals(false, yahooClient.checkCommunication("12345"));
    }

    @Test
    void collect() {
        assertEquals(false, yahooClient.collect("12345"));
    }

}