package com.blog.service;

import com.blog.pojo.Catalogue;

import java.util.List;

/**
 * Created by fly_luna on 2016/10/27.
 */
public interface CatalogueService {
    void addCatalogue(Catalogue catalogue);
    List<Catalogue> getAllCatalogues();
    int findIdByName(String name);

    String findNameById(int id);

    Catalogue findCatalogueById(int id);

    void deleteCatalogueById(int id);

    void updateCatalogue(Catalogue catalogue);
}
