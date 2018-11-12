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


    @Autowired
    private HttpServletRequest request;

    static final String uploadRootDir = "words/src/main/resources";

    @RequestMapping("/ueditor")
    @ResponseBody
    public String getUEditorConfig(@RequestParam("action") String param, MultipartFile upfile, HttpServletResponse response, HttpServletRequest request) throws UnsupportedEncodingException {
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
        try {
            // 获取图片原始文件名
            String originalFilename = file.getOriginalFilename();
            // 文件名使用当前时间
            String name = UUID.randomUUID().toString();
            String fp = new SimpleDateFormat("yyyyMMdd").format(new java.util.Date());
            // 获取上传图片的扩展名(jpg/png/...)
            String extension = FilenameUtils.getExtension(originalFilename);
            // 图片上传的相对路径（因为相对路径放到页面上就可以显示图片）
            String path = ResourceUtils.getURL("classpath:").getPath() + "static/";
            // 上传图片
            pic_url = FileUploadUtils.fileUpload(file, path, "/userfiles/fileupload/");

            ueditor.setState("SUCCESS");
            ueditor.setTitle(originalFilename);
            ueditor.setOriginal(originalFilename);
            ueditor.setUrl("/words" + pic_url);
            System.out.print(JSON.toJSONString(ueditor));
            return JSON.toJSONString(ueditor);
        } catch (IOException e) {
            e.printStackTrace();
            ueditor.setState("上传失败");
            return JSON.toJSONString(ueditor);
        }
    }

}
