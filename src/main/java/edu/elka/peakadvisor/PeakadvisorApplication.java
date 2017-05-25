package edu.elka.peakadvisor;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class PeakadvisorApplication {

	private static final Logger LOGGER = LoggerFactory.getLogger(PeakadvisorApplication.class);

	public static void main(String[] args) {
		LOGGER.info("dupa");
		SpringApplication.run(PeakadvisorApplication.class, args);

	}




}
