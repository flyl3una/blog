package com.blog.dao;

import com.blog.pojo.Admin;
import org.springframework.stereotype.Repository;

/**
 * Created by fly_l on 2016/10/17.
 */
@Repository
public interface AdminDao {
    Admin findAdminByUsername(String username);
    void addAdmin(Admin admin);
}
