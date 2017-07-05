package com.webApp.app.conf;

import com.webApp.app.controllers.HomeController;
import com.webApp.app.daos.ProductDAO;
import com.webApp.app.models.ShoppingCart;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.format.datetime.DateFormatter;
import org.springframework.format.datetime.DateFormatterRegistrar;
import org.springframework.format.support.DefaultFormattingConversionService;
import org.springframework.format.support.FormattingConversionService;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

/**
 * Created by knery on 24/06/17.
 */

@EnableWebMvc
@ComponentScan(basePackageClasses={HomeController.class, ProductDAO.class, ShoppingCart.class})
public class AppWebConfiguration {

    @Bean
    public InternalResourceViewResolver
    internalResourceViewResolver() {
        InternalResourceViewResolver resolver =
                new InternalResourceViewResolver();
        resolver.setPrefix("/WEB-INF/views/");
        resolver.setSuffix(".jsp");
        return resolver;
    }


    @Bean
    public FormattingConversionService mvcConversionService() {
        DefaultFormattingConversionService conversionService =
                new DefaultFormattingConversionService(true);

        DateFormatterRegistrar registrar =
                new DateFormatterRegistrar();
        registrar.setFormatter(new DateFormatter("yyyy-MM-dd"));
        registrar.registerFormatters(conversionService);
        return conversionService;
    }

    @Bean
    public RestTemplate restTemplate(){
        return new RestTemplate();
    }
}
