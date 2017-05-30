package edu.elka.peakadvisor.controllers;

import edu.elka.peakadvisor.collector.CollectingClient;
import edu.elka.peakadvisor.collector.YahooClient;
import edu.elka.peakadvisor.model.CassandraDao;
import edu.elka.peakadvisor.model.Latest;
import edu.elka.peakadvisor.model.Rates;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.cassandra.config.CassandraClusterFactoryBean;
import org.springframework.data.cassandra.config.CassandraSessionFactoryBean;
import org.springframework.data.cassandra.core.CassandraOperations;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.lang.reflect.Method;
import java.util.concurrent.TimeUnit;


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

    public PeakadvisorController() {
        dao = new CassandraDao(cluster,session,cassandraTemplate);

    }


    @RequestMapping("/")
    public String hello(){

       //fake database to test getValue() method:
        CollectingClient yahooClient = new YahooClient();
        Latest latest = yahooClient.collect("https://openexchangerates.org/api/latest.json?app_id=3a2d8a0d0de044e99b3e343147852356");
        int noOfRows = 20;
        //creates noOfRows rows of data, each has timestamp incremented by 3600
        for(int i = 0; i < noOfRows; i++){
            latest.setTimestamp(i*3600);
            latest.getRates().setZWL((double)i+3.0); //only ZWL changed

            dao = new CassandraDao(cluster,session,cassandraTemplate);
            dao.saveLatest(latest);
        }



        return "/ started.";
    }

    @RequestMapping("/scheduler")
    public String hello2(){
        startScheduler();
        return "Scheduler started.";
    }

    @RequestMapping("/getValue")
    public String getValue(
            @RequestParam(value="currency", defaultValue="USD") String cur,
            @RequestParam(value="start", defaultValue="0") Integer start,
            @RequestParam(value="end", defaultValue="1") Integer end
    ){
        String returner="{ \"currency\":\""+cur+"\", \"times\": { ";

        try {
            Method m = Rates.class.getMethod("get"+cur);
            for(int ts = start; ts <= end; ts+=3600){
                dao = new CassandraDao(cluster,session,cassandraTemplate);
                returner += "\""+ts+"\":\""+m.invoke(dao.readOne(ts).getRates(), null)+"\"";
                if(ts != end){
                    returner += ", ";
                }
                else if(ts == end){
                    returner += " } }";
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
            return returner;
    }

    public void saveOneTest(){

        dao = new CassandraDao(cluster,session,cassandraTemplate);//tymczasowe mam nadzieje

        CollectingClient yahooClient = new YahooClient();
        Latest latest = yahooClient.collect("https://openexchangerates.org/api/latest.json?app_id=3a2d8a0d0de044e99b3e343147852356");

        /*
        DO USUNIECIA W PRODUKCJi - tu konieczne aby timestamp byl
        inny przy zbieraniu czestszym niz 1h
         */
        //latest.setTimestamp((int)(System.currentTimeMillis()/1000L));
        dao.saveLatest(latest);
        System.out.println("saveOneTest() poszlo");

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

    public void startScheduler(){
        //watek chodzi i co godzine zapisuje do bazy
        new Thread((Runnable) ()->{while(true){
            saveOneTest();
            try {
                //czekaj 3600s czyli 1 godzine
                TimeUnit.SECONDS.sleep(3600);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }}).start();
    }
}

