package edu.elka.peakadvisor.controllers;

import edu.elka.peakadvisor.calculator.Calculator;
import edu.elka.peakadvisor.calculator.Rate;
import edu.elka.peakadvisor.collector.CollectingClient;
import edu.elka.peakadvisor.collector.YahooClient;
import edu.elka.peakadvisor.model.CassandraDao;
import edu.elka.peakadvisor.model.Latest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.cassandra.config.CassandraClusterFactoryBean;
import org.springframework.data.cassandra.config.CassandraSessionFactoryBean;
import org.springframework.data.cassandra.core.CassandraOperations;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.*;
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
    public String index() {

//        //fake database to test getValue() method:
//        CollectingClient yahooClient = new YahooClient();
//        Latest latest = yahooClient.collect("https://openexchangerates.org/api/latest.json?app_id=f181f6f8185d40cb88f226efa37a3291");
//        int noOfRows = 20;
//        //creates noOfRows rows of data, each has timestamp incremented by 3600
//        for(int i = 0; i < noOfRows; i++){
//            latest.setTimestamp(i*3600);
//            latest.getRates().setZWL((double)i+3.0); //only ZWL changed
//            dao.saveLatest(latest);
//        }

        return "index";

    }

    @RequestMapping("/scheduler")
    public String hello2(@RequestParam(value = "step", defaultValue = "3600") Integer step) {
        startScheduler(step);
        return "Scheduler started with step=" + step.toString() + " sec.";
    }

    @RequestMapping("/getValue")
    public String getValue(
            @RequestParam(value = "currency", defaultValue = "USD") String cur,
            @RequestParam(value = "start", defaultValue = "0") Integer start,
            @RequestParam(value = "end", defaultValue = "0") Integer end,
            @RequestParam(value = "power", defaultValue = "1") Integer power
    ) {
        String returner = "{ \"currency\":\"" + cur + "\", \"history\": { ";

        if (start > end) {
            return returner + "} }";
        }
        long current = System.currentTimeMillis() / 1000;
        //zaokraglanie do najblizszej wielokrotnosci 3600
        {
            long modulo_current = current % 3600;
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

            if (modulo_current < 3600 / 2) {
                current = current - modulo_current;
            } else {
                current = current + 3600 - modulo_current;
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
            List<Double> prices = dao.getPricesWithTimestampRange(cur, start, (int) current);

            List<Rate> rates = new ArrayList<>();
            int i = 0;
            for (int timestamp = start; i < prices.size(); timestamp += 3600, ++i) {
                rates.add(new Rate(timestamp, prices.get(i)));
                returner += "\"" + timestamp + "\" : \"" + prices.get(i) + "\" ";
                if (i != (prices.size() - 1))
                    returner += ", ";
            }

            returner += "}, \"predicted\" : {";
            List<Rate> predictedRates = calculator.predictRatesPolynomial(rates, current, end, power); //(power == 1 ? calculator.predictRatesLinear(rates, current, end) :


            for (Rate rate : predictedRates) {
                returner += "\"" + rate.getTimestamp() + "\" : \"" + rate.getPrice() + "\"";
                if (rate != predictedRates.get(predictedRates.size() - 1))
                    returner += ", ";
            }

            returner += "}}";
        } catch (Exception e) {
            e.printStackTrace();
        }

        dao.getPricesWithTimestampRange("btc", 100, Integer.MAX_VALUE);
        return returner;

    }

    public void saveOneTest() {

        CollectingClient yahooClient = new YahooClient();
        Latest latest = yahooClient.collect("https://openexchangerates.org/api/latest.json?app_id=f181f6f8185d40cb88f226efa37a3291");

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

    public void startScheduler(int step) {
        //watek chodzi i co godzine zapisuje do bazy
        new Thread((Runnable) () -> {
            while (true) {
                saveOneTest();
                try {
                    //czekaj 3600s czyli 1 godzine
                    TimeUnit.SECONDS.sleep(step);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }).start();
    }


    @RequestMapping("/historical")
    public String indexXX() {

        double historicalRates[] =
                {
                        3.7000,
                        3.7000,
                        3.7000,
                        3.7000,
                        3.7000,
                        3.7000,
                        3.7000,
                        3.7000,
                        3.6599,
                        3.6217,
                        3.5855,
                        3.5510,
                        3.5183,
                        3.4865,
                        3.4552,
                        3.4243,
                        3.3939,
                        3.3641,
                        3.3350,
                        3.3069,
                        3.2797,
                        3.2537,
                        3.2289,
                        3.2054,
                        3.1834,
                        3.1628,
                        3.1438,
                        3.1264,
                        3.1107,
                        3.0967,
                        3.0845,
                        3.0740,
                        3.0653,
                        3.0582,
                        3.0528,
                        3.0489,
                        3.0465,
                        3.0455,
                        3.0457,
                        3.0471,
                        3.0495,
                        3.0528,
                        3.0567,
                        3.0612,
                        3.0661,
                        3.0713,
                        3.0766,
                        3.0819,
                        3.0871,
                        3.0921,
                        3.0967,
                        3.1009,
                        3.1046,
                        3.1078,
                        3.1105,
                        3.1126,
                        3.1141,
                        3.1152,
                        3.1157,
                        3.1157,
                        3.1153,
                        3.1145,
                        3.1134,
                        3.1121,
                        3.1105,
                        3.1088,
                        3.1070,
                        3.1051,
                        3.1032,
                        3.1014,
                        3.0997,
                        3.0981,
                        3.0966,
                        3.0952,
                        3.0941,
                        3.0931,
                        3.0923,
                        3.0917,
                        3.0912,
                        3.0910,
                        3.0909,
                        3.0909,
                        3.0911,
                        3.0914,
                        3.0918,
                        3.0923,
                        3.0929,
                        3.0934,
                        3.0940,
                        3.0947,
                        3.0953,
                        3.0959,
                        3.0964,
                        3.0970,
                        3.0974,
                        3.0979,
                        3.0982,
                        3.0985,
                        3.0988,
                        3.0989,
                        3.0991,
                        3.0991,
                        3.0991,
                        3.0991,
                        3.0990,
                        3.0989,
                        3.0987,
                        3.0985,
                        3.0984,
                        3.0981,
                        3.0979,
                        3.0977,
                        3.0975,
                        3.0973,
                        3.0971,
                        3.0970,
                        3.0968,
                        3.0967,
                        3.0966,
                        3.0965,
                        3.0964,
                        3.0964,
                        3.0963,
                        3.0963,
                        3.0963,
                        3.0964,
                        3.0964,
                        3.0964,
                        3.0965,
                        3.0966,
                        3.0966,
                        3.0967,
                        3.0968,
                        3.0968,
                        3.0969,
                        3.0970,
                        3.0970,
                        3.0971,
                        3.0971,
                        3.0972,
                        3.0972,
                        3.0972,
                        3.0973,
                        3.0973,
                        3.0973,
                        3.0973,
                        3.0973,
                        3.0973,
                        3.0972,
                        3.0972,
                        3.0972,
                        3.0972,
                        3.0972,
                        3.0971,
                        3.0971,
                        3.0971,
                        3.0971,
                        3.0970,
                        3.0970,
                        3.0970,
                        3.0970,
                        3.0970,
                        3.0970,
                        3.0970,
                        3.0970,
                        3.0970,
                        3.0970,
                        3.0970,
                        3.0970,
                        3.0970,
                        3.0970,
                        3.0970,
                        3.0970,
                        3.0970,
                        3.0970,
                        3.0970,
                        3.0970,
                        3.0970,
                        3.0970,
                        3.0970,
                        3.0970,
                        3.0970,
                        3.0971,
                        3.0971,
                        3.0971,
                        3.0971,
                        3.0971,
                        3.0971,
                        3.1292,
                        3.1597,
                        3.1887,
                        3.2162,
                        3.2424,
                        3.2677,
                        3.2920,
                        3.3152,
                        3.3368,
                        3.3565,
                        3.3740,
                        3.3891,
                        3.4020,
                        3.4126,
                        3.4212,
                        3.4279,
                        3.4331,
                        3.4369,
                        3.4397,
                        3.4417,
                        3.4430,
                        3.4439,
                        3.4444,
                        3.4447,
                        3.4449,
                        3.4450,
                        3.4450,
                        3.4450,
                        3.4450,
                        3.4450,
                        3.4450,
                        3.4450,
                        3.4450,
                        3.4450,
                        3.4450,
                        3.4451,
                        3.4451,
                        3.4451,
                        3.4452,
                        3.4452,
                        3.4452,
                        3.4452,
                        3.4453,
                        3.4453,
                        3.4453,
                        3.4453,
                        3.4454,
                        3.4454,
                        3.4454,
                        3.4454,
                        3.4454,
                        3.4455,
                        3.4455,
                        3.4455,
                        3.4455,
                        3.4455,
                        3.4455,
                        3.4455,
                        3.4455,
                        3.4456,
                        3.4456,
                        3.4456,
                        3.4456,
                        3.4456,
                        3.4456,
                        3.4456,
                        3.4456,
                        3.4456,
                        3.4456,
                        3.4456,
                        3.4456,
                        3.4456,
                        3.4456,
                        3.4456,
                        3.4456,
                        3.4456,
                        3.4456,
                        3.4456,
                        3.4456,
                        3.4457,
                        3.4457,
                        3.4457,
                        3.4457,
                        3.4457,
                        3.4457,
                        3.4457,
                        3.4457,
                        3.4457,
                        3.4457,
                        3.4457,
                        3.4457,
                        3.4457,
                        3.4457,
                        3.4457,
                        3.4457,
                        3.4457,
                        3.4457,
                        3.4457,
                        3.4457,
                        3.4457,
                        3.4457,
                        3.4457,
                        3.4457,
                        3.4457,
                        3.4457,
                        3.4457,
                        3.4457,
                        3.4457,
                        3.4457,
                        3.4457,
                        3.4457,
                        3.4457,
                        3.4457,
                        3.4457,
                        3.4457,
                        3.4457,
                        3.4457,
                        3.4457,
                        3.4457,
                        3.4457,
                        3.4457,
                        3.4457,
                        3.4457,
                        3.4457,
                        3.4457,
                        3.4457,
                        3.4457,
                        3.4457,
                        3.4457,
                        3.4457,
                        3.4457,
                        3.4457,
                        3.4457,
                        3.4457,
                        3.4457,
                        3.4457,
                        3.4457,
                        3.4457,
                        3.4457,
                        3.4457,
                        3.4457,
                        3.4457,
                        3.4457,
                        3.4457,
                        3.4457,
                        3.4457,
                        3.4457,
                        3.4457,
                        3.4457,
                        3.4457,
                        3.4457,
                        3.4457,
                        3.4457,
                        3.4457,
                        3.4457,
                        3.4457,
                        3.4457,
                        3.4457,
                        3.4457,
                        3.4457,
                        3.4457,
                        3.4457,
                        3.4457,
                        3.4457,
                        3.4457,
                        3.4457,
                        3.4457,
                        3.4457,
                        3.4457,
                        3.4457,
                        3.4457,
                        3.4457,
                        3.4457,
                        3.4457,
                        3.4457,
                        3.4457,
                        3.4457,
                        3.4457,
                        3.4457,
                        3.4457,
                        3.4457,
                        3.4457,
                        3.4457,
                        3.4457,
                        3.4457,
                        3.4457,
                        3.4457,
                        3.4457,
                        3.4457,
                        3.4457,
                        3.4457,
                        3.4457,
                        3.4457,
                        3.4457,
                        3.4457,
                        3.4457,
                        3.4457,
                        3.4457,
                        3.4457,
                        3.4457,
                        3.3735,
                        3.3048,
                        3.2396,
                        3.1776,
                        3.1187,
                        3.0617,
                        3.0061,
                        2.9524,
                        2.9009,
                        2.8523,
                        2.8071,
                        2.7659,
                        2.7289,
                        2.7000,
                        2.7000,
                        2.7000,
                        2.7000,
                        2.7000,
                        2.7000,
                        2.7000,
                        2.7023,
                        2.7085,
                        2.7170,
                        2.7256,
                        2.7334,
                        2.7399,
                        2.7451,
                        2.7491,
                        2.7524,
                        2.7552,
                        2.7579,
                        2.7609,
                        2.7642,
                        2.7679,
                        2.7722,
                        2.7769,
                        2.7821,
                        2.7876,
                        2.7935,
                        2.7996,
                        2.8059,
                        2.8124,
                        2.8190,
                        2.8255,
                        2.8320,
                        2.8384,
                        2.8446,
                        2.8505,
                        2.8559,
                        2.8609,
                        2.8650,
                        2.8683,
                        2.8706,
                        2.8720,
                        2.8726,
                        2.8723,
                        2.8711,
                        2.8693,
                        2.8667,
                        2.8636,
                        2.8600,
                        2.8560,
                        2.8517,
                        2.8472,
                        2.8427,
                        2.8382,
                        2.8339,
                        2.8298,
                        2.8260,
                        2.8227,
                        2.8197,
                        2.8172,
                        2.8153,
                        2.8139,
                        2.8131,
                        2.8129,
                        2.8131,
                        2.8139,
                        2.8152,
                        2.8169,
                        2.8190,
                        2.8214,
                        2.8240,
                        2.8269,
                        2.8298,
                        2.8328,
                        2.8358,
                        2.8386,
                        2.8414,
                        2.8439,
                        2.8461,
                        2.8481,
                        2.8497,
                        2.8509,
                        2.8518,
                        2.8523,
                        2.8525,
                        2.8522,
                        2.8516,
                        2.8507,
                        2.8496,
                        2.8481,
                        2.8465,
                        2.8447,
                        2.8428,
                        2.8408,
                        2.8388,
                        2.8368,
                        2.8349,
                        2.8331,
                        2.8315,
                        2.8300,
                        2.8288,
                        2.8277,
                        2.8269,
                        2.8264,
                        2.8261,
                        2.8260,
                        2.8262,
                        2.8266,
                        2.8272,
                        2.8280,
                        2.8290,
                        2.8301,
                        2.8313,
                        2.8326,
                        2.8339,
                        2.8352,
                        2.8365,
                        2.8378,
                        2.8390,
                        2.8400,
                        2.8410,
                        2.8418,
                        2.8425,
                        2.8430,
                        2.8434,
                        2.8436,
                        2.8436,
                        2.8434,
                        2.8431,
                        2.8427,
                        2.8422,
                        2.8415,
                        2.8407,
                        2.8399,
                        2.8391,
                        2.8382,
                        2.8373,
                        2.8364,
                        2.8356,
                        2.8348,
                        2.8341,
                        2.8335,
                        2.8330,
                        2.8325,
                        2.8322,
                        2.8320,
                        2.8319,
                        2.8319,
                        2.8320,
                        2.8322,
                        2.8325,
                        2.8329,
                        2.8333,
                        2.8338,
                        2.8344,
                        2.8349,
                        2.8355,
                        2.8361,
                        2.8367,
                        2.8372,
                        2.8377,
                        2.8382,
                        2.8386,
                        2.8390,
                        2.8393,
                        2.8395,
                        2.8396,
                        2.8397,
                        2.8396,
                        2.8396,
                        2.8394,
                        2.8392,
                        2.8390,
                        2.8387,
                        2.8383,
                        2.8380,
                        2.8376,
                        2.8372,
                        2.8368,
                        2.8364,
                        2.8360,
                        2.8357,
                        2.8354,
                        2.8351,
                        2.8349,
                        2.8347,
                        2.8346,
                        2.8345,
                        2.9179,
                        2.9973,
                        3.0727,
                        3.1445,
                        3.2127,
                        3.2785,
                        3.3418,
                        3.4018,
                        3.4569,
                        3.5058,
                        3.5476,
                        3.5817,
                        3.6081,
                        3.6276,
                        3.6411,
                        3.6501,
                        3.6560,
                        3.6600,
                        3.6630,
                        3.6657,
                        3.6683,
                        3.6710,
                        3.6738,
                        3.6767,
                        3.6797,
                        3.6826,
                        3.6856,
                        3.6886,
                        3.6915,
                        3.6943,
                        3.6972,
                        3.7000,
                        3.7027,
                        3.7054,
                        3.7081,
                        3.7107,
                        3.7133,
                        3.7159,
                        3.7184,
                        3.7209,
                        3.7234,
                        3.7258,
                        3.7282,
                        3.7306,
                        3.7330,
                        3.7353,
                        3.7376,
                        3.7399,
                        3.7422,
                        3.7444,
                        3.7466,
                        3.7488,
                        3.7510,
                        3.7531,
                        3.7552,
                        3.7573,
                        3.7594,
                        3.7615,
                        3.7635,
                        3.7656,
                        3.7676,
                        3.7696,
                        3.7715,
                        3.7735,
                        3.7754,
                        3.7774,
                        3.7793,
                        3.7812,
                        3.7831,
                        3.7849,
                        3.7868,
                        3.7886,
                        3.7904,
                        3.7922,
                        3.7940,
                        3.7958,
                        3.7976,
                        3.7994,
                        3.8011,
                        3.8028,
                        3.8046,
                        3.8063,
                        3.8080,
                        3.8097,
                        3.8113,
                        3.8130,
                        3.8147,
                        3.8163,
                        3.8179,
                        3.8196,
                        3.8212,
                        3.8228,
                        3.8244,
                        3.8260,
                        3.8275,
                        3.8291,
                        3.8307,
                        3.8322,
                        3.8338,
                        3.8353,
                        3.8368,
                        3.8383,
                        3.8398,
                        3.8413,
                        3.8428,
                        3.8443,
                        3.8458,
                        3.8472,
                        3.8487,
                        3.8502,
                        3.8516,
                        3.8530,
                        3.8545,
                        3.8559,
                        3.8573,
                        3.8587,
                        3.8601,
                        3.8615,
                        3.8629,
                        3.8643,
                        3.8657,
                        3.8671,
                        3.8684,
                        3.8698,
                        3.8711,
                        3.8725,
                        3.8738,
                        3.8752,
                        3.8765,
                        3.8778,
                        3.8791,
                        3.8805,
                        3.8818,
                        3.8831,
                        3.8844,
                        3.8857,
                        3.8869,
                        3.8882,
                        3.8895,
                        3.8908,
                        3.8920,
                        3.8933,
                        3.8946,
                        3.8958,
                        3.8971,
                        3.8983,
                        3.8995,
                        3.9008,
                        3.9020,
                        3.9032,
                        3.9045,
                        3.9057,
                        3.9069,
                        3.9081,
                        3.9093,
                        3.9105,
                        3.9117,
                        3.9129,
                        3.9141,
                        3.9152,
                        3.9164,
                        3.9176,
                        3.9188,
                        3.9199,
                        3.9211,
                        3.9223,
                        3.9234,
                        3.9246,
                        3.9257,
                        3.9268,
                        3.9280,
                        3.9291,
                        3.9303,
                        3.9314,
                        3.9325,
                        3.9336,
                        3.9348,
                        3.9359,
                        3.9370,
                        3.9381,
                        3.9392,
                        3.9403,
                        3.9414,
                        3.9425,
                        3.9436,
                        3.9447,
                        3.9458,
                        3.9468,
                        3.9479,
                        3.9490,
                        3.9501,
                        3.9511,
                        3.9522,
                        3.9533,
                        3.9543,
                        3.9554,
                        3.9564,
                        3.9575,
                        3.9585,
                        3.9596,
                        3.8972,
                        3.8380,
                        3.7818,
                        3.7284,
                        3.6777,
                        3.6284,
                        3.5795,
                        3.5308,
                        3.4822,
                        3.4339,
                        3.3860,
                        3.3387,
                        3.2922,
                        3.2467,
                        3.2024,
                        3.1595,
                        3.1183,
                        3.0790,
                        3.0418,
                        3.0070,
                        2.9749,
                        2.9455,
                        2.9192,
                        2.8959,
                        2.8759,
                        2.8592,
                        2.8459,
                        2.8359,
                        2.8292,
                        2.8258,
                        2.8254,
                        2.8279,
                        2.8332,
                        2.8409,
                        2.8508,
                        2.8625,
                        2.8757,
                        2.8901,
                        2.9053,
                        2.9210,
                        2.9366,
                        2.9520,
                        2.9667,
                        2.9804,
                        2.9929,
                        3.0039,
                        3.0132,
                        3.0207,
                        3.0263,
                        3.0299,
                        3.0317
                };


        //fake historical database
        //noOfRows means number of hours from now


        CollectingClient yahooClient = new YahooClient();
        Latest latest = yahooClient.collect("https://openexchangerates.org/api/latest.json?app_id=f181f6f8185d40cb88f226efa37a3291");

        int now = 1497006000; //11:00 dnia 9 czerwca
        int noOfRows = 720;

        //creates noOfRows rows of data, each has timestamp DEcremented by 3600
        for (int i = 0; i < noOfRows; i++) {
            latest.setTimestamp(now - i * 3600);
            latest.getRates().setPLN(historicalRates[i]);
            dao.saveLatest(latest);
        }

        return "historical";

    }
}