package com.example.controller;

import com.example.po.Filee;
import com.example.service.IFileService;
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileItemFactory;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;

import java.util.Date;
import java.util.List;

@Controller
public class FileController {
    private static final Log logger = LogFactory.getLog(FileController.class);
    @Autowired
    @Qualifier("fileServ")
    private IFileService fileServ;


    @RequestMapping("/addFile")
    public String addFile(HttpServletRequest req,Model model)  {

        if(ServletFileUpload.isMultipartContent(req)){
            //创建FileItemFactory工厂实现类
            FileItemFactory factory = new DiskFileItemFactory();
            //创建用于解析数据的工具类ServletFileUpload类
            ServletFileUpload servletFileUpload = new ServletFileUpload(factory);
            try {
                //解析上传的数据，得到每一个表单项FileItem
                List<FileItem> list = servletFileUpload.parseRequest(req);
                //判断每个表单项是普通类型还是上传的文件

                String file_name="";
                String file_url="";

                for(FileItem item : list){
                    if(item.isFormField()){
                        file_name=item.getString("UTF-8");
                    }
                    else{
                         file_url="C:\\Users\\Bo\\Desktop\\jav231\\javaee\\bucket_list\\test-1\\"+item.getName();


                        item.write(new File(file_url));

                    }
                }

                String file_describe="一张普通的图片";
                Date file_time=new Date();
                Filee filee=new Filee(file_name,file_url,file_time,file_describe,1);

                if(fileServ.addFile(filee)){
                    //提示添加文件成功
                }else {
                    //提示添加文件失败
                }

            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        List<Filee> files = fileServ.selectbyID(1);
        model.addAttribute("bucket_name","");   //bucket_name
        model.addAttribute("files",files);
        return "file";
    }


    @RequestMapping("/goFile")
    public String goFile(@RequestParam("bucket_id") int bucket_id, @RequestParam("bucket_name") String bucket_name, Model model)  {

       List<Filee> files = fileServ.selectbyID(bucket_id);

       model.addAttribute("bucket_id",bucket_id);
       model.addAttribute("bucket_name",bucket_name);
       model.addAttribute("files",files);

        return "file";
    }




    @RequestMapping("/deleteFile")
    public String deleteFile(@RequestParam("file_id") int file_id,Model model){


        fileServ.deleteFile(file_id);
        model.addAttribute("bucket_name","");   //bucket_name


        return "file";

    }

}
