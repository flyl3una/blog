package com.blog.dao;

import com.blog.pojo.Catalogue;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by fly_luna on 2016/10/26.
 */
@Repository
public interface CatalogueDao {

    public void addCatalogue(Catalogue catalogue);
    public List<Catalogue> getAllCatalogue();
}
