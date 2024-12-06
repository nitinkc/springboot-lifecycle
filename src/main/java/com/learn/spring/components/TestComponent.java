package com.learn.spring.components;

import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Component;


@Component
public class TestComponent {

    @PostConstruct
    public void init() {
        System.out.println("[LOG] TestComponent: Initialized with @PostConstruct.");
    }
}
