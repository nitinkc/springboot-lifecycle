package com.learn.spring.app;

import com.learn.spring.event.listener.*;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.Banner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.event.ApplicationEnvironmentPreparedEvent;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication(
    scanBasePackages = {
      "com.learn.spring.components",
      "com.learn.spring.event.listener",
      "com.learn.spring.config",
            "com.learn.spring.**"
    })
@Slf4j
public class SpringLifeCycleApplication {

    public static void main(String[] args) {
        //springAppRun(args);
        customAppRun(args);
    }

    private static void springAppRun(String[] args) {
        SpringApplication.run(SpringLifeCycleApplication.class, args);
    }

    private static void customAppRun(String[] args) {
        // Add custom log before startup
        log.info("[LOG] ===== Application Starting =====");

        SpringApplication app = new SpringApplication(SpringLifeCycleApplication.class);

        // Add event listeners for logging application app
        app.addListeners(new ApplicationStartingListener(),
                //new ApplicationEnvironmentPreparedListener(),
                new ApplicationPreparedListener(),
                new ApplicationStartedListener(),
                //new ApplicationReadyListener(),//added as component
                new ApplicationFailedListener());

        app.addListeners(event -> {
            if (event instanceof ApplicationEnvironmentPreparedEvent) {
                log.info("[LOG] ApplicationEnvironmentPreparedEvent from Main: Environment prepared.");
            }
        });

        app.setBannerMode(Banner.Mode.OFF); // Example of customizing the startup

        ConfigurableApplicationContext context = app.run(args);
        log.info("[LOG] ApplicationContext in use: {}", context.getClass().getName());
    }
}