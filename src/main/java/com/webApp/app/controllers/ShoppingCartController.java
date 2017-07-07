package com.webApp.app.controllers;

import com.webApp.app.daos.ProductDAO;
import com.webApp.app.models.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.servlet.ModelAndView;

import java.math.BigDecimal;
import java.util.*;
import java.util.concurrent.Callable;

/**
 * Created by knery on 03/07/17.
 */

@Controller
@RequestMapping("/shopping")
@Scope(value= WebApplicationContext.SCOPE_REQUEST)
public class ShoppingCartController {

    @Autowired
    private ProductDAO productDAO;
    @Autowired
    private ShoppingCart shoppingCart;

    @RequestMapping(method=RequestMethod.POST)
    public ModelAndView add(Integer productId, BookType bookType){
            ShoppingItem item = createItem(productId, bookType);
            shoppingCart.add(item);
            Collection<ShoppingItem> items = shoppingCart.getList();
            for(ShoppingItem itemCol : items){
                System.out.println("MOTHER FUCKER " + itemCol.getProduct().getTitle());
            }

            return new ModelAndView("redirect:/produtos");
    }

    @RequestMapping(method=RequestMethod.GET)
    public String items(){
        return "shoppingCart/items";
    }

    private ShoppingItem createItem(Integer productId,
                                    BookType bookType) {
        Product product = productDAO.find(productId);
        ShoppingItem item = new ShoppingItem(product,bookType);
        return item;
    }



}
