package com.blog.dao;

import com.blog.pojo.Article;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by fly_luna on 2016/10/29.
 */
@Repository
public interface ArticleOfCatalogueDao {
    Integer[] findArticleIdByCatalogueId(int id);
}
