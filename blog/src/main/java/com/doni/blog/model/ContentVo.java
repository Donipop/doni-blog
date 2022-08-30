package com.doni.blog.model;

import lombok.*;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class ContentVo implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(length = 200,nullable = false,name = "content_id")
    private long id;
    @Column
    private String title;
    @Lob
    private String content;
    @JoinColumn(name="userid")
    @ManyToOne(targetEntity = User.class,fetch = FetchType.LAZY)
    private User user;
    @Column
    private int hits;

    @CreationTimestamp
    private Date timestamp;

    @Builder
    public ContentVo(String title, String content, User user, int hits) {
        this.title = title;
        this.content = content;
        this.user = user;
        this.hits = hits;
    }
}
