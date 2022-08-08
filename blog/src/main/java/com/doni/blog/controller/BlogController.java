package com.doni.blog.controller;


import com.doni.blog.model.User;
import com.doni.blog.repository.UserRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Slf4j
@Controller
public class BlogController {

    @Autowired
    private UserRepository userRepository;

    @GetMapping("hello")
    public String helloGET(@RequestParam(name="data") String data,Model model){
        model.addAttribute("data",data);
        return "hello";
    }

    @PostMapping("hello")
    public String helloPost(User user){
        //userRepository.save(user);
        log.info(user + "저장");
        log.info(user.getUserID() + "/" + user.getUserPW());
        return "hello";
    }

    @GetMapping("login")
    public String indexGET(Model model, User user){
        model.addAttribute("User",user);
        return "login";
    }

    @PostMapping("login")
    public String indexPost(@ModelAttribute("User") User user, Model model){
        boolean idcheck = userRepository.existsByUserID(user.getUserID());
        log.info(String.valueOf(idcheck));
        if(idcheck){
            //아이디가 중복일때
            model.addAttribute("data","중복아이디");
            model.addAttribute("thid","forgot");
            return "login";
        }
        model.addAttribute("data","아이디 등록완료");
        model.addAttribute("thid","forgot2");
        userRepository.save(user);
        log.info(user + "저장");
        log.info(user.getUserID() + "/" + user.getUserPW());
        return "login";
    }

}
