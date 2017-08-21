package com.statestr.mall.util;

import com.google.gson.Gson;
import com.google.gson.TypeAdapter;
import com.google.gson.TypeAdapterFactory;
import com.google.gson.reflect.TypeToken;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonWriter;
import com.statestr.mall.adapter.HibernateProxyTypeAdapter;
import org.hibernate.Hibernate;
import org.hibernate.proxy.HibernateProxy;
import org.thymeleaf.spring4.expression.Fields;

import java.io.IOException;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * Created by e604845 on 8/21/2017.
 */
public enum HibernateProxyTypeAdapterFactory implements TypeAdapterFactory {
    INSTANSE;

    @Override
    public <T> TypeAdapter<T> create(Gson gson, TypeToken<T> typeToken) {
        return (HibernateProxy.class.isAssignableFrom(typeToken.getRawType()) ? (TypeAdapter<T>) new HibernateProxyTypeAdapter() : null);
    }
    // Hibernate ProxyAdapter
    private class HibernateProxyTypeAdapter extends TypeAdapter <HibernateProxy>{

        @Override
        public void write(JsonWriter jsonWriter, HibernateProxy hibernateProxy) throws IOException {
            String val = "";
            if (hibernateProxy == null) {
                jsonWriter.nullValue();
                return;
            }

            jsonWriter.beginObject();
            Class<?> baseType = Hibernate.getClass(hibernateProxy);
            Hibernate.initialize(hibernateProxy);
            try {
                Method getIdMethod = baseType.getDeclaredMethod("getId");
                val = String.valueOf(getIdMethod.invoke(hibernateProxy));
            } catch (NoSuchMethodException | IllegalAccessException | InvocationTargetException e) {
                e.printStackTrace();
            }
            jsonWriter.name(baseType.getSimpleName().toLowerCase()).value(val);
            jsonWriter.endObject();
        }

        @Override
        public HibernateProxy read(JsonReader jsonReader) throws IOException {
            throw new UnsupportedOperationException("Not supported");
        }
    }
}
