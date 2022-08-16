package com.doni.blog.repository;

import com.doni.blog.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;


public interface UserRepository extends JpaRepository<User,Long> {

    boolean existsByUserName(@Param("userName") String userId);
    boolean existsByUserPw(String userPw);
    User findByUserName(String userID);
}
