package com.doni.blog.model;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import javax.xml.crypto.Data;
import java.io.Serializable;
import java.util.Date;

@Entity
@Getter
@Setter
@NoArgsConstructor
@Table(name = "Content")
public class ContentVo implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(length = 200,nullable = false)
    private long id;
    @Column
    private String title;
    @Column
    private String content;


    private String writer;//글작성자
    @Column
    private int hits;
    @CreationTimestamp
    private Date timestamp;

    @Builder
    public ContentVo(String title, String content, String writer, int hits) {
        this.title = title;
        this.content = content;
        this.writer = writer;
        this.hits = hits;
    }
}
