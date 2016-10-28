package com.blog.pojo;

import java.sql.Time;

/**
 * Created by fly_l on 2016/10/20.
 */
public class Article {

    private int id;
    private String title;
    private String content;
    private String simple;
    private Time createTime;

    public String getSimple() {
        return simple;
    }

    public void setSimple(String simple) {
        this.simple = simple;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Time getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Time createrTime) {
        this.createTime = createrTime;
    }
}
