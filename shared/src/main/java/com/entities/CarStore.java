package com.entities;

import com.interfaces.Car;
import com.interfaces.CarStoreOwner;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public
class CarStore {

    @Autowired
    private List<Car> carsList;

    @Autowired
    @Qualifier("margarita")
    private CarStoreOwner carStoreOwner;


    public List<Car> getCarsList() {
        return carsList;
    }

    public void setCarsList(List<Car> carsList) {
        this.carsList = carsList;
    }


    public CarStoreOwner getCarStoreOwner() {
        return carStoreOwner;
    }

    public void setCarStoreOwner(CarStoreOwner carStoreOwner) {
        this.carStoreOwner = carStoreOwner;
    }
}
