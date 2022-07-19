package com.goit5.testapp.circular;

import lombok.RequiredArgsConstructor;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;

@Service
@RequiredArgsConstructor
public class ParentABComponent {
    private final ComponentA componentA;
    private final ComponentB componentB;
    private final ApplicationContext context;

    @PostConstruct
    public void init() {
        componentA.print();
    }
}
