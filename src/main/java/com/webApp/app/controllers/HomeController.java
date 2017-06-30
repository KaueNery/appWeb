package com.webApp.app.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by knery on 24/06/17.
 */

@Controller
public class HomeController {

    @RequestMapping("/home")
    public String index(){

        System.out.println("carregando os produtos");
        return "helloWorld";
    }

}
