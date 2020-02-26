package com.entities.people;

import com.interfaces.CarStoreOwner;
import org.springframework.stereotype.Component;

@Component
public class Margarita implements CarStoreOwner {
    private String name;
    private int beauty;

    public Margarita() {
    }

    public Margarita(String name, int beauty) {
        this.beauty = getBeauty();
        this.name = name;
    }

    @Override
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    private int getBeauty() {
        return beauty;
    }

    public void setBeauty(int beauty) {
        this.beauty = beauty;
    }

}
