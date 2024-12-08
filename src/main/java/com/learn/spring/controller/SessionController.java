package com.learn.spring.controller;

import com.learn.spring.beans.SessionScopedBean;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/session")
@RequiredArgsConstructor
public class SessionController {
    private final SessionScopedBean sessionScopedBean;

    @GetMapping("/get")
    public String getSessionBeanId() {
        return "Session Bean ID: " + sessionScopedBean.getId();
    }
}
