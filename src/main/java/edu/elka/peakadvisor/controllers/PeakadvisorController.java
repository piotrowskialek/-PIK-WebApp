package edu.elka.peakadvisor.controllers;

import org.springframework.data.annotation.Id;
import org.springframework.data.repository.Repository;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.datastax.driver.core.*;

import java.io.Serializable;


/**
 * Created by apiotro on 04.04.17.
 */
@RestController
public class PeakadvisorController {

    @RequestMapping("/")
    public String hello(){
        return "hello";
    }

}

//interface CrudRepository<T, ID extends Serializable> extends Repository<T, ID> {
//    <S extends T> S save(S entity);
//    T findOne(Id primaryKey);
//}
