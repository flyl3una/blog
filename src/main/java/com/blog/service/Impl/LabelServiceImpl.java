package com.blog.service.Impl;

import com.blog.dao.LabelDao;
import com.blog.pojo.Label;
import com.blog.service.LabelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by fly_luna on 2016/10/26.
 */
@Service("labelService")
public class LabelServiceImpl implements LabelService {

    @Autowired
    private LabelDao labelDao;

    @Override
    public void addLabel(Label label) {
        labelDao.addLabel(label);
    }

    @Override
    public List<Label> getAllLabels() {
        return labelDao.getAllLabels();
    }

    @Override
    public int findIdByName(String name) {
        return labelDao.findIdByName(name);
    }

    public String findNameById(int labelId) {
        return labelDao.findNameById(labelId);
    }
}
