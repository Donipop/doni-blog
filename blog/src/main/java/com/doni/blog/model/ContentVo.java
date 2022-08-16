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
public class ContentVo implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(length = 200,nullable = false)
    private long id;
    @Column
    private String userId;
    @Column
    private String title;
    @Column
    private String content;
    @CreationTimestamp
    private Date timestamp;

    @Builder
    public ContentVo(long id, String userId, String title, String content, Date timestamp) {
        this.id = id;
        this.userId = userId;
        this.title = title;
        this.content = content;
        this.timestamp = timestamp;
    }
}
