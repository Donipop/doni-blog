package com.doni.blog.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Slf4j
@Controller
public class SignUpController {

    @GetMapping("signup")
    public String signup(Model model, HttpServletResponse response, HttpServletRequest request){

        return "signup";
    }
}
