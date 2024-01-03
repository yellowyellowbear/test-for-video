package com.example.service;
import com.example.po.Bucket;
import com.example.po.User;

import java.util.List;

public interface IUserService {
    public User login(String username);
    public boolean register(String username,String password);

}
