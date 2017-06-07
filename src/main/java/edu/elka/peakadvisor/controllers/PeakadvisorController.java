package edu.elka.peakadvisor.controllers;

import edu.elka.peakadvisor.calculator.Calculator;
import edu.elka.peakadvisor.calculator.Rate;
import edu.elka.peakadvisor.collector.CollectingClient;
import edu.elka.peakadvisor.collector.YahooClient;
import edu.elka.peakadvisor.model.CassandraDao;
import edu.elka.peakadvisor.model.Latest;
import edu.elka.peakadvisor.model.Rates;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.cassandra.config.CassandraClusterFactoryBean;
import org.springframework.data.cassandra.config.CassandraSessionFactoryBean;
import org.springframework.data.cassandra.core.CassandraOperations;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;
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

    @Autowired
    private CassandraDao dao;

    @Autowired
    private Calculator calculator;

    @RequestMapping("/")
    public String index(){

        //fake database to test getValue() method:
        CollectingClient yahooClient = new YahooClient();
        Latest latest = yahooClient.collect("https://openexchangerates.org/api/latest.json?app_id=3a2d8a0d0de044e99b3e343147852356");
        int noOfRows = 20;
        //creates noOfRows rows of data, each has timestamp incremented by 3600
        for(int i = 0; i < noOfRows; i++){
            latest.setTimestamp(i*3600);
            latest.getRates().setZWL((double)i+3.0); //only ZWL changed
            dao.saveLatest(latest);
        }

        return "index";

    }

    @RequestMapping("/scheduler")
    public String hello2(@RequestParam(value="step", defaultValue="3600") Integer step){
        startScheduler(step);
        return "Scheduler started with step="+step.toString()+" sec.";
    }

    @RequestMapping("/getValue")
    public String getValue(
            @RequestParam(value="currency", defaultValue="USD") String cur,
            @RequestParam(value="start", defaultValue="0") Integer start,
            @RequestParam(value="end", defaultValue="0") Integer end
    ){
        String returner="{ \"currency\":\""+cur+"\", \"times\": { ";

        if(start>end){
            return returner+"} }";
        }

        //zaokraglanie do najblizszej wielokrotnosci 3600
        {
            int modulo_start = start % 3600;
            int modulo_end = end % 3600;

            if (modulo_start < 3600 / 2) {
                start = start - modulo_start;
            } else {
                start = start + 3600 - modulo_start;
            }

            if (modulo_end < 3600 / 2) {
                end = end - modulo_end;
            } else {
                end = end + 3600 - modulo_end;
            }
        }


        /*przydalaby sie metoda zwracajaca minimalny i maksymalny Timestamp zapisany w bazie
        {
            int minTimestamp = getMinTimestampFromDB();
            int maxTimestamp = getMaxTimestampFromDB();
            if(start<minTimestamp) start = minTimestamp;
            if(end>maxTimestamp) end = maxTimestamp;
        }*/

        try {
            List<Double> prices = dao.getPricesWithTimestampRange(cur, start, end);
            ArrayList<Rate> rates = new ArrayList<>();
            int i = 0;
            for (int timestamp = start; i < prices.size(); timestamp += 3600, ++i) {
                rates.add(new Rate(timestamp, prices.get(i)));
            }

            ArrayList<Rate> predictedRates = calculator.predictRatesLinear(rates, start, end);
            for (Rate rate : predictedRates) {
                returner += "\"" + rate.getTimestamp() + "\" : \"" + rate.getPrice() + "\" ";
                if (rate != predictedRates.get(predictedRates.size() - 1))
                    returner += ", ";
            }

            returner += "}}";
        } catch (Exception e) {
            e.printStackTrace();
        }

        saveOneTest();
        dao.getPricesWithTimestampRange("btc",100,Integer.MAX_VALUE);
        return returner;

    }

    public void saveOneTest(){


        CollectingClient yahooClient = new YahooClient();
        Latest latest = yahooClient.collect("https://openexchangerates.org/api/latest.json?app_id=3a2d8a0d0de044e99b3e343147852356");

        /*
        DO USUNIECIA W PRODUKCJi - tu konieczne aby timestamp byl
        inny przy zbieraniu czestszym niz 1h
         */
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

    public Calculator getCalculator() {
        return calculator;
    }

    public void setCalculator(Calculator calculator) {
        this.calculator = calculator;
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

    public void startScheduler(int step){
        //watek chodzi i co godzine zapisuje do bazy
        new Thread((Runnable) ()->{while(true){
            saveOneTest();
            try {
                //czekaj 3600s czyli 1 godzine
                TimeUnit.SECONDS.sleep(step);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }}).start();
    }
}