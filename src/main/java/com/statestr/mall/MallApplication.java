package com.statestr.mall;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.MultipartConfigFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.context.ServletContextAware;
import org.springframework.web.multipart.MultipartResolver;
import org.springframework.web.multipart.support.StandardServletMultipartResolver;

import javax.servlet.MultipartConfigElement;
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

    @Bean
    public MultipartConfigElement multipartConfigElement(){
        MultipartConfigFactory multipartConfigFactory = new MultipartConfigFactory();
        //设置文件大小显示
        multipartConfigFactory.setMaxFileSize("5MB");
        //设置总的request 最大大小
        multipartConfigFactory.setMaxRequestSize("10MB");

        return multipartConfigFactory.createMultipartConfig();

    }

}
