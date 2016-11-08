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

import javax.imageio.ImageIO;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
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

    /**
     * 按照固定宽高原图压缩
     *
     * @param img
     * @param width
     * @param height
     * @param out
     * @throws IOException
     */
    public static void thumbnail(File img, int width, int height,
                                 OutputStream out) throws IOException {
        BufferedImage BI = ImageIO.read(img);
        Image image = BI.getScaledInstance(width, height, Image.SCALE_SMOOTH);

        BufferedImage tag = new BufferedImage(width, height,
                BufferedImage.TYPE_INT_RGB);
        Graphics g = tag.getGraphics();
        g.setColor(Color.RED);
        g.drawImage(image, 0, 0, null); // 绘制处理后的图
        g.dispose();
        ImageIO.write(tag, "JPEG", out);
    }

    /**
     * 按照 宽高 比例压缩
     *
     * @param img
     * @param width
     * @param height
     * @param out
     * @throws IOException
     */
    public static void thumbnail_w_h(File img, int width, int height,
                                     OutputStream out) throws IOException {
        BufferedImage bi = ImageIO.read(img);
        double srcWidth = bi.getWidth(); // 源图宽度
        double srcHeight = bi.getHeight(); // 源图高度
        double scale = 1;
        if (width > 0) {
            scale = width / srcWidth;
        }
        if (height > 0) {
            scale = height / srcHeight;
        }
        if (width > 0 && height > 0) {
            scale = height / srcHeight < width / srcWidth ? height / srcHeight
                    : width / srcWidth;
        }
        thumbnail(img, (int) (srcWidth * scale), (int) (srcHeight * scale), out);
    }

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
            }
            String newImgName = System.currentTimeMillis() + "." + suffix;
            String rootPath = request.getSession().getServletContext().getRealPath("/WEB-INF/upload/images/");
            File filePath = new File(rootPath);
            if(!filePath.exists()){
                filePath.mkdirs();
            }
            //最终图片路径
            File realFile = new File(rootPath+File.separator+newImgName);
            FileUtils.copyInputStreamToFile(image.getInputStream(), realFile);
            String thumbName = System.currentTimeMillis() + "." + suffix;
            FileOutputStream fos = new FileOutputStream(rootPath+File.separator+thumbName);
//            thumbnail(realFile, 960, 870, fos);
            thumbnail_w_h(realFile, 900, 600, fos);
            imgResult.setSuccess(1);
            imgResult.setMessage("上传成功");
            imgResult.setUrl("/upload/images/"+thumbName);
            return imgResult;
        }catch (Exception e){
            e.printStackTrace();
            UploadImgResult imgResultError = new UploadImgResult();
            imgResultError.setSuccess(0);
            imgResultError.setMessage("error");
            return imgResultError;
        }
    }
}
