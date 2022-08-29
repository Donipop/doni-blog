package com.doni.blog.service;

import com.doni.blog.model.ContentDto;
import com.doni.blog.model.ContentVo;
import com.doni.blog.model.User;
import com.doni.blog.model.UserInfo;
import com.doni.blog.repository.ContentRepository;
import com.doni.blog.repository.UserRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

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

    @Transactional
    public void contentPost(ContentVo contentVo){
        User finduser = userRepository.findByUserName(userInfo.getUserName());
        contentVo.setUser(finduser);
        log.info("요기요기" + finduser.getId() + "/" + userInfo.getUserId());
        contentRepository.save(contentVo);
    }
    @Transactional
    public List<ContentDto> getContent(String username){

        User finduser = userRepository.findByUserName(username);
        List<ContentVo> contentVos;
        List<ContentDto> contentList = new ArrayList<>();

        if(username == null || username.equals("")){
            contentVos = contentRepository.findAll();
        }else{
            contentVos = contentRepository.findAllByUser(finduser);
        }


        for(ContentVo contentVo : contentVos){
            ContentDto contentDto = ContentDto.builder()
                    .id(contentVo.getId())
                    .title(contentVo.getTitle())
                    .content(contentVo.getContent())
                    .hits(contentVo.getHits())
                    .user(contentVo.getUser().getId())
                    .timestamp(contentVo.getTimestamp())
                    .build();
            contentList.add(contentDto);
        }
        return contentList;
    }
    @Transactional
    public void updateContentPost(ContentVo contentVo){
        log.info("게시글 수정");
        contentRepository.save(contentVo);
    }
    @Transactional
    public Optional<ContentVo> getContentNum(Long num){
        return contentRepository.findById(num);
    }

    @Transactional
    public void deleteContent(Long num){
        contentRepository.deleteById(num);
    }

}
