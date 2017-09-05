package com.statestr.mall.config;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.statestr.mall.util.ExcludeFromJsonStrategy;
import com.statestr.mall.util.HibernateProxyTypeAdapterFactory;
import org.springframework.boot.autoconfigure.condition.ConditionalOnBean;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingClass;
import org.springframework.boot.autoconfigure.web.HttpMessageConverters;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.json.GsonHttpMessageConverter;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 * Created by e604845 on 8/22/2017.
 */
@Configuration
public class GsonHttpMessageConverterConfiguration {

    @Bean
    public HttpMessageConverters customConverters() {
        Collection<HttpMessageConverter<?>> messageConverters = new ArrayList<>();
        GsonHttpMessageConverter gsonHttpMessageConverter = new GsonHttpMessageConverter();
        //这边我自定义了一个gson,用于处理hibernate lazy load问题。通过ExcludeFromJsonStrategy过滤那些不用序列号的字段。例如password
        Gson g = new GsonBuilder().addSerializationExclusionStrategy(new ExcludeFromJsonStrategy()).registerTypeAdapterFactory(HibernateProxyTypeAdapterFactory.INSTANSE).create();
        gsonHttpMessageConverter.setGson(g);
        messageConverters.add(gsonHttpMessageConverter);
        return new HttpMessageConverters(true, messageConverters);
    }
}
