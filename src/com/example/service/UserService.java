package com.example.service;
import com.example.po.Bucket;
import com.example.po.User;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

@Service("userServ")
public class UserService implements IUserService {

    public User login(String username) {
        try {
            InputStream config = Resources.getResourceAsStream("mybatis-config.xml");
            SqlSessionFactory ssf = new SqlSessionFactoryBuilder().build(config);
            SqlSession ss = ssf.openSession();

            User user = ss.selectOne("com.example.mapper.UserMapper.selectUser", username);

            ss.commit();
            ss.close();

            return user;
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public boolean register(String username,String password){
        try {
            InputStream config = Resources.getResourceAsStream("mybatis-config.xml");
            SqlSessionFactory ssf = new SqlSessionFactoryBuilder().build(config);
            SqlSession ss = ssf.openSession();

            //查找用户名是否已存在
            User check =ss.selectOne("com.example.mapper.UserMapper.selectUser",username);
            if(check!=null){
                return false;
            }else {
                User user = new User(username, password);
                ss.insert("com.example.mapper.UserMapper.addUser", user);
                ss.commit();
                ss.close();
                return true;
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }


}
