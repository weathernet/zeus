package com.zcf.universe.common.utils;

import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * Created by YuanQJ on 2018/10/18.
 */
public class FileUploadUtils {


    //    private static final String RETURN_IMAGE_URL = "http://47.97.163.4:9230/";//nginx 图片服务器的端口
//    private static final String IMAGE_URL = "C:/images/";//nginx 图片服务器的存储路径
    private static final String IMAGE_URL = "G:/zeus/";//
    private static final String RETURN_IMAGE_URL = "http://192.168.31.8:8089/zeus/";
    //private static final String RETURN_IMAGE_URL = "http://wqsd.free.idcfengye.com/";

    public static Map wangEditorImagesUpload(MultipartFile[] file, String pathVal, String customPath) {
        List<String> url = new ArrayList<>();
        String ImgURL = filesUpload(file, pathVal, customPath);
        String[] split = ImgURL.split(",");
        for (int i = 0; i < split.length; i++) {
            url.add(split[i]);
        }
        Map map = new HashMap();
        map.put("errno", "0");
        map.put("data", url);
        return map;
    }

    /**
     * LayUI 的图片上传的返回值
     *
     * @param file
     * @param pathVal
     * @return
     */
    public static Map uploadLayUiImg(MultipartFile file, String pathVal, String customPath) {
        String ImgURL = fileUpload(file, pathVal, customPath);
        Map LayUiImageResult = new HashMap<String, String>();
        Map ImgSrc = new HashMap<String, String>();
        LayUiImageResult.put("code", 0);
        LayUiImageResult.put("msg", "成功");
        LayUiImageResult.put("data", ImgSrc);
        ImgSrc.put("src", ImgURL);
        return LayUiImageResult;
    }

    /**
     * @param file    文件数组
     * @param pathVal 图片上传的路径
     * @return 返回字符拼接的图片路径
     */
    public static String filesUpload(MultipartFile[] file, String pathVal, String customPath) {
        // 用来检测程序运行时间
        long startTime = System.currentTimeMillis();
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");//设置日期格式
        String format = df.format(new Date());
        String saveFilePath = customPath + format + "/";
        /* 构建文件目录 */
        File fileDir = new File(IMAGE_URL + saveFilePath);
        if (!fileDir.exists()) {
            fileDir.mkdirs();
        }
        StringBuilder fileName = new StringBuilder();
        if (file != null && file.length > 0) {
            try {
                for (int i = 0; i < file.length; i++) {
                    if (!file[i].isEmpty()) {
                        String filename = file[i].getOriginalFilename();
                        String ExtensionName = filename.substring(filename.lastIndexOf(".") + 1);// 获取文件的扩展名如:mp4
                        String Millisecond = String.valueOf(System.currentTimeMillis());// 获取当前时间的毫秒数
                        String NewFileName = Millisecond + "." + ExtensionName;// 该文件在系统中的名字
                        String FileName = RETURN_IMAGE_URL + saveFilePath + NewFileName;// 文件存储的路径
                        String path = IMAGE_URL + saveFilePath + NewFileName; // 文件储存绝对路径
                        File newFile = new File(path);
                        if (i == file.length - 1) {
                            fileName.append(FileName);
                        } else {
                            fileName.append(FileName).append(",");
                        }
                        file[i].transferTo(newFile); // 直接写文件
                    }
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        long endTime = System.currentTimeMillis();
        System.out.println("方法的运行时间：" + String.valueOf(endTime - startTime) + "ms");
        return fileName.toString();
    }

    /**
     * @param file    文件
     * @param pathVal 图片上传的路径
     * @return 返回图片的路径
     * String pathval = request.getSession().getServletContext().getRealPath("/") + "WEB-INF/";
     */
    public static String fileUpload(MultipartFile file, String pathVal, String customPath) {
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");//设置日期格式
        String format = df.format(new Date());
        String saveFilePath = customPath + format + "/";
        /* 构建文件目录 */
        File fileDir = new File(IMAGE_URL + saveFilePath);
        if (!fileDir.exists()) {
            fileDir.mkdirs();
        }
        if (file != null) {
            String filename = file.getOriginalFilename();// 获取上传文件的全名
            String ExtensionName = filename.substring(filename.lastIndexOf(".") + 1);// 获取文件的扩展名如:mp4
            String Millisecond = String.valueOf(System.currentTimeMillis());// 获取当前时间的毫秒数
            String Milliseconds = Millisecond + Random();
            String NewFileName = Milliseconds + "." + ExtensionName;// 该文件在系统中的名字
            String FileName = RETURN_IMAGE_URL + saveFilePath + NewFileName;// 文件存储的路径
            String path = IMAGE_URL + saveFilePath + NewFileName; // 文件储存绝对路径
            System.out.println(path);
            File newFile = new File(path);//创建文件路径
            try {
                file.transferTo(newFile); // 通过MultipartFile的方法直接写文件（注意这个时候）
            } catch (IOException e) {
                e.printStackTrace();
            }
            System.err.println(FileName);
            return FileName;
        }
        return null;
    }

    //获取随机数
    private static String Random() {
        Random random = new Random();
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < 6; i++) {
            result.append(random.nextInt(10));
        }
        return result.toString();
    }

}