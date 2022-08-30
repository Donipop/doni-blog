package com.doni.blog.controller;

import com.doni.blog.model.ContentVo;
import com.doni.blog.service.ContentPostService;
import lombok.Getter;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.sql.Timestamp;
import java.util.Optional;

@Slf4j
@Controller
public class PostController {

    private final ContentPostService contentPostService;
    @Autowired
    public PostController(ContentPostService contentPostService) {
        this.contentPostService = contentPostService;
    }

    private modelclass modelc = new modelclass();

    @GetMapping("post")
    public String postGet(Model model, ContentVo contentVo,@RequestParam(required = false) Integer contentid){
        if(contentid != null){
//            업데이트
            Optional<ContentVo> cc = contentPostService.getContentNum(Long.valueOf(contentid));
            model.addAttribute("ContentVo", cc.get());
            modelc.setPostcheck(1);
            model.addAttribute("model", modelc);
            log.info("겟 포스트 업데이트 진입!");
        }else{
//            새로운글
            model.addAttribute("ContentVo", contentVo);
            modelc.setPostcheck(0);
            model.addAttribute("model", modelc);
        }
        return "post";
    }
    @PostMapping("post")
    public void postPost(Model model, @ModelAttribute("ContentVo") ContentVo contentVo, @RequestParam(required = false) Integer contentid){
        model.addAttribute("ContentVo", contentVo);
        model.addAttribute("model", modelc);
        if(contentid != null){
            log.info("게시글 업데이트 : " + contentVo.getId());
        }
        Timestamp timestamp = new Timestamp(System.currentTimeMillis());
        contentVo.setTimestamp(timestamp);
        contentPostService.contentPost(contentVo);
        log.info(contentVo.getTitle() + "/" + contentVo.getContent() + "/");
    }

}
@Getter
@Setter
class modelclass{
    /***
     * 0 = 새로운글
     * 1 = 업데이트
     */
    private int postcheck;
}
