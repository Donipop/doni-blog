package com.doni.blog.controller;


import com.doni.blog.model.User;
import com.doni.blog.model.UserInfo;
import com.doni.blog.model.UserRole;
import com.doni.blog.repository.UserRepository;
import com.doni.blog.utill.UserSession;
import lombok.extern.slf4j.Slf4j;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@Slf4j
@Controller
public class BlogController {

    @GetMapping("hello")
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
    }

}
