package edu.elka.peakadvisor;

import com.datastax.driver.core.Cluster;
import com.datastax.driver.core.Session;
import com.datastax.driver.core.querybuilder.QueryBuilder;
import com.datastax.driver.core.querybuilder.Select;
import edu.elka.peakadvisor.model.Task;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.cassandra.core.CassandraOperations;
import org.springframework.data.cassandra.core.CassandraTemplate;

@SpringBootApplication
public class PeakadvisorApplication {

	private static final Logger LOGGER = LoggerFactory.getLogger(PeakadvisorApplication.class);

	public static void main(String[] args) {
		LOGGER.info("dupa");
		SpringApplication.run(PeakadvisorApplication.class, args);
	}


}
