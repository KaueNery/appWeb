package com.webApp.app.controllers;

import com.webApp.app.daos.ProductDAO;
import com.webApp.app.models.BookType;
import com.webApp.app.models.Product;
import com.webApp.app.validators.ProductValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.transaction.Transactional;
import javax.validation.Valid;

/**
 * Created by knery on 26/06/17.
 */
@Controller
@Transactional
@RequestMapping("/produtos")
public class ProductsController {

//    @InitBinder
//    protected void initBinder(WebDataBinder binder) {
//     binder.setValidator(new ProductValidator());
//    }

    @Autowired
    private ProductDAO productDAO;

    @RequestMapping(method= RequestMethod.POST,name="saveProduct")
    public ModelAndView save(@Valid Product product,
                       BindingResult bindingResult,
                       RedirectAttributes redirectAttributes){

        if(bindingResult.hasErrors()){
            return form(product);
        }

        productDAO.save(product);
        redirectAttributes.addFlashAttribute("sucesso", "Product successfully saved");

        return new ModelAndView("redirect:produtos");
    }

    @RequestMapping("/form")
    public ModelAndView form(Product product){

        ModelAndView modelAndView = new ModelAndView("products/cadastroProdutos");
        modelAndView.addObject("types", BookType.values());

        return modelAndView;
    }

    @RequestMapping(method=RequestMethod.GET)
    public ModelAndView list(){

        ModelAndView modelAndView = new ModelAndView("products/list");
        modelAndView.addObject("products", productDAO.list());

        return modelAndView;
    }

    @RequestMapping("/{id}")
    public ModelAndView show(@PathVariable("id") Integer id){

        ModelAndView modelAndView = new ModelAndView("products/show");
        Product product = productDAO.find(id);
        modelAndView.addObject("product", product);

        return modelAndView;
    }
}
