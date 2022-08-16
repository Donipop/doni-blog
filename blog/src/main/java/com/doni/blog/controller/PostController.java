package com.doni.blog.controller;

import com.doni.blog.model.ContentVo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Slf4j
@Controller
public class PostController {
    @GetMapping("post")
    public String postGet(Model model, ContentVo contentVo){
        model.addAttribute("ContentVo", contentVo);
        return "post";
    }
    @PostMapping("post")
    public String postPost(Model model, @ModelAttribute("ContentVo") ContentVo contentVo){
        model.addAttribute("ContentVo", contentVo);
        log.info(contentVo.getTitle() + "/" + contentVo.getContent());
        return "post";
    }

}
