package com.webApp.app.validators;

import com.webApp.app.models.Product;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

/**
 * Created by knery on 28/06/17.
 */
public class ProductValidator implements Validator {


    public boolean supports(Class<?> clazz) {
        return Product.class.isAssignableFrom(clazz);
    }


    public void validate(Object target, Errors errors) {

        ValidationUtils.rejectIfEmptyOrWhitespace(errors,
                "title", "field.required");

        ValidationUtils.rejectIfEmptyOrWhitespace(errors,
                "description", "field.required");

        Product product = (Product) target;

        if(product.getPages() == 0){
            errors.rejectValue("pages", "field.required");
        }
    }
}
