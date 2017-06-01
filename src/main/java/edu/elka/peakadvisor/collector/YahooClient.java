package edu.elka.peakadvisor.collector;

import edu.elka.peakadvisor.model.Latest;
import org.springframework.web.client.RestTemplate;

/**
 * Created by apiotro on 27.04.17.
 */
public class YahooClient implements CollectingClient{

    @Override
    public boolean checkCommunication(String url) {

        return false;
    }

    @Override
    //nasz URL: https://openexchangerates.org/api/latest.json?app_id=f181f6f8185d40cb88f226efa37a3291
    public Latest collect(String url) {

        RestTemplate restTemplate = new RestTemplate();
        Latest latest = restTemplate.getForObject(url, Latest.class);

        return latest;

    }

}