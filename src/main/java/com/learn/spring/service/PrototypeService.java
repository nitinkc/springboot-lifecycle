package com.learn.spring.service;

import com.learn.spring.beans.PrototypeBean;
import org.springframework.stereotype.Service;

@Service
public class PrototypeService {

    private final PrototypeBean prototypeBean;

    public PrototypeService(PrototypeBean prototypeBean) {
        this.prototypeBean = prototypeBean;
        System.out.println("[Thread: " + Thread.currentThread().getName() + "] PrototypeService initialized with PrototypeBean ID: " + prototypeBean.getInstanceId());
    }

    public String process() {
        return prototypeBean.getInstanceId();
    }
}
