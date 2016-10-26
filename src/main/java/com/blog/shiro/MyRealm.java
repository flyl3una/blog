package com.blog.shiro;

import com.blog.service.AdminService;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.springframework.beans.factory.annotation.Autowired;



/**
 * Created by fly_l on 2016/10/12.
 */
public class MyRealm extends AuthorizingRealm {

    @Autowired
    private AdminService adminService;

//  用户权限的认证
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
//        String username = principalCollection.getPrimaryPrincipal().toString();
//        SimpleAuthorizationInfo info = new SimpleAuthorizationInfo();
//        Set<String> roleName = userService.findRoles(username);
//        Set<String> permissions = userService.findPermissions(username);
//        info.setRoles(roleName);
//        info.setStringPermissions(permissions);
//        return info;
        return null;
    }

//  首先执行这个登录验证
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {
//        String username = authenticationToken.getPrincipal().toString();
////        获取用户账号
//        Admin admin = adminService.findAdminByUsername(username);
//        if(user != null){
////            将查询到的用户账号和密码存放到authenticationInfo用于后面的权限判断，第三个参数随便放一个就行。
//            AuthenticationInfo authenticationInfo = new SimpleAuthenticationInfo(
//                    admin.getUsername(), admin.getPassword(), "a");
//            return authenticationInfo;
//        }else{
//            return null;
//        }
        return null;
    }
}
