package edu.elka.peakadvisor.controllers;

import edu.elka.peakadvisor.model.CassandraDao;
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

}

