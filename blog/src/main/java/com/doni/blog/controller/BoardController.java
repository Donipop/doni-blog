package com.doni.blog.controller;

import com.doni.blog.model.ContentVo;
import com.doni.blog.model.User;
import com.doni.blog.model.UserInfo;
import com.doni.blog.service.ContentPostService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.annotation.Resource;
import java.util.Optional;

@Slf4j
@Controller
public class BoardController {

    private final ContentPostService contentPostService;

    @Resource
    private UserInfo userInfo;

    public BoardController(ContentPostService contentPostService) {
        this.contentPostService = contentPostService;
    }

    @GetMapping("board")
    public String getBoard(@RequestParam(required = false) Integer num, Model model){
        model.addAttribute("check_num",true);
        //게시글 번호없이 들어왔을때
        if(num == null){
            return "redirect:blog";
        }
        Optional<ContentVo> content = contentPostService.getContentNum(Long.valueOf(num));
        log.info("Board 진입");
        //불러온 게시글이 없을때
        if(content.isEmpty()){
            model.addAttribute("check_num",false);
        }

        model.addAttribute("user",userInfo);
        model.addAttribute("content",content);
        return "board";
    }

}
