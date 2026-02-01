package com.example.demo.controller;

import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class StopController {

    private final ConfigurableApplicationContext context;

    public StopController(ConfigurableApplicationContext context) {
        this.context = context;
    }

    @GetMapping("/stop")
    public String stopApp() {
        new Thread(() -> {
            try {
                Thread.sleep(1000); // small delay so response returns
                context.close();
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }).start();
        return "Stopping application...";
    }
}
