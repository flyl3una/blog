package com.blog.dao;

import com.blog.pojo.Article;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by fly_l on 2016/10/23.
 */
@Repository
public interface ArticleDao {

    int addArticle(Article article);
    List<Article> getAllArticle();
    void updateArticle(Article article);
    void deleteArticle(int id);
    Article findArticleById(int id);
}
