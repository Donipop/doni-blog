package com.doni.blog.controller;

import com.doni.blog.model.User;
import com.doni.blog.model.UserInfo;
import com.doni.blog.service.UserService;
import com.doni.blog.service.UserSession;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Objects;

@Slf4j
@Controller
public class LoginController {
    private final UserService userService;
    UserSession userSession = new UserSession();
    @Resource
    private UserInfo userInfo;
    @Autowired
    public LoginController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("login")
    public String indexGET(Model model, User user){
        model.addAttribute("User",user);
        return "login";
    }

    @PostMapping("login")
    public String indexPost(@ModelAttribute("User") User user, Model model, HttpServletRequest request, HttpServletResponse response){
        String valueUserLogin = userService.userLogin(user,request,response);
        
        if(Objects.equals(valueUserLogin, "로그인 성공")){
            //model.addAttribute("data", "로그인성공");
           // model.addAttribute("thid", "forgot2");
            log.info("로그인성공");
            return "blog";
        }else{
            model.addAttribute("data",true);
            model.addAttribute("datatext", valueUserLogin);
            //model.addAttribute("thid", "forgot");
            log.info("로그인실패" + valueUserLogin);
        }
        return "login";
    }

    @GetMapping("main")
    public String getMain(Model model, HttpServletRequest request){
        log.info(String.valueOf(userSession.getSession(request)));
        model.addAttribute("data",userInfo.getUserName());
        log.info("main");
        return "main";
    }

    @GetMapping("main2")
    public String getMain2(Model model,HttpServletRequest request){
        log.info(String.valueOf(userSession.getSession(request)));
        model.addAttribute("data",userInfo.getUserName());
        log.info("main2");
        return "main2";
    }

}
