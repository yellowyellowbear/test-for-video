package com.example.controller;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.example.po.Bucket;
import com.example.service.IBucketService;
import com.example.service.IUserService;
import com.example.po.User;
//import jdk.nashorn.internal.ir.RuntimeNode;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.beans.factory.annotation.Autowired;

import java.io.File;
import java.lang.annotation.Annotation;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

@Controller
public class BucketController {
    private static final Log logger = LogFactory.getLog(BucketController.class);
    @Autowired
    @Qualifier("bucketServ")
    private IBucketService bucketServ;

    @RequestMapping("/getBucket")
    public String getBucket(@RequestParam("bucket_name") String bucket_name , Model model) {
        Bucket bucket=bucketServ.get(bucket_name);
        if (bucket!=null) {

            model.addAttribute("bucket_id",bucket.getBucket_id());
            model.addAttribute("bucket_name", bucket.getBucket_name());

            return "file";
        }
        else {

            List<Bucket> buckets=bucketServ.getAll();
            model.addAttribute("buckets",buckets);

            return "bucket";
        }
    }

    @RequestMapping("/createBucket")
    public String createBucket(@RequestParam("bucket_name") String bucket_name,@RequestParam("user_id") int user_id,Model model){
        Date bucket_time=new Date();

        if(bucketServ.create(bucket_name,bucket_time,user_id)){
            String folderPath = "C:\\Users\\Bo\\Desktop\\jav231\\javaee\\bucket_list\\"+bucket_name;
            File folder = new File(folderPath);
            if (!folder.exists()) {
                folder.mkdirs();
            }
        }

        List<Bucket> buckets=bucketServ.getAll();
        model.addAttribute("buckets",buckets);

        return "bucket";
    }

    @RequestMapping("/deleteBucket")
    public String deleteBucket(@RequestParam("bucket_name") String bucket_name,Model model){

        if(bucketServ.delete(bucket_name)) {
            String folderPath = "C:\\Users\\Bo\\Desktop\\jav231\\javaee\\bucket_list\\" + bucket_name;
            File folder = new File(folderPath);
            if (folder.exists()) {
                folder.delete();
            }
        }

        List<Bucket> buckets=bucketServ.getAll();
        model.addAttribute("buckets",buckets);

        return "bucket";
    }




    @RequestMapping("/getBuckets")
    public String getBuckets(Model model) {

        List<Bucket> buckets=bucketServ.getAll();

        model.addAttribute("buckets",buckets);

        return "bucket";
    }



}
