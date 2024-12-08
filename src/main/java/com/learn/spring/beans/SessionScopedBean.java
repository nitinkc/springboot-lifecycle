package com.learn.spring.beans;

import jakarta.annotation.PreDestroy;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Component;
import org.springframework.web.context.WebApplicationContext;

import java.util.UUID;

@Component
@Slf4j
@Scope(value = WebApplicationContext.SCOPE_SESSION, proxyMode = ScopedProxyMode.TARGET_CLASS)
public class SessionScopedBean {
    private final String id = UUID.randomUUID().toString();

    //Constructor
    public SessionScopedBean() {
        log.info("[Thread: " + Thread.currentThread().getName() + "] SessionScopedBean created: " + id);
    }

    public String getId() {
        log.info("[Thread: " + Thread.currentThread().getName() + "] Accessing SessionScopedBean: " + id);
        return id;
    }

    @PreDestroy
    public void destroy() {
        log.info("[Thread: " + Thread.currentThread().getName() + "] Destroying SessionScopedBean: " + id);
    }
}