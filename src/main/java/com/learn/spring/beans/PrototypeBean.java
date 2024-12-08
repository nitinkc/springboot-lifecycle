package com.learn.spring.beans;

import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
@Slf4j
@Scope("prototype") // Specify prototype scope
public class PrototypeBean {

    private final String instanceId;

    public PrototypeBean() {
        this.instanceId = UUID.randomUUID().toString();
        log.info("[Thread: {}] PrototypeBean created with ID: {}", Thread.currentThread().getName(), instanceId);
    }

    public String getInstanceId() {
        log.info("[Thread: {}] Accessing PrototypeBean with ID: {}", Thread.currentThread().getName(), instanceId);
        return instanceId;
    }
}
