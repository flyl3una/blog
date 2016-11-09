package com.blog.controller;

import com.blog.pojo.Admin;
import com.blog.service.AdminService;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.*;
import org.apache.shiro.crypto.SecureRandomNumberGenerator;
import org.apache.shiro.crypto.hash.SimpleHash;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpSession;

/**
 * Created by fly_l on 2016/10/17.
 */

@Controller
@RequestMapping("admin")
public class AdminController {

    @Autowired
    private AdminService adminService;

    @RequestMapping(value = "register", method = RequestMethod.GET)
    public String Register(){
        return "admin/register";
    }

    @RequestMapping(value = "register", method = RequestMethod.POST)
    public String Register(Admin admin, @RequestParam("password2")String password2, Model model){
        if(!admin.getPassword().equalsIgnoreCase(password2)){
            model.addAttribute("error", "两次密码相同");
            return "admin/register";
        }
        String algorithmName = "md5";
        String username = admin.getUsername();
        String password = admin.getPassword();
        String salt1 = username;
        String salt2 = password;
        int hashIterations = 3;
        SimpleHash hash = new SimpleHash(algorithmName, password,
                salt1 + salt2, hashIterations);
        String encodedPassword = hash.toHex();
        admin.setPassword(encodedPassword);
        adminService.addAdmin(admin);
        return "redirect:/admin/login";
    }

    @RequestMapping(value = "login", method = RequestMethod.GET)
    public String Login(){
        return "/admin/login";
    }

//    @SessionAttributes("email")
//    @RequestMapping(value = "login", method = RequestMethod.POST)
//    public String Login(Admin admin, Model model, HttpSession session) {
//        try {
//            Admin admin1 = adminService.findAdminByUsername(admin.getUsername());
//            if (admin1 != null) {
//                session.setAttribute("username", admin.getUsername());
//                return "redirect:/manage/index";
//            } else {
//                model.addAttribute("error", "用户名或密码错误，登录失败");
//                return "/admin/login";
//            }
//        }catch (Exception e){
//            e.printStackTrace();
//            model.addAttribute("error", e);
//            return "/admin/login";
//        }
//    }

    @RequestMapping(value = "login", method = RequestMethod.POST)
    public String Login(Admin admin, Model model, HttpSession session) {
        Admin admin1 = adminService.findAdminByUsername(admin.getUsername());
        Subject subject = SecurityUtils.getSubject();
        String salt2 = admin.getPassword();
        String salt = admin.getUsername() + salt2;
        int hashIterations = 3;
        SimpleHash hash = new SimpleHash("md5", admin.getPassword(), salt, hashIterations);
        String encodedPassword = hash.toHex();
        UsernamePasswordToken token = new UsernamePasswordToken(admin.getUsername(), encodedPassword);
//        subject.login(token);
        String error = null;
        try {
            subject.login(token);
        } catch (UnknownAccountException e) {
            error = "该用户不存在";
        } catch (IncorrectCredentialsException e) {
            error = "用户名/密码错误";
        } catch (ExcessiveAttemptsException e) {
            // TODO: handle exception
            error = "登录失败多次，账户锁定10分钟";
        } catch (AuthenticationException e) {
            // 其他错误，比如锁定，如果想单独处理请单独catch处理
            error = "其他错误：" + e.getMessage();
        }
        if (error != null) {// 出错了，返回登录页面
            model.addAttribute("error", error);
            return "/admin/login";
        } else {// 登录成功
            return "redirect:/manage/index";
        }
    }
}
