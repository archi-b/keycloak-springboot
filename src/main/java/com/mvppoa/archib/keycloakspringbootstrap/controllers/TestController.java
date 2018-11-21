package com.mvppoa.archib.keycloakspringbootstrap.controllers;

import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping(value = "/", produces = MediaType.APPLICATION_JSON_VALUE)
public class TestController {

    @GetMapping(path = "/")
    public String unsecured(){
        return "something";
    }

    @GetMapping(path = "/test")
    public List<String> getTestData(){
        return Arrays.asList("John", "David", "Peter");
    }

    @GetMapping(path = "/logout")
    public String logout(HttpServletRequest request) throws ServletException {
        request.logout();
        return "You were logged out";
    }

}
