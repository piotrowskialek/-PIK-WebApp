package edu.elka.peakadvisor.collector;

/**
 * Created by apiotro on 27.04.17.
 */
public class YahooClient implements CollectingClient{

    @Override
    public boolean checkCommunication(String url) {
        return false;
    }

    @Override
    public boolean collect(String url) {
        return false;
    }
}
