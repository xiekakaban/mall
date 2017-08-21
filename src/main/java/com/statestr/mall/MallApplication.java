package com.statestr.mall;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.context.ServletContextAware;

import javax.servlet.ServletContext;
import java.util.List;

/**
 * Created by e604845 on 8/1/2017.
 */
@SpringBootApplication
public class MallApplication implements ServletContextAware {
    private final static Logger logger = LoggerFactory.getLogger(MallApplication.class);

    public static void main(String[] args) {
        SpringApplication.run(MallApplication.class, args);
    }

    @Override
    public void setServletContext(ServletContext servletContext) {
        initApplicationInfo(servletContext);
    }

    private void initApplicationInfo(ServletContext servletContext){
        servletContext.setAttribute("CreateApplicationTime","2017-08-17");
    }
}
