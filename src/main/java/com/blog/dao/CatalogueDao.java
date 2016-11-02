package com.blog.dao;

import com.blog.pojo.Catalogue;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by fly_luna on 2016/10/26.
 */
@Repository
public interface CatalogueDao {

    void addCatalogue(Catalogue catalogue);
    List<Catalogue> getAllCatalogue();
    int findIdByName(String name);

    String findNameById(int id);

    Catalogue findCatalogueById(int id);

    void deleteCatalogueById(int id);

    void updateCatalogue(Catalogue catalogue);
}
