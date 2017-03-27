package edu.elka.helloworld.edu.elka.helloworld.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import java.util.logging.Logger;

/**
 * Created by apiotro on 26.03.17.
 */

@RestController
public class HelloWorldController {

    private static int counter=0;

    @RequestMapping("/hello")
    public ModelAndView hello(){

        ModelAndView model = new ModelAndView("hello");
        model.addObject("msg",++counter);

        return model;
    }

    @RequestMapping("/hello2")
    public ModelAndView hello2(){
        ModelAndView model = new ModelAndView("hello");
        model.addObject("msg",++counter);

        return model;
    }

}


