package com.blog.dao;

import com.blog.pojo.Article;

import java.util.List;

/**
 * Created by fly_luna on 2016/10/29.
 */
public interface ArticleOfLabel {
    public List<Article> findArticleByLabelName(String name);

}
