package com.blog.dao;

import com.blog.pojo.Label;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by fly_luna on 2016/10/26.
 */
@Repository
public interface LabelDao {
    public void addLabel(Label label);
    public List<Label> getAllLabels();
    public int findIdByName(String name);
}
