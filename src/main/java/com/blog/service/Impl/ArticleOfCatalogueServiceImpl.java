package com.blog.service.Impl;

import com.blog.dao.ArticleOfCatalogueDao;
import com.blog.service.ArticleOfCatalogueService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by fly_luna on 2016/10/31.
 */

@Service("articleOfCatalogueService")
public class ArticleOfCatalogueServiceImpl implements ArticleOfCatalogueService {

    @Autowired
    private ArticleOfCatalogueDao articleOfCatalogueDao;

    @Override
    public Integer[] findArticleIdByCatalogueId(int catalogueId) {
        return articleOfCatalogueDao.findArticleIdByCatalogueId(catalogueId);
    }

}
