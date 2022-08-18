package com.doni.blog.controller;

import com.doni.blog.model.ContentVo;
import com.doni.blog.model.User;
import com.doni.blog.model.UserInfo;
import com.doni.blog.service.ContentPostService;
import com.doni.blog.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import javax.annotation.Resource;

@Slf4j
@Controller
public class PostController {

    private final ContentPostService contentPostService;
    @Autowired
    public PostController(ContentPostService contentPostService) {
        this.contentPostService = contentPostService;
    }

    @GetMapping("post")
    public String postGet(Model model, ContentVo contentVo){
        model.addAttribute("ContentVo", contentVo);
        return "post";
    }
    @PostMapping("post")
    public void postPost(Model model, @ModelAttribute("ContentVo") ContentVo contentVo){
        model.addAttribute("ContentVo", contentVo);
        //log.info(userInfo.getUserId() + "여기여기여기여기여기");
        contentPostService.contentPost(contentVo);
        log.info(contentVo.getTitle() + "/" + contentVo.getContent() + "/");
        //return "post";
    }

}
