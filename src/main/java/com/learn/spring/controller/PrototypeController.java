package com.learn.spring.controller;

import com.learn.spring.beans.PrototypeBean;
import com.learn.spring.service.PrototypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/prototype")
public class PrototypeController {

    @Autowired
    private ApplicationContext applicationContext; // To get fresh PrototypeBean instances manually

    @GetMapping("/new")
    public String newPrototypeBean() {
        PrototypeBean prototypeBean = applicationContext.getBean(PrototypeBean.class);
        return "New PrototypeBean instance: " + prototypeBean.getInstanceId();
    }

    @GetMapping("/service")
    public String prototypeInService() {
        PrototypeService service = applicationContext.getBean(PrototypeService.class);
        return "PrototypeBean used in service: " + service.process();
    }
}
