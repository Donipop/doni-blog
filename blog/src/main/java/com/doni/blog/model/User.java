package com.doni.blog.model;

import lombok.*;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.util.Date;

@Getter
@Setter
@Entity
@NoArgsConstructor
//@Table(name = "user")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(length = 200,nullable = false)
    private Long id;

    @Column(length = 10)
    private String userID;

    @Column(length = 15)
    private String userPW;

    @CreationTimestamp
    private Date timestamp;

    @Builder
    public User(Long id, String userID, String userPW) {
        this.id = id;
        this.userID = userID;
        this.userPW = userPW;
    }
}
