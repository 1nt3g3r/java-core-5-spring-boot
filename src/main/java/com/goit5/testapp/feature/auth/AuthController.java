package com.goit5.testapp.feature.auth;

import lombok.RequiredArgsConstructor;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import org.springframework.security.core.userdetails.User;

@RequiredArgsConstructor
@RequestMapping("/auth")
@Controller
public class AuthController {
    private final AuthService authService;

    @GetMapping("/profile")
    public ModelAndView get() {
        ModelAndView result = new ModelAndView("auth-page");

        result.addObject("username", authService.getUsername());

        return result;
    }

    @GetMapping("/superadmin")
    public ModelAndView superAdminOnly() {
        if (!authService.hasAuthority("admin")) {
            return new ModelAndView("forbidden");
        }

        return new ModelAndView("superadmin");
    }
}
