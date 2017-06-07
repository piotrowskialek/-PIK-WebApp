package edu.elka.peakadvisor.model;

import com.datastax.driver.core.Cluster;
import com.datastax.driver.core.Session;
import edu.elka.peakadvisor.collector.CollectingClient;
import edu.elka.peakadvisor.collector.YahooClient;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.cassandra.core.CassandraOperations;
import org.springframework.data.cassandra.core.CassandraTemplate;

/**
 * Created by apiotrowski on 04.06.2017.
 */

//@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class CassandraDaoTest {


    Cluster cluster;
    Session session;
    CassandraOperations template;

    CassandraDao dao = new CassandraDao();

    CollectingClient yahooClient = new YahooClient();
    Latest latest;

    @Autowired
    private CassandraDao cassandraDao;


    @BeforeEach
    void setUp() {
        cluster = Cluster.builder().addContactPoints("localhost").build();
        session = cluster.connect("pierwszy");
        template = new CassandraTemplate(session);

        dao.setCassandraTemplate(template);
        try {
            latest = yahooClient.collect("https://openexchangerates.org/api/latest.json?app_id=3a2d8a0d0de044e99b3e343147852356");
        } catch (Exception e) {
            latest = new Latest(); //nie ma wyjscia xD
        }
    }

    @Test
    void saveLatest() throws Exception {
    }

    @Test
    void saveFew() {
    }

    @Test
    void readOne() {
    }

    @Test
    void readAll() {
        Assertions.assertNotNull(template.query("SELECT * FROM Latest ALLOW FILTERING;"));
    }

    @Test
    void readOneWithCurrName() {
    }

}