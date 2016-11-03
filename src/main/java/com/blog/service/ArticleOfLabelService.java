package com.blog.service;

import com.blog.pojo.ArtOfLabel;

/**
 * Created by fly_luna on 2016/10/31.
 */
public interface ArticleOfLabelService {
    Integer[] findArticlesIdByLabelId(int labelId);
    Integer[] findLabelsIdByArticleId(int articleId);
    void addArticleOfLabel(ArtOfLabel artOfLabel);
}
