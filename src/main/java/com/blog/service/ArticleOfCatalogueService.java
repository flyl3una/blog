package com.blog.service;

import com.blog.pojo.ArtOfCatalogue;

/**
 * Created by fly_luna on 2016/10/31.
 */
public interface ArticleOfCatalogueService {
    Integer[] findArticlesIdByCatalogueId(int catalogueId);
    Integer findCatalogueIdByArticleId(int articleId);
    void addArticleOfCatalogue(ArtOfCatalogue artOfCatalogue);
}
