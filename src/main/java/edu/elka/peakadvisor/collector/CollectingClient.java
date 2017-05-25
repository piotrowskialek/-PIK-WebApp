package edu.elka.peakadvisor.collector;

import edu.elka.peakadvisor.model.Latest;

/**
 * Created by apiotro on 27.04.17.
 */
public interface CollectingClient {
    boolean checkCommunication(String url);
    Latest collect(String url);
}
