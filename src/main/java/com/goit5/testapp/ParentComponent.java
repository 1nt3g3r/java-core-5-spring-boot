package com.goit5.testapp;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

@RequiredArgsConstructor
@Component
public class ParentComponent {
    private final ApplicationContext context;

    @PostConstruct
    public void init() {
        for (ChildComponent component : context.getBeansOfType(ChildComponent.class).values()) {
            component.hello();
        }
    }
}
