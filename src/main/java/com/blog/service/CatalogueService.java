package com.blog.service;

import com.blog.pojo.Catalogue;

import java.util.List;

/**
 * Created by fly_luna on 2016/10/27.
 */
public interface CatalogueService {
    public void addCatalogue(Catalogue catalogue);
    public List<Catalogue> getAllCatalogue();
}
