package com.learn.spring.components;

import jakarta.annotation.PostConstruct;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class TestComponent {

    @PostConstruct
    public void init() {
        log.info("[LOG] TestComponent: Initialized with @PostConstruct.");
    }
}