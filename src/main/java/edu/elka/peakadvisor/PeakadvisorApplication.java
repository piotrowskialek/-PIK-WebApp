package edu.elka.peakadvisor;

import com.datastax.driver.core.Cluster;
import edu.elka.peakadvisor.calculator.Calculator;
import edu.elka.peakadvisor.calculator.Rate;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.data.cassandra.config.CassandraClusterFactoryBean;

import java.util.ArrayList;

@SpringBootApplication
public class PeakadvisorApplication {

	private static final Logger LOGGER = LoggerFactory.getLogger(PeakadvisorApplication.class);


	public static void main(String[] args) {

		ApplicationContext service = new AnnotationConfigApplicationContext(CassandraConfig.class);

		SpringApplication.run(PeakadvisorApplication.class, args);
	}
}
