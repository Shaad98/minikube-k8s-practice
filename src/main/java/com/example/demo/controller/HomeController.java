package com.example.demo.controller;

import java.net.InetAddress;
import java.net.UnknownHostException;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

    @GetMapping("/")
    public String home(Model model) throws UnknownHostException {
        String version = "Version 1 of Docker Image / Minikube Practice";
        String hostname = InetAddress.getLocalHost().getHostName();

        model.addAttribute("version", version);
        model.addAttribute("hostname", hostname);

        return "home";  // thymeleaf template name
    }
}
