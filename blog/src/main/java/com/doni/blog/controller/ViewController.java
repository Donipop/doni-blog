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
import org.springframework.web.bind.annotation.ResponseBody;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.List;

@Slf4j
@Controller
public class ViewController {

    private final ContentPostService contentPostService;

    public ViewController(ContentPostService contentPostService) {
        this.contentPostService = contentPostService;
    }

    @GetMapping("view")
    @ResponseBody
    public String viewGet(Model model){
        List<ContentDto> contentList = contentPostService.getContent();
        model.addAttribute("contentList",contentList);
        //List를 Json으로 바꿔줌 Gson라이브러리 사용
        Gson gson = new GsonBuilder().disableHtmlEscaping().create();
        String jsonstr = gson.toJson(contentList);
        log.info(jsonstr);
        return jsonstr;
    }
}