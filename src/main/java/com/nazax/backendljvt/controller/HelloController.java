package com.nazax.backendljvt.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;

@RestController
@RequestMapping("/api")
public class HelloController {
    @GetMapping("/")
    public String hello() {
        return "Hello World" + new Date();
    }
}