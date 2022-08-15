package com.doni.blog.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import javax.xml.crypto.Data;
import java.util.Date;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class ContentVo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(length = 200,nullable = false)
    private long id;
    @Column
    private String title;
    @Column
    private String content;
    @CreationTimestamp
    private Date timestamp;
}
