package com.doni.blog.service;

import com.doni.blog.model.ContentVo;
import com.doni.blog.repository.ContentRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class ContentPostService {
    private final ContentRepository contentRepository;

    @Autowired
    public ContentPostService(ContentRepository contentRepository) {
        this.contentRepository = contentRepository;
    }

    public String ContentPost(ContentVo contentVo){
        contentRepository.save(contentVo);
        return "ok";
    }
}
