package com.blog.service;

import com.blog.pojo.Article;

import java.util.List;

/**
 * Created by fly_l on 2016/10/23.
 */
public interface ArticleService {
    int addArticle(Article article);
    List<Article> getAllArticle();
    void updateArticle(Article article);
    void deleteArticle(int id);
    Article findArticleById(int id);
}
