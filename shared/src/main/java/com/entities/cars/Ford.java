package com.entities.cars;

import com.interfaces.Car;
import com.interfaces.InjectAnnotation;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

@Component
public class Ford implements Car {
    @InjectAnnotation
    private long execTime;

    private int length;
    private String colour;
    private String name;

    public Ford() {
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
        return "Black";
    }

    public int penisLengtheningProcess() {
        return 50;
    }

    public String getBeanName() {
        return name;
    }

    @PostConstruct
    private void init() {
        System.out.println("FORD Post Constract");
    }

    public long getExecTime() {
        return execTime;
    }

    public void setExecTime(int execTime) {
        this.execTime = execTime;
    }
}
