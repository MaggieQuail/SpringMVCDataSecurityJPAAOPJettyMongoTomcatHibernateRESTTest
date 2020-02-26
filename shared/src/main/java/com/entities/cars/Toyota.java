package com.entities.cars;

import com.interfaces.Car;
import org.springframework.stereotype.Component;

@Component
public class Toyota implements Car {
    private int length;
    private String colour;
    private String name;

    public Toyota() {
        colour = setColour();
        length = penisLengtheningProcess();
        name = getClass().getCanonicalName();
    }

    public String getColour() {
        return colour;
    }

    public int getLength() {
        return length;
    }

    public String setColour() {
        return "Blue";
    }

    public int penisLengtheningProcess() {
        return 80;
    }

    @Override
    public long getExecTime() {
        return 0;
    }

    public String getBeanName() {
        return name;
    }
}
