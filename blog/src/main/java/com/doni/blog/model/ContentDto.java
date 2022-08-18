package com.doni.blog.model;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
public class ContentDto
{
    private long id;
    private String title;
    private String content;
    private long user;
    private int hits;
    private Date timestamp;

    @Builder
    public ContentDto(long id, String title, String content, long user, int hits, Date timestamp) {
        this.id = id;
        this.title = title;
        this.content = content;
        this.user = user;
        this.hits = hits;
        this.timestamp = timestamp;
    }

    @Override
    public String toString() {
        return "ContentDto{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", content='" + content + '\'' +
                ", user=" + user +
                ", hits=" + hits +
                ", timestamp=" + timestamp +
                '}';
    }
}
