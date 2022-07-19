package com.goit5.testapp.circular;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ComponentA {
    public void print() {
        System.out.println("I am component A - start");
        System.out.println("I am component A - end");
    }
}
