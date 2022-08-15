package com.doni.blog.service;

import com.doni.blog.model.User;
import lombok.extern.slf4j.Slf4j;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.Arrays;
import java.util.UUID;

@Slf4j
public class UserSession {
    public String createSession(User user, HttpServletRequest request,HttpServletResponse response){
        String uuid = UUID.randomUUID().toString();
        request.setAttribute("SID",uuid);
        HttpSession session = request.getSession();
        session.setAttribute("SID",user);
        createCookie(response);
        log.info("Create Session!!");
        return uuid;
    }
    public void deleteSession(HttpServletRequest request){
        HttpSession session = request.getSession(false);
        if(session != null){
            session.invalidate();
        }
    }
    public boolean getSession(HttpServletRequest request){
        HttpSession session = request.getSession();
        if(session.getAttribute("SID") == null){
            return false;
        }
        User user = (User) session.getAttribute("SID");
        log.info("GetCookie : [{}]",getCookie(request));
        log.info("GetSession : [{}]",session.getAttribute("SID"));
        log.info("USER NAME : [{}]", user.getUserName());
        return true;
    }

    private void createCookie(HttpServletResponse response){
        String uuid = UUID.randomUUID().toString();
        Cookie cookie = new Cookie("SID",uuid);
        cookie.setHttpOnly(true);
        cookie.setMaxAge(1800);
        response.addCookie(cookie);
    }

    private String getCookie(HttpServletRequest request){
        return Arrays.stream(request.getCookies())
                .filter(c->c.getName().equals("SID"))
                .findFirst()
                .map(Cookie::getValue)
                .orElse(null);
    }
}
