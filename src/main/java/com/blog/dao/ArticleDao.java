package com.blog.dao;

import com.blog.pojo.Article;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by fly_l on 2016/10/23.
 */
@Repository
public interface ArticleDao {

    public void addArticle(Article article);
    public List<Article> getAllArticle();
    public void updateArticle(Article article);
    public void deleteArticle(Article article);
}
