package com.blog.service.Impl;

import com.blog.dao.ArticleDao;
import com.blog.pojo.Article;
import com.blog.service.ArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by fly_l on 2016/10/23.
 */
@Service("articleService")
public class ArticleServiceImpl implements ArticleService {

    @Autowired
    private ArticleDao articleDao;

    @Override
    public int addArticle(Article article) {
        return articleDao.addArticle(article);
    }

    @Override
    public List<Article> getAllArticle() {
        return articleDao.getAllArticle();
    }

    @Override
    public void updateArticle(Article article) {
        articleDao.updateArticle(article);
    }

    @Override
    public void deleteArticle(Article article) {
        articleDao.deleteArticle(article);
    }

    @Override
    public Article findArticleById(int id) {
        Article article = articleDao.findArticleById(id);
        return article;
    }
}
