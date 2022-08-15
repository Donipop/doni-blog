package com.doni.blog.service;

import com.doni.blog.model.User;
import com.doni.blog.model.UserInfo;
import com.doni.blog.model.UserRole;
import com.doni.blog.repository.UserRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Objects;

@Service
@Slf4j
public class UserService {
    private final UserRepository userRepository;
    UserSession userSession = new UserSession();
    @Resource
    private UserInfo userInfo;
    @Autowired
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public String userSignup(User user){
        //공백제거
        if(user.getUserName() == null || user.getUserName().length()<3 || user.getUserName().indexOf(" ") > 0){
            return "아이디 공백또는3자이하";
        }
        if(user.getUserPw() == null || user.getUserPw().length() < 3 || user.getUserPw().indexOf(" ") > 0){
            return "비밀번호 공백또는3자이하";
        }
        if(userRepository.existsByUserName(user.getUserName())){
            return "이미 존재하는 아이디";
        }

        user.setUserRole(UserRole.User);
        userRepository.save(user);

        return "가입완료";
    }

    public String userLogin(User user, HttpServletRequest request, HttpServletResponse response){
        User finduser = userRepository.findByUserName(user.getUserName());
        if(finduser == null){
            return "아이디 없음";
        }

        if(!Objects.equals(user.getUserPw(), finduser.getUserPw())){
            return "비밀번호 오류";
        }

        if(Objects.equals(user.getUserPw(), finduser.getUserPw())){
            userInfo.setUserName(user.getUserName());
            userInfo.setUserRole(user.getUserRole());
            log.info("[{}]",finduser);
            log.info("[{}] [{}] [{}]",finduser.getUserName(),finduser.getUserPw(),finduser.getId());
            log.info(userSession.createSession(user,request,response));
            return "로그인 성공";
        }

        return "로그인 실패";
    }
}
