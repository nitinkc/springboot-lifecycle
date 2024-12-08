package com.learn.spring.service;

import com.learn.spring.beans.PrototypeBean;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class PrototypeService {

    private final PrototypeBean prototypeBean;

    public PrototypeService(PrototypeBean prototypeBean) {
        this.prototypeBean = prototypeBean;
        log.info("[Thread: {}] PrototypeService initialized with PrototypeBean ID: {}", Thread.currentThread().getName(), prototypeBean.getInstanceId());
    }

    public String process() {
        return prototypeBean.getInstanceId();
    }
}
