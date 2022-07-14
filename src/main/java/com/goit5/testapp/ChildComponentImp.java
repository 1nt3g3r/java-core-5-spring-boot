package com.goit5.testapp;

import org.springframework.stereotype.Component;

@Component
public class ChildComponentImp implements ChildComponent {
    @Override
    public void hello() {
        System.out.println("Hello");
    }
}
