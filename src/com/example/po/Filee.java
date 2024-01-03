package com.example.po;


import java.util.Date;

public class Filee {
    private int file_id;

    private String file_name;

    private String file_url;

    public Filee() {
    }

    private Date file_time;
    private String file_describe;
    private int bucket_id;


    public int getFile_id() {
        return file_id;
    }

    public void setFile_id(int file_id) {
        this.file_id = file_id;
    }

    public String getFile_name() {
        return file_name;
    }

    public void setFile_name(String file_name) {
        this.file_name = file_name;
    }

    public Date getFile_time() {
        return file_time;
    }

    public void setFile_time(Date file_time) {
        this.file_time = file_time;
    }

    public String getFile_describe() {
        return file_describe;
    }

    public void setFile_describe(String file_describe) {
        this.file_describe = file_describe;
    }

    public int getBucket_id() {
        return bucket_id;
    }

    public void setBucket_id(int bucket_id) {
        this.bucket_id = bucket_id;
    }

    public Filee(String file_name, String file_url, Date file_time, String file_describe, int bucket_id) {
        this.file_name = file_name;
        this.file_url = file_url;
        this.file_time = file_time;
        this.file_describe = file_describe;
        this.bucket_id = bucket_id;
    }

    @Override
    public String toString() {
        return "Filee{" +
                "file_id=" + file_id +
                ", file_name='" + file_name + '\'' +
                ", file_url='" + file_url + '\'' +
                ", file_time=" + file_time +
                ", file_describe='" + file_describe + '\'' +
                ", bucket_id=" + bucket_id +
                '}';
    }

    public Filee(int file_id, String file_name, String file_url, Date file_time, String file_describe, int bucket_id) {
        this.file_id = file_id;
        this.file_name = file_name;
        this.file_url = file_url;
        this.file_time = file_time;
        this.file_describe = file_describe;
        this.bucket_id = bucket_id;
    }



    public String getFile_url() {
        return file_url;
    }

    public void setFile_url(String file_url) {
        this.file_url = file_url;
    }
}
