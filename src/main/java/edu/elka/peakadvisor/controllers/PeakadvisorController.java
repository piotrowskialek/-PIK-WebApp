package edu.elka.peakadvisor.controllers;

import edu.elka.peakadvisor.collector.YahooClient;
import edu.elka.peakadvisor.model.Latest;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


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
    public Latest hello(){
        YahooClient yahooClient = new YahooClient();
        Latest latest = yahooClient.collect("https://openexchangerates.org/api/latest.json?app_id=f181f6f8185d40cb88f226efa37a3291");
        return latest;

    }

}

