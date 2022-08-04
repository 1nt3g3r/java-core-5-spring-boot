package com.goit5.testapp.feature.name;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/api/v1")
@RestController
public class NameController {
    @Value("${appName}")
    private String appName;

    @GetMapping("/name")
    public String getName() {
        return appName;
    }
}
