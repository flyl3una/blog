package com.blog.service.Impl;

import com.blog.dao.CatalogueDao;
import com.blog.pojo.Catalogue;
import com.blog.service.CatalogueService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by fly_luna on 2016/10/27.
 */
@Service("catalogueService")
public class CatalogueServiceImpl implements CatalogueService {
    @Autowired
    private CatalogueDao catalogueDao;

    @Override
    public void addCatalogue(Catalogue catalogue) {
        catalogueDao.addCatalogue(catalogue);
    }

    @Override
    public List<Catalogue> getAllCatalogue() {
        return catalogueDao.getAllCatalogue();
    }

    @Override
    public int findIdByName(String name) {
        return catalogueDao.findIdByName(name);
    }

    @Override
    public String findNameById(int id) {
        return catalogueDao.findNameById(id);
    }

    @Override
    public void deleteCatalogueById(int id) {
        catalogueDao.deleteCatalogueById(id);
    }

    @Override
    public Catalogue findCatalogueById(int id) {
        return catalogueDao.findCatalogueById(id);
    }

    @Override
    public void updateCatalogue(Catalogue catalogue) {
        catalogueDao.updateCatalogue(catalogue);
    }
}
