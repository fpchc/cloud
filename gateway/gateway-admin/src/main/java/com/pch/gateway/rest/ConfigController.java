package com.pch.gateway.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.web.servlet.filter.ApplicationContextHeaderFilter;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.pch.gateway.event.UserEvent;
import com.pch.gateway.util.SpringContextHolder;

@RestController
@RefreshScope
public class ConfigController {

    @Value("${test:11}")
    private String username;

    @RequestMapping("/username")
    public String get() {
        return username;
    }

    @GetMapping("/userEvent")
    public void publish(UserEvent userEvent) {
        ApplicationContextHeader
    }
}
