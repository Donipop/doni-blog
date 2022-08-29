package com.doni.blog.controller;

import com.doni.blog.model.ContentVo;
import com.doni.blog.service.ContentPostService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Optional;

@Slf4j
@Controller
public class PostController {

    private final ContentPostService contentPostService;
    @Autowired
    public PostController(ContentPostService contentPostService) {
        this.contentPostService = contentPostService;
    }

    @GetMapping("post")
    public String postGet(Model model, ContentVo contentVo,@RequestParam(required = false) Integer contentid){
        model.addAttribute("ContentVo", contentVo);
        if(contentid != null){
            //updateContent(contentVo);
            Optional<ContentVo> cc = contentPostService.getContentNum(Long.valueOf(contentid));
            //log.info(String.valueOf(cc.get().getId()));
            model.addAttribute("ContentVo", cc.get());
            log.info("겟 포스트 업데이트 진입!");
        }
        return "post";
    }
    @PostMapping("post")
    public void postPost(Model model, @ModelAttribute("ContentVo") ContentVo contentVo, @RequestParam(required = false) Integer contentid){
        model.addAttribute("ContentVo", contentVo);
        if(contentid != null){
            updateContent(contentVo);
        }
        //log.info(userInfo.getUserId() + "여기여기여기여기여기");
        contentPostService.contentPost(contentVo);
        log.info(contentVo.getTitle() + "/" + contentVo.getContent() + "/");
        //return "post";
    }
    private void updateContent(ContentVo contentVo){
        //contentPostService.updateContentPost(contentVo);
        log.info("컨텐츠 업데이트 진입");
        log.info(String.valueOf(contentVo.getId()));
    }

}
