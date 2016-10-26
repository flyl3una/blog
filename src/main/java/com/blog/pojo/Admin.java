package com.blog.pojo;

/**
 * Created by fly_l on 2016/10/17.
 */
public class Admin {
//    private int id;
    private String username;
    private String password;
    private String email;

    public Admin() {
    }

    public String getUsername(){
        return username;
    }
    public void setUsername(String username){
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
