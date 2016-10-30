package com.blog.service;

import com.blog.pojo.Label;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by fly_luna on 2016/10/26.
 */

public interface LabelService {
    public void addLabel(Label label);
    public List<Label> getAllLabels();
    public int findIdByName(String name);
}
