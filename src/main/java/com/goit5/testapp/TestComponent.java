package com.goit5.testapp;

import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

@Component
public class TestComponent {
    public TestComponent() {
        System.out.println("In constructor");
    }

    @PostConstruct
    public void init() {
        System.out.println("In PostConstruct");
    }

    @PreDestroy
    public void onDestroy() {
        System.out.println("In onDestroy()");
    }
}
