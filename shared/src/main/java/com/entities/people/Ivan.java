package com.entities.people;

import com.interfaces.CarStoreOwner;
import org.springframework.stereotype.Component;

import java.net.UnknownHostException;

@Component
public class Ivan implements CarStoreOwner {


    public String getName() {
        return "IVAN";
    }

    public int beautyPercentage() {
        return 20;
    }

    public String getNameFromDB() {
        return null;
    }
}
