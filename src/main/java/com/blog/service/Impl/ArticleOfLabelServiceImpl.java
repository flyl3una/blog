package com.blog.service.Impl;

import com.blog.dao.ArticleOfLabelDao;
import com.blog.service.ArticleOfLabelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by fly_luna on 2016/10/31.
 */
@Service("articleOfLabelService")
public class ArticleOfLabelServiceImpl implements ArticleOfLabelService {

    @Autowired
    private ArticleOfLabelDao articleOfLabelDao;

    @Override
    public Integer[] findArticleIdByLabelId(int labelId) {
        return articleOfLabelDao.findArticleIdByLabelId(labelId);
    }

    @Override
    public Integer[] findLabelsIdByArticleId(int articleId) {
        return articleOfLabelDao.findLabelsIdByArticleId(articleId);
    }
}
