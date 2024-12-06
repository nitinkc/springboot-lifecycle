package com.learn.spring.lifecycle;

import com.learn.spring.event.listener.*;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.Banner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.event.ApplicationEnvironmentPreparedEvent;

@SpringBootApplication(scanBasePackages = {
        "com.learn.spring.components",
        "com.learn.spring.event.listener"
})
@Slf4j
public class DemoApplication {

    public static void main(String[] args) {
        //springAppRun(args);
        customAppRun(args);
    }

    private static void springAppRun(String[] args) {
        SpringApplication.run(DemoApplication.class, args);
    }

    private static void customAppRun(String[] args) {
        // Add custom log before startup
        log.info("[LOG] ===== Application Starting =====");

        SpringApplication app = new SpringApplication(DemoApplication.class);

        // Add event listeners for logging application lifecycle
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

        app.run(args);
    }

}
