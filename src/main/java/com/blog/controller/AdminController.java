package com.blog.controller;

import com.blog.pojo.Admin;
import com.blog.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpSession;

/**
 * Created by fly_l on 2016/10/17.
 */

@Controller
@RequestMapping("admin")
public class AdminController {

    @Autowired
    private AdminService adminService;

    @RequestMapping(value = "login", method = RequestMethod.GET)
    public String Login(){
        return "/admin/login";
    }

//    @SessionAttributes("email")
    @RequestMapping(value = "login", method = RequestMethod.POST)
    public String Login(Admin admin, Model model, HttpSession session) {
        try {
            Admin admin1 = adminService.findAdminByUsername(admin.getUsername());
            if (admin1 != null) {
                session.setAttribute("username", admin.getUsername());
                return "redirect:/manage/index";
            } else {
                model.addAttribute("error", "用户名或密码错误，登录失败");
                return "/admin/login";
            }
        }catch (Exception e){
            e.printStackTrace();
            model.addAttribute("error", e);
            return "/admin/login";
        }
    }
}
