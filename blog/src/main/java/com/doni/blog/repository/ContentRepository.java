package com.doni.blog.repository;

import com.doni.blog.model.ContentVo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ContentRepository extends JpaRepository<ContentVo,Long> {

}
