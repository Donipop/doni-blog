package com.doni.blog.controller;

import com.doni.blog.model.ContentDto;
import com.doni.blog.model.ContentVo;
import com.doni.blog.service.ContentPostService;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonObject;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;
import java.util.Objects;

@Slf4j
@Controller
public class ViewController {

    private final ContentPostService contentPostService;

    public ViewController(ContentPostService contentPostService) {
        this.contentPostService = contentPostService;
    }

    @GetMapping("view")
    @ResponseBody
    public String viewGet(Model model, @RequestParam(required = false) String username){
        List<ContentDto> contentList = contentPostService.getContent(username);
        model.addAttribute("contentList",contentList);
        if(contentList.size() == 0){
            return "게시글 없음";
        }
        //List를 Json으로 바꿔줌 Gson라이브러리 사용
        Gson gson = new GsonBuilder().disableHtmlEscaping().create();
        String jsonstr = gson.toJson(contentList);
        log.info(jsonstr);
        return jsonstr;
    }
}