package com.blog.service;

import com.blog.pojo.Article;

import java.util.List;

/**
 * Created by fly_l on 2016/10/23.
 */
public interface ArticleService {
    public void addArticle(Article article);
    public List<Article> getAllArticle();
    public void updateArticle(Article article);
    public void deleteArticle(Article article);
}
