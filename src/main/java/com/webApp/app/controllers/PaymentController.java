package com.webApp.app.controllers;

import com.webApp.app.models.PaymentData;
import com.webApp.app.models.ShoppingCart;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.context.WebApplicationContext;

import java.math.BigDecimal;
import java.util.concurrent.Callable;

/**
 * Created by knery on 05/07/17.
 */
@Controller
@RequestMapping("/payment")
@Scope(value= WebApplicationContext.SCOPE_SESSION)
public class PaymentController {

    @Autowired
    private ShoppingCart shoppingCart;

    @Autowired
    private RestTemplate restTemplate;

//    @RequestMapping(value="checkout",method= RequestMethod.POST)
//    public String checkout() {
//
//        BigDecimal total = shoppingCart.getTotal();
//
//        String uriToPay = "http://book-payment.herokuapp.com/payment";
//        try {
//            String response = restTemplate.postForObject(uriToPay,new PaymentData(total), String.class);
//            return "redirect:/payment/success";
//        } catch (HttpClientErrorException exception) {
//            return "redirect:/payment/error";
//        }
//
//    }

    @RequestMapping(value = "checkout", method = RequestMethod.POST)
    public Callable<String> checkout() {

        return new Callable<String>() {
            public String call() throws Exception {

                BigDecimal total = shoppingCart.getTotal();
                String uriToPay = "http://localhost:9000/payment";
                try {

                    String response = restTemplate.postForObject(uriToPay, new PaymentData(total), String.class);

                    return "redirect:/payment/success";
                } catch (HttpClientErrorException exception) {

                    return "redirect:/payment/error";
                }
            }
        };
    }



    @RequestMapping(value="/success")
    public String success(){

        return "shoppingCart/success";
    }

    @RequestMapping(value="/error")
    public String error(){

        return "shoppingCart/error";
    }

}
