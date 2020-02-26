package com.services;

import com.SpringBeanTestMainClass;
import com.entities.CarStore;
import com.interfaces.Car;
import com.interfaces.CarStoreOwner;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.net.UnknownHostException;
import java.util.Collections;
import java.util.List;

@Component
public class SpringServices {

    @Autowired
    SpringBeanTestMainClass springBeanTestMainClass;

    @Autowired
    private MargaritaFabric fabric;

    @Autowired
    private CarStore carStore;


    public List<CarStoreOwner> getCarStoreOwnerList() {
        List<CarStoreOwner> entityList;
        CarStoreOwner carList = carStore.getCarStoreOwner();
        entityList = Collections.singletonList(carList);
        return entityList;
    }

    public List<Car> getCarsList() {
        List<Car> entityList;
        List<Car> carsList = carStore.getCarsList();
        for (Car car : carsList) {
            System.out.println("car: " + car);
        }
        entityList = carsList;
        return entityList;
    }

    public String getCarStoreOwnerFronDB() throws UnknownHostException {
        return fabric.creator().getName();
    }
}
