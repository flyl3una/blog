package com.blog.controller;

import com.blog.fastjson.UploadImgResult;
import org.apache.commons.io.FileUtils;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;
import java.util.UUID;

/**
 * Created by fly_l on 2016/10/24.
 */
@Controller
public class UploadFileController {

    private static final String[] types={
            "jpg",
            "jpeg",
            "png",
            "ico",
            "gif",
            "bmp",
            "webp"
    };

    @ResponseBody
    @RequestMapping(value = "uploadImg", method = RequestMethod.POST)
    public UploadImgResult uploadImg(@RequestParam(value = "editormd-image-file", required = false)MultipartFile image,
                            HttpServletRequest request){
        try{
            UploadImgResult imgResult = new UploadImgResult();
            imgResult.setSuccess(0);

            String orgImgName = image.getOriginalFilename();
            String[] list = orgImgName.split("\\.");
            int len = list.length;
            if(len < 2){
                imgResult.setMessage("文件名错误");
                return imgResult;
//                return "{\"success\": 0,\"message\": \"文件名错误\"}";
            }
            String suffix = list[len-1];
            boolean flag = false;
            for(String i : types){
                if(suffix.equalsIgnoreCase(i)){
                    flag = true;
                    break;
                }
            }
            if(flag == false){
                imgResult.setMessage("请上传图片，允许格式为jpg、jpeg、ico、png、gif、bmp、webp");
//                return "{\"success\": 0,\"message\": \"请上传图片，允许格式为jpg、jpeg、ico、png、gif、bmp、webp\"}";
            }
            String newImgName = System.currentTimeMillis() + "." + suffix;
            String rootPath = request.getSession().getServletContext().getRealPath("/upload/images/");
            File filePath = new File(rootPath);
            if(!filePath.exists()){
                filePath.mkdirs();
            }
            //最终图片路径
            File realFile = new File(rootPath+File.separator+newImgName);
            FileUtils.copyInputStreamToFile(image.getInputStream(), realFile);
            imgResult.setSuccess(1);
            imgResult.setMessage("上传成功");
            imgResult.setUrl(realFile.toString());
            return imgResult;
//            return "{\"success\": 1, \"message\":\"上传成功\",\"url\":\""+realFile + "\"}";
        }catch (Exception e){
            e.printStackTrace();
//            return  "{\"success\": 0,\"message\": \"error\"}";
            UploadImgResult imgResultError = new UploadImgResult();
            imgResultError.setSuccess(0);
            imgResultError.setMessage("error");
            return imgResultError;
        }
    }
}
