package com.example.service;

import com.example.po.Bucket;

import java.util.Date;
import java.util.List;

public interface IBucketService {
    public boolean create(String bucket_name, Date bucket_time, int user_id);
    public boolean delete(String bucket_name);
    public Bucket get(String bucket_name);
    public boolean put(String bucket_name);
    public List<Bucket> getAll();
}
