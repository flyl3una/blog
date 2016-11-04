package com.blog.dao;

import com.blog.pojo.ArtOfCatalogue;
import com.blog.pojo.Article;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by fly_luna on 2016/10/29.
 */
@Repository
public interface ArticleOfCatalogueDao {
    Integer[] findArticlesIdByCatalogueId(int catalogueId);
    Integer findCatalogueIdByArticleId(int articleId);
    void addArticleOfCatalogue(ArtOfCatalogue artOfCatalogue);

    void deleteArticleOfCatalogue(int articleId);
}
