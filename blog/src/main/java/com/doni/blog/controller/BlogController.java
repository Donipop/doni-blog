package com.doni.blog.controller;


import com.doni.blog.model.User;
import com.doni.blog.model.UserInfo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.annotation.Resource;

@Slf4j
@Controller
public class BlogController {

    @Resource
    private UserInfo userInfo;
    @GetMapping("blog")
    public String getBlog(Model model){
        if(userInfo.getUserName() !=null){
            model.addAttribute("username", userInfo.getUserName());
            model.addAttribute("logincheck",true);
        }else{
            model.addAttribute("username", "로그인 안했을껄껄껄안녕하신가");
            model.addAttribute("logincheck",false);
        }


        return "blog";
    }

   /* @GetMapping("hello")
    public String helloGET(@RequestParam(name="data") String data,Model model){
        model.addAttribute("data",data);
        return "hello";
    }

    @PostMapping("hello")
    public String helloPost(User user){
        //userRepository.save(user);
        log.info(user + "저장");
        log.info(user.getUserName() + "/" + user.getUserPw());
        return "hello";
    }*/



}
