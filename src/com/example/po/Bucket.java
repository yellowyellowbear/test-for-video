package com.example.po;

import java.util.Date;

public class Bucket {
    private int bucket_id;

    private String bucket_name;

    private Date bucket_time;


    private int user_id;

    public int getBucket_id() {
        return bucket_id;
    }

    @Override
    public String toString() {
        return "Bucket{" +
                "bucket_id=" + bucket_id +
                ", bucket_name='" + bucket_name + '\'' +
                ", user_id=" + user_id +
                '}';
    }

    public Bucket(String bucket_name, Date bucket_time, int user_id) {
        this.bucket_name = bucket_name;
        this.bucket_time = bucket_time;
        this.user_id = user_id;
    }

    public void setBucket_id(int bucket_id) {
        this.bucket_id = bucket_id;
    }

    public String getBucket_name() {
        return bucket_name;
    }

    public Bucket() {
    }

    public Bucket(String bucket_name) {
        this.bucket_name = bucket_name;
    }

    public Bucket(String bucket_name, int user_id) {
        this.bucket_name = bucket_name;
        this.user_id = user_id;
    }

    public void setBucket_name(String bucket_name) {
        this.bucket_name = bucket_name;
    }

    public int getUser_id() {
        return user_id;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }

    public Date getBucket_time() {
        return bucket_time;
    }

    public void setBucket_time(Date bucket_time) {
        this.bucket_time = bucket_time;
    }
}
