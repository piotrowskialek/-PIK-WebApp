package edu.elka.peakadvisor.model;

import com.datastax.driver.core.querybuilder.QueryBuilder;
import com.datastax.driver.core.querybuilder.Select;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.cassandra.config.CassandraClusterFactoryBean;
import org.springframework.data.cassandra.config.CassandraSessionFactoryBean;
import org.springframework.data.cassandra.core.CassandraOperations;
import org.springframework.stereotype.Component;

import java.lang.reflect.InvocationTargetException;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;


/**
 * Created by apiotrowski on 25.05.2017.
 */

@Component
public class CassandraDao {

    @Autowired
    private CassandraClusterFactoryBean cluster;

    @Autowired
    private CassandraSessionFactoryBean session;

    @Autowired
    private CassandraOperations cassandraTemplate;


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

    public List<Double> getPricesWithTimestampRange(String name, int timestampStart, int timestampEnd){

        CassandraOperations template = this.cassandraTemplate;
        Select selectStatement = QueryBuilder
                .select()   //znowu nie dziala bez cydzyslowow, trzeba wszystko wybierac
                .from("Latest")
                .allowFiltering();

        selectStatement.where(QueryBuilder.gte("timestamp",timestampStart));
        selectStatement.where(QueryBuilder.lte("timestamp",timestampEnd));
        List<Latest> queryResult = template.select(selectStatement,Latest.class);

        List<Double> result = queryResult.stream().map((l)->{
            try {

                return (Double) l.getRates().getClass()
                        .getMethod("get"+name.toUpperCase()).invoke(l.getRates());

            } catch (IllegalAccessException e) {
                e.printStackTrace();
            } catch (NoSuchMethodException e) {
                e.printStackTrace();
            } catch (InvocationTargetException e) {
                e.printStackTrace();
            }
            return null;
        }).collect(Collectors.toList());

        return result;
        gg
    }

    public CassandraClusterFactoryBean getCluster() {
        return cluster;
    }

    public void setCluster(CassandraClusterFactoryBean cluster) {
        this.cluster = cluster;
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

}
