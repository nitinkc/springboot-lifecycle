package com.learn.spring.beans;

import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Component;
import org.springframework.web.context.WebApplicationContext;

import java.util.Map;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;

@Component
@Slf4j
@Data
@Scope(value = WebApplicationContext.SCOPE_SESSION, proxyMode = ScopedProxyMode.TARGET_CLASS)
public class UserSession {
    private String userId;
    private Map<String, String> editingPreferences = new ConcurrentHashMap<>();

    public UserSession() {
        this.userId = UUID.randomUUID().toString();
        log.info("[Thread: {}] UserSession created for User ID: {}", Thread.currentThread().getName(), userId);
    }

    public void setEditingPreference(String key, String value) {
        editingPreferences.put(key, value);
        log.info("[Thread: {}] Updated preference: {} -> {}", Thread.currentThread().getName(), key, value);
    }

    public Map<String, String> getEditingPreferences() {
        log.info("[Thread: {}] Fetching preferences for User ID: {}", Thread.currentThread().getName(), userId);
        return editingPreferences;
    }
}
