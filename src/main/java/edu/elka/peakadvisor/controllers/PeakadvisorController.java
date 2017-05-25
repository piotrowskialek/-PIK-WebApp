package edu.elka.peakadvisor.controllers;

import edu.elka.peakadvisor.model.CassandraDao;
import edu.elka.peakadvisor.collector.YahooClient;
import edu.elka.peakadvisor.model.Latest;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


/**
 * Created by apiotro on 04.04.17.
 */
@RestController
public class PeakadvisorController {

    @RequestMapping("/")
    public String hello(){

        return CassandraDao.getInstance().readLatest("xD");

    }
  
  public void saveNewToDB(){
        YahooClient yahooClient = new YahooClient();
        Latest latest = yahooClient.collect("https://openexchangerates.org/api/latest.json?app_id=f181f6f8185d40cb88f226efa37a3291");
        
  }

}

