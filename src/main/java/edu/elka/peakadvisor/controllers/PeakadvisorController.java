package edu.elka.peakadvisor.controllers;

import edu.elka.peakadvisor.collector.CollectingClient;
import edu.elka.peakadvisor.model.CassandraDao;
import edu.elka.peakadvisor.collector.YahooClient;
import edu.elka.peakadvisor.model.Latest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.cassandra.config.CassandraClusterFactoryBean;
import org.springframework.data.cassandra.config.CassandraSessionFactoryBean;
import org.springframework.data.cassandra.core.CassandraOperations;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


/**
 * Created by apiotro on 04.04.17.
 */
@RestController
public class PeakadvisorController {

    @Autowired
    private CassandraClusterFactoryBean cluster;

    @Autowired
    private CassandraSessionFactoryBean session;

    @Autowired
    private CassandraOperations cassandraTemplate;

    private CassandraDao dao;

    public PeakadvisorController(){
        dao = new CassandraDao(cluster,session,cassandraTemplate);
    }

    @RequestMapping("/")
    public String hello(){
        saveOneTest();
        return dao.readOneWithCurrName(1495738800,"btc").toString();
    }

    public void saveOneTest(){

        dao = new CassandraDao(cluster,session,cassandraTemplate);//tymczasowe mam nadzieje

        CollectingClient yahooClient = new YahooClient();
        Latest latest = yahooClient.collect("https://openexchangerates.org/api/latest.json?app_id=3a2d8a0d0de044e99b3e343147852356");
        dao.saveLatest(latest);

    }

    public CassandraSessionFactoryBean getSession() {
        return session;
    }

    public void setSession(CassandraSessionFactoryBean session) {
        this.session = session;
    }

    public CassandraOperations getCassandraTemplate() {
        return cassandraTemplate;
    }

    public void setCassandraTemplate(CassandraOperations cassandraTemplate) {
        this.cassandraTemplate = cassandraTemplate;
    }

    public CassandraClusterFactoryBean getCluster() {
        return cluster;
    }

    public void setCluster(CassandraClusterFactoryBean cluster) {
        this.cluster = cluster;
    }

    public CassandraDao getDao() {
        return dao;
    }

    public void setDao(CassandraDao dao) {
        this.dao = dao;
    }


}

