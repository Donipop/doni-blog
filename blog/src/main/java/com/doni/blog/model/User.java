package com.doni.blog.model;

import lombok.*;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Getter
@Setter
@Entity
@NoArgsConstructor
//@Table(name = "user")
public class User implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(length = 200,nullable = false)
    private Long id;
    @Column(length = 10)
    private String userName;
    @Column(length = 15)
    private String userPw;
    @Column(length = 20)
    @Enumerated(EnumType.STRING)
    private UserRole userRole;

    @CreationTimestamp
    private Date timestamp;


    @Builder
    public User(Long id, String userName, String userPw, UserRole userRole) {
        this.id = id;
        this.userName = userName;
        this.userPw = userPw;
        this.userRole = userRole;
    }

}
