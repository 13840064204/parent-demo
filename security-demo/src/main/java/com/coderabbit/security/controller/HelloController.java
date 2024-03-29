package com.coderabbit.security.controller;

import com.coderabbit.security.dao.UserRepository;
import com.coderabbit.security.model.SecurityUser;
import com.coderabbit.security.model.User;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/hello")
public class HelloController {

    @Autowired
    private UserRepository userRepository;

    @RequestMapping("/test")
    public String hello() throws JsonProcessingException {
        List<User> all = userRepository.findAll();
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        SecurityUser user= (SecurityUser) authentication.getPrincipal();
        return new ObjectMapper().writeValueAsString(user);
    }
}
