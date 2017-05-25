package edu.elka.peakadvisor.model;

import com.datastax.driver.core.Cluster;
import com.datastax.driver.core.ResultSet;
import com.datastax.driver.core.Row;
import com.datastax.driver.core.Session;
import com.datastax.driver.core.querybuilder.QueryBuilder;
import com.datastax.driver.core.querybuilder.Select;
import org.springframework.data.cassandra.core.CassandraOperations;
import org.springframework.data.cassandra.core.CassandraTemplate;

import java.util.List;

/**
 * Created by apiotrowski on 25.05.2017.
 */
public class CassandraDao {

    public static CassandraDao dao;

    static{
        dao = new CassandraDao();
    }

    public static CassandraDao getInstance(){
        return dao;
    }

    public void saveLatest(Latest latest){

        Cluster cluster = Cluster.builder().addContactPoints("localhost").build();
        Session session = cluster.connect("pierwszy");

        CassandraOperations template = new CassandraTemplate(session);

        template.insert(latest);

//        Select selectStatement = QueryBuilder
//                .select()
//                .from("Task")
//                .allowFiltering();
//
//        selectStatement.where(QueryBuilder.eq("name", first.getName()));
//
//        ResultSet r = template.query(selectStatement);
//
//        r.forEach(d -> System.out.println(d));
//
//        List<Row> list = r.all();
//
//        int a = r.getAvailableWithoutFetching();
//
//
//        while(r.iterator().hasNext())
//            r.iterator().next();
//
//        template.queryForObject("SELECT * FROM Task WHERE name='xD' ALLOW FILTERING;", String.class);
//
//        Task select = template.selectOne(selectStatement,Task.class);
//
//        System.out.println(select);

//            selectStatement.allowFiltering();

//            selectStatement.where();

        //System.out.println(template.queryForObject(selectStatement, String.class));


//            template.truncate("Task"); //rollback do stanu sprzed otwarcia sesji chyba

        session.close();
        cluster.close();

    }

    public Latest readLatest(String name){

        Cluster cluster = Cluster.builder().addContactPoints("localhost").build();
        Session session = cluster.connect("pierwszy");
        CassandraOperations template = new CassandraTemplate(session);

        Select selectStatement = QueryBuilder
                .select()
                .from("Latest")
                .allowFiltering();

        selectStatement.where(QueryBuilder.eq("name",name));

        Latest select = template.selectOne(selectStatement,Latest.class);

        session.close();
        cluster.close();

        return select;
    }


}
