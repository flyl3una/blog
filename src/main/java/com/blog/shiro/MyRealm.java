package com.blog.shiro;

import com.blog.pojo.Admin;
import com.blog.service.AdminService;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.crypto.SecureRandomNumberGenerator;
import org.apache.shiro.crypto.hash.SimpleHash;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.util.ByteSource;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Set;


/**
 * Created by fly_l on 2016/10/12.
 */
public class MyRealm extends AuthorizingRealm {

    @Autowired
    private AdminService adminService;

//  用户权限的认证
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        String username = principalCollection.getPrimaryPrincipal().toString();
        SimpleAuthorizationInfo info = new SimpleAuthorizationInfo();
        Admin admin = adminService.findAdminByUsername(username);
        info.addStringPermission(admin.getUsername());
        info.addStringPermission(admin.getPassword());
//        Set<String> roleName = adminService.findRoles(username);
//        Set<String> permissions = adminService.findPermissions(username);
//        info.setRoles(roleName);
//        info.setStringPermissions(permissions);
        return info;
//        return null;
    }

//  首先执行这个登录验证
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {
//        String username = authenticationToken.getPrincipal().toString();
        UsernamePasswordToken upToken=(UsernamePasswordToken) authenticationToken;
        String username=upToken.getUsername();
        String password=new String(upToken.getPassword());
//        获取用户账号
        Admin admin = adminService.findAdminByUsername(username);
        if(admin == null){
//            throw new UnknownAccountException();
            return null;
        }
        //            将查询到的用户账号和密码存放到authenticationInfo用于后面的权限判断，第三个salt参数随便放一个就行。
        AuthenticationInfo authenticationInfo = new SimpleAuthenticationInfo(
                username, password, getName());//, ByteSource.Util.bytes(salt)
        return authenticationInfo;
    }
}
