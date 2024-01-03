package com.example.service;

import com.example.po.Filee;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

public interface IFileService {
    public List<Filee> selectbyID(int bucket_id);
    public boolean addFile(Filee filee);
    public boolean deleteFile(int file_id);
}
