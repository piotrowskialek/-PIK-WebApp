package edu.elka.helloworld;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import java.util.logging.Logger;

/**
 * Created by apiotro on 26.03.17.
 */

@Controller
public class HelloWorldController {

    @RequestMapping("/hello")
    public ModelAndView hello(){

        ModelAndView model = new ModelAndView("hello");
        model.addObject("msg","witam świat");

        return model;
    }

}
