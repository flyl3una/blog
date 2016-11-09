package com.blog.service;

import com.blog.pojo.Admin;

/**
 * Created by fly_l on 2016/10/17.
 */


public interface AdminService {

    Admin findAdminByUsername(String username);
    void addAdmin(Admin admin);
}
