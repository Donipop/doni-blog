package com.doni.blog.service;

import com.doni.blog.model.ContentVo;
import com.doni.blog.model.User;
import com.doni.blog.model.UserInfo;
import com.doni.blog.repository.ContentRepository;
import com.doni.blog.repository.UserRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
@Slf4j
public class ContentPostService {
    private final ContentRepository contentRepository;
    private final UserRepository userRepository;
    @Resource
    private UserInfo userInfo;

    @Autowired
    public ContentPostService(ContentRepository contentRepository, UserRepository userRepository) {
        this.contentRepository = contentRepository;
        this.userRepository = userRepository;
    }

    public String ContentPost(ContentVo contentVo){
        User finduser = userRepository.findByUserName(userInfo.getUserName());
        contentVo.setUser(finduser);
        log.info("요기요기" + finduser.getId() + "/" + userInfo.getUserId());
        contentRepository.save(contentVo);
        return "ok";
    }
}
