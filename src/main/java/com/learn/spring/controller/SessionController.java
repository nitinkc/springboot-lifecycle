package com.learn.spring.controller;

import com.learn.spring.beans.SessionScopedBean;
import com.learn.spring.beans.UserSession;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/session")
@RequiredArgsConstructor
public class SessionController {
    private final SessionScopedBean sessionScopedBean;
    private final UserSession userSession;

    @GetMapping("/get")
    public String getSessionBeanId() {
        return "Session Bean ID: " + sessionScopedBean.getId();
    }

    @PostMapping("/update-preference")
    public ResponseEntity<String> updatePreference(@RequestParam String key, @RequestParam String value) {
        userSession.setEditingPreference(key, value);
        return ResponseEntity.ok("Preference updated: " + key + " -> " + value);
    }

    @GetMapping("/preferences")
    public ResponseEntity<Map<String, String>> getPreferences() {
        return ResponseEntity.ok(userSession.getEditingPreferences());
    }

    @GetMapping("/user-id")
    public ResponseEntity<String> getUserId() {
        return ResponseEntity.ok("User ID: " + userSession.getUserId());
    }
}
