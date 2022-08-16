package com.doni.blog.controller;

import com.doni.blog.model.User;
import com.doni.blog.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Slf4j
@Controller
public class SignUpController {

    private final UserService userService;
    @Autowired
    public SignUpController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("signup")
    public String getSignup(User user,Model model){
        model.addAttribute("User",user);
        log.info("signup진입~");
        return "signup";
    }
    @PostMapping("signup")
    public String postSignup(@ModelAttribute("User") User user,Model model,HttpServletResponse response,HttpServletRequest request){
        String valueUserService = userService.userSignup(user);
        if(valueUserService.equals("가입완료")){
            /*model.addAttribute("data","가입완료");
            model.addAttribute("thid", "forgot2");
            model.addAttribute("thhref", "./login");*/
            model.addAttribute("data2",true);
            model.addAttribute("datatext","가입완료");
        }else{
            model.addAttribute("data",true);
            model.addAttribute("datatext",valueUserService);
           // model.addAttribute("thid", "forgot");
        }
        return "signup";
    }
}
