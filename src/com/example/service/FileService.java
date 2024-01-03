package com.example.service;
import com.example.po.Filee;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.springframework.stereotype.Service;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;

@Service("fileServ")
public class FileService implements IFileService{

    @Override
    public List<Filee> selectbyID(int bucket_id) {
        try {
            InputStream config = Resources.getResourceAsStream("mybatis-config.xml");
            SqlSessionFactory ssf = new SqlSessionFactoryBuilder().build(config);
            SqlSession ss = ssf.openSession();

            List<Filee> filees =ss.selectList("com.example.mapper.FileMapper.selectID",1);

            ss.commit();
            ss.close();
            return filees;
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public boolean addFile(Filee filee){
        try {
            InputStream config = Resources.getResourceAsStream("mybatis-config.xml");
            SqlSessionFactory ssf = new SqlSessionFactoryBuilder().build(config);
            SqlSession ss = ssf.openSession();

            int key = ss.insert("com.example.mapper.FileMapper.addFile",filee);

            ss.commit();
            ss.close();
            return key==1;
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }

    @Override
    public boolean deleteFile(int file_id) {

        try {
            InputStream config = Resources.getResourceAsStream("mybatis-config.xml");
            SqlSessionFactory ssf = new SqlSessionFactoryBuilder().build(config);
            SqlSession ss = ssf.openSession();

            int key = ss.delete("com.example.mapper.FileMapper.deleteFile",file_id);

            ss.commit();
            ss.close();
            return key==1;
        } catch (IOException e) {
            throw new RuntimeException(e);
        }


    }
}
