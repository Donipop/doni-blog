package com.doni.blog.repository;

import com.doni.blog.model.ContentVo;
import com.doni.blog.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface ContentRepository extends JpaRepository<ContentVo,Long> {

    Optional<ContentVo> findById(Long id);

    List<ContentVo> findAllByUser(User user);

}
