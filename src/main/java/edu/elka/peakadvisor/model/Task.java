package edu.elka.peakadvisor.model;

import org.springframework.data.cassandra.mapping.PrimaryKey;
import org.springframework.data.cassandra.mapping.Table;

/**
 * Created by apiotro on 19.04.17.
 */

@Table
public class Task {

    @PrimaryKey
    private final String id;
    private final String name;

    public Task(String id, String name) {
        this.id=id;
        this.name=name;
    }


    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return String.format("{ @type = %1$s, id = %2$s, name = %3$s }",
                getClass().getName(), getId(), getName());
    }


}
