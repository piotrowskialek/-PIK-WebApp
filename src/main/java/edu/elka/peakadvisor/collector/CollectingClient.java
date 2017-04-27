package edu.elka.peakadvisor.collector;

/**
 * Created by apiotro on 27.04.17.
 */
public interface CollectingClient {
    boolean checkCommunication(String url);
    boolean collect(String url);
}
