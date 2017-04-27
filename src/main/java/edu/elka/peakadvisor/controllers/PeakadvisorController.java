package edu.elka.peakadvisor.controllers;


import org.springframework.data.annotation.Id;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.datastax.driver.core.*;

import java.io.Serializable;


/**
 * Created by apiotro on 04.04.17.
 */
@RestController
public class PeakadvisorController {

    public PeakadvisorController(){
//
//            Cluster cluster = Cluster.builder().addContactPoints("localhost").build();
//            Session session = cluster.connect("pierwszy");
//
//            CassandraOperations template = new CassandraTemplate(session);
//
//            Task first = template.insert(new Task("1","xD"));
//
//            Select selectStatement = QueryBuilder.select().from("task");
//            selectStatement.where(QueryBuilder.eq("id", first.getId()));
//
//            System.out.println(template.queryForObject(selectStatement, Task.class).getId());
//
//            template.truncate("task");
//
//            session.close();
//            cluster.close();


    }

    @RequestMapping("/")
    public String hello(){

        return "hello";

    }

}

