package com.zcf.universe.controller.console;

import com.alibaba.fastjson.JSON;
import com.zcf.universe.common.LayUIMeun.Ueditor;
import com.zcf.universe.common.config.Ueditor.UeditorConfig;
import com.zcf.universe.common.utils.FileUploadUtils;
import org.apache.commons.io.FilenameUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.ResourceUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.text.SimpleDateFormat;
import java.util.UUID;

@Controller
public class UEditorController {



    @RequestMapping("/ueditor")
    @ResponseBody
    public String getUEditorConfig(@RequestParam("action") String param, MultipartFile upfile, HttpServletResponse response,HttpServletRequest request) throws UnsupportedEncodingException {
        Ueditor ueditor = new Ueditor();
        request.setCharacterEncoding("utf-8");
        response.setHeader("Content-Type", "text/html");
        if (param != null && param.equals("config")) {
            return UeditorConfig.UEDITOR_CONFIG;
        } else if (param != null && param.equals("uploadimage") || param.equals("uploadscrawl")) {
            if (upfile != null) {
                return uploadImage(upfile, ueditor, request);
            } else {
                ueditor.setState("文件为空");
                return JSON.toJSONString(ueditor);
            }
        } else {
            ueditor.setState("不支持该操作");
            return JSON.toJSONString(ueditor);
        }

    }

    /**
     * 图片上传
     * file 图片文件
     *
     * @return
     */
    public String uploadImage(MultipartFile file, Ueditor ueditor, HttpServletRequest request) {
        String pic_url = "";
        // 获取图片原始文件名
        String originalFilename = file.getOriginalFilename();
        // 上传图片
        pic_url = FileUploadUtils.fileUpload(file, "", "img/");
        ueditor.setState("SUCCESS");
        ueditor.setTitle(originalFilename);
        ueditor.setOriginal(originalFilename);
        ueditor.setUrl(pic_url);
        System.out.print(JSON.toJSONString(ueditor));
        return JSON.toJSONString(ueditor);


    }

}
