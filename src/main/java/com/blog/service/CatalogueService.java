package com.blog.service;

import com.blog.pojo.Catalogue;

import java.util.List;

/**
 * Created by fly_luna on 2016/10/27.
 */
public interface CatalogueService {
    void addCatalogue(Catalogue catalogue);
    List<Catalogue> getAllCatalogue();
    int findIdByName(String name);
}
