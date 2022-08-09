package com.doni.blog.controller;

import com.doni.blog.model.User;
import com.doni.blog.model.UserInfo;
import com.doni.blog.model.UserRole;
import com.doni.blog.repository.MemoryUserRepository;
import com.doni.blog.repository.UserRepository;
import com.doni.blog.utill.UserSession;
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

@Slf4j
@Controller
public class LoginController {
    @Autowired
    private final UserRepository userRepository = new MemoryUserRepository();
    UserSession userSession = new UserSession();
    @Resource
    private UserInfo userInfo;

    @GetMapping("login")
    public String indexGET(Model model, User user){
        model.addAttribute("User",user);
        return "login";
    }

    @PostMapping("login")
    public String indexPost(@ModelAttribute("User") User user, Model model, HttpServletRequest request, HttpServletResponse response){
        boolean idcheck = userRepository.existsByUserName(user.getUserName());
        boolean pwcheck = userRepository.existsByUserPw(user.getUserPw());
        log.info("ID중복체크 : " + idcheck);
        if(idcheck){
            //아이디가 중복일때
            if(pwcheck){
                //아이디와 비밀번호가 일치할때[로그인 성공]
                log.info("로그인 성공! :" + user.getUserName());
                log.info(userSession.createSession(user,request,response));
                userInfo.setUserid(user.getUserName());
                userInfo.setUserRole(user.getUserRole());
                //model.addAttribute("data","2313");


                return "redirect:main";
            }else{log.info("로그인 실패!");}
            model.addAttribute("data","중복아이디");
            model.addAttribute("thid","forgot");
            return "login";
        }

        model.addAttribute("data","아이디 등록완료");
        model.addAttribute("thid","forgot2");

        user.setUserRole(UserRole.User);
        //user.setUserSession();
        userRepository.save(user);

        log.info(user + "저장");
        log.info(user.getUserName() + "/" + user.getUserPw());
        return "login";
    }

    @GetMapping("main")
    public String getMain(Model model, HttpServletRequest request){
        log.info(String.valueOf(userSession.getSession(request)));
        model.addAttribute("data",userInfo.getUserid());
        log.info("main");
        return "main";
    }

    @GetMapping("main2")
    public String getMain2(Model model,HttpServletRequest request){
        log.info(String.valueOf(userSession.getSession(request)));
        model.addAttribute("data",userInfo.getUserid());
        log.info("main2");
        return "main2";
    }

}
