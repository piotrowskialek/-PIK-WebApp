package edu.elka.peakadvisor;

import com.datastax.driver.core.Cluster;
import com.datastax.driver.core.Session;
import com.datastax.driver.core.querybuilder.QueryBuilder;
import com.datastax.driver.core.querybuilder.Select;
import edu.elka.peakadvisor.model.Task;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.cassandra.core.CassandraOperations;
import org.springframework.data.cassandra.core.CassandraTemplate;

@SpringBootApplication
public class PeakadvisorApplication {

	public static void main(String[] args) {
		SpringApplication.run(PeakadvisorApplication.class, args);
		cassandraStart();
	}

	private static void cassandraStart(){

		Cluster cluster = Cluster.builder().addContactPoints("localhost").build();
		Session session = cluster.connect("pierwszy");

		CassandraOperations template = new CassandraTemplate(session);

		Task first = template.insert(new Task("1","chujxD"));

		Select selectStatement = QueryBuilder.select().from("task");
		selectStatement.where(QueryBuilder.eq("id", first.getId()));

		System.out.println(template.queryForObject(selectStatement, Task.class).getId());

		template.truncate("task");

		session.close();
		cluster.close();

	}
}
