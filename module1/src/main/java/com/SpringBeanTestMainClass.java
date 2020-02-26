package com;

import com.entities.CarStore;
import com.interfaces.Car;
import com.interfaces.CarStoreOwner;
import com.services.CarServiceConfiguration;
import com.services.MargaritaFabric;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.stereotype.Component;

import java.net.UnknownHostException;
import java.util.Collections;
import java.util.List;

@Component
public class SpringBeanTestMainClass {

    public static void main(String[] args) {
        getContext();

    }

    private static ApplicationContext getContext() {
        ApplicationContext context =
                new AnnotationConfigApplicationContext(CarServiceConfiguration.class);
      //  ((AnnotationConfigApplicationContext) context).close();

        return context;
    }
}
