package com.example.service;

import com.example.po.Bucket;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.io.InputStream;
import java.util.Date;
import java.util.List;

@Service("bucketServ")
public class BucketService implements IBucketService {

    @Override
    public boolean create(String bucket_name, Date bucket_time,int bucket_id) {
        try {
            InputStream config = Resources.getResourceAsStream("mybatis-config.xml");
            SqlSessionFactory ssf = new SqlSessionFactoryBuilder().build(config);
            SqlSession ss = ssf.openSession();
            Bucket bucket=new Bucket(bucket_name,bucket_time,bucket_id);
            int key = ss.insert("com.example.mapper.BucketMapper.createBucket",bucket);
            ss.commit();
            ss.close();
            return key==1;
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public boolean delete(String bucket_name) {
        try {
            InputStream config = Resources.getResourceAsStream("mybatis-config.xml");
            SqlSessionFactory ssf = new SqlSessionFactoryBuilder().build(config);
            SqlSession ss = ssf.openSession();
            int key = ss.delete("com.example.mapper.BucketMapper.deleteBucket",bucket_name);
            ss.commit();
            ss.close();
            return key==1;
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public Bucket get(String bucket_name) {

        try {
            InputStream config = Resources.getResourceAsStream("mybatis-config.xml");
            SqlSessionFactory ssf = new SqlSessionFactoryBuilder().build(config);
            SqlSession ss = ssf.openSession();

            Bucket bucket = ss.selectOne("com.example.mapper.BucketMapper.getBucket", bucket_name);

            ss.commit();
            ss.close();

            if(bucket!=null){
                return bucket;
            }

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return null;
    }

    @Override
    public boolean put(String bucket_name) {
        return false;
    }

    @Override
    public List<Bucket> getAll() {
        try {
            InputStream config = Resources.getResourceAsStream("mybatis-config.xml");
            SqlSessionFactory ssf = new SqlSessionFactoryBuilder().build(config);
            SqlSession ss = ssf.openSession();

            List<Bucket> buckets = ss.selectList("com.example.mapper.BucketMapper.getAll");

            ss.commit();
            ss.close();

            return buckets;

        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }
}
