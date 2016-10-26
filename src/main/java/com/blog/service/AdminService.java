package com.blog.service;

import com.blog.pojo.Admin;

/**
 * Created by fly_l on 2016/10/17.
 */


public interface AdminService {

    public Admin findAdminByUsername(String username);
}
