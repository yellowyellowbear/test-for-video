package com.example.po;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.sql.*;

public class User {
    private int user_id;
    private String user_name;
    private String user_password;
    private String user_permission;

    public User() {
    }

    public int getUser_id() {
        return user_id;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }

    public String getUser_name() {
        return user_name;
    }

    public void setUser_name(String user_name) {
        this.user_name = user_name;
    }

    public String getUser_password() {
        return user_password;
    }

    public void setUser_password(String user_password) {
        this.user_password = user_password;
    }

    public String getUser_permission() {
        return user_permission;
    }

    public void setUser_permission(String user_permission) {
        this.user_permission = user_permission;
    }

    public User(String user_name, String user_password) {
        this.user_name = user_name;
        this.user_password = user_password;
    }

    @Override
    public String toString() {
        return "User{" +
                "user_id=" + user_id +
                ", user_name='" + user_name + '\'' +
                ", user_password='" + user_password + '\'' +
                ", user_permission='" + user_permission + '\'' +
                '}';
    }
}
