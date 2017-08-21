package com.statestr.mall;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.support.SpringBootServletInitializer;
import org.springframework.web.context.ServletContextAware;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;

/**
 * Created by e604845 on 8/15/2017.
 */
@SpringBootApplication
public class MallTestApplication implements ServletContextAware {
    public static void main(String[] args) {
        SpringApplication.run(MallTestApplication.class, args);
    }


    @Override
    public void setServletContext(ServletContext servletContext) {
        initApplicationInfo(servletContext);
    }

    private void initApplicationInfo(ServletContext servletContext){
        servletContext.setAttribute("CreateApplicationTime","2017-08-17");
    }
}
