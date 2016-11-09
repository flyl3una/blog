package com.blog.service.Impl;

import com.blog.dao.AdminDao;
import com.blog.pojo.Admin;
import com.blog.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by fly_l on 2016/10/17.
 */

@Service("adminService")
public class AdminServiceImpl implements AdminService {

    @Autowired
    private AdminDao adminDao;

    @Override
    public Admin findAdminByUsername(String username) {
        Admin admin = adminDao.findAdminByUsername(username);
        return admin;
    }
    public void addAdmin(Admin admin){
        adminDao.addAdmin(admin);
    }
}
