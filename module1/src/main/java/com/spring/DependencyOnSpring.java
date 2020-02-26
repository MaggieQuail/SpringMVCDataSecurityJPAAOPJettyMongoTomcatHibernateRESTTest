package com.spring;

import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

@Component
public class DependencyOnSpring {

    private static DependencyOnSpring INSTANCE;

    public static DependencyOnSpring getInstance() {
        return INSTANCE;
    }

    @PostConstruct
    private void init() {
        INSTANCE = this;
    }

    private DependencyOnSpring() {
    }
}
