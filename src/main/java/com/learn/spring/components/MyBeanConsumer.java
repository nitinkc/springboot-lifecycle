package com.learn.spring.components;

import com.learn.spring.beans.MyBean;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class MyBeanConsumer {
    private final MyBean myBean;

    @Autowired
    public MyBeanConsumer(MyBean myBean) {
        this.myBean = myBean;
    }

    public void printMessage() {
        log.info("[LOG] Bean is injected: {}", myBean);
    }
}