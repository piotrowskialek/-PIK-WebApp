package edu.elka.peakadvisor.model;

import com.datastax.driver.core.Cluster;
import com.datastax.driver.core.Session;
import com.datastax.driver.core.querybuilder.QueryBuilder;
import com.datastax.driver.core.querybuilder.Select;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.cassandra.config.CassandraClusterFactoryBean;
import org.springframework.data.cassandra.config.CassandraSessionFactoryBean;
import org.springframework.data.cassandra.core.CassandraOperations;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;


/**
 * Created by apiotrowski on 25.05.2017.
 */


public class CassandraDao {

    @Autowired
    private CassandraClusterFactoryBean cluster;

    @Autowired
    private CassandraSessionFactoryBean session;    //cos nie owija automatycznie

    @Autowired
    private CassandraOperations cassandraTemplate;

    public CassandraDao(CassandraClusterFactoryBean cluster, CassandraSessionFactoryBean session,
                        CassandraOperations cassandraTemplate) {
        this.cluster=cluster;
        this.session=session;
        this.cassandraTemplate=cassandraTemplate;
    }

    public void saveLatest(Latest latest){
        CassandraOperations template = this.cassandraTemplate;
        template.insert(latest);
    }

    public void saveFew(Collection<Latest> collection){
        collection.stream().forEach(col->saveLatest(col));
    }

    public Latest readOne(int timestamp){

        CassandraOperations template = this.cassandraTemplate;
        Select selectStatement = QueryBuilder
                .select()
                .from("Latest")
                .allowFiltering();

        selectStatement.where(QueryBuilder.eq("timestamp",timestamp));
        Latest result = template.selectOne(selectStatement,Latest.class);

        return result;
    }

    public List<Latest> readAll(){

        CassandraOperations template = this.cassandraTemplate;
        Select selectStatement = QueryBuilder
                .select()
                .from("Latest")
                .allowFiltering();

        List<Latest> result = template.select(selectStatement,Latest.class);

        return result;
    }

    public Latest readOneWithCurrName(int timestamp, String name){

        CassandraOperations template = this.cassandraTemplate;
        Latest result = template.selectOne("SELECT timestamp,base,disclaimer,license,rates."+name+" " +
                "FROM latest WHERE timestamp="+timestamp+";",Latest.class);
        //tak wiem ze to ma podatnosc, ale jest problem z cudzyslowami przy normalnym chainowaniu
        //chainuje "rates.btc" zamiast rates.btc, nie potrafie tego naprawic
        return result;
    }

}
