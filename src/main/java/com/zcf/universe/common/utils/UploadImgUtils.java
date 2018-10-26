//package com.zcf.universe.common.utils;
//
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//import org.springframework.beans.factory.annotation.Value;
//import org.springframework.stereotype.Component;
//import org.springframework.web.multipart.MultipartFile;
//
//import java.io.File;
//import java.util.UUID;
//
///***
// * 上传图片工具栏
// *  * six
// */
//@Component
//public class UploadImgUtils {
//    private static final Logger logger = LoggerFactory.getLogger(UploadImgUtils.class);
//
//    //springBoot @Value不支持静态变量，可以通过setter 注入进行
//    private static String pathReal;
//
//    private static String hostPort;
//
//    // 映射图片资源绝对路径
//    @Value("${file.uploadFolder}")
//    public void setPathReal(String pathReal) {
//        UploadImgUtils.pathReal = pathReal;
//    }
//
//    // 生成文件拼接地址
//    @Value("${host.port}")
//    public void setHostPort(String hostPort) {
//        UploadImgUtils.hostPort = hostPort;
//    }
//
//    /**
//     * 上传图片
//     *
//     * @param files
//     * @return
//     * @throws Exception
//     */
//    public static String uploadFiles(MultipartFile[] files) throws Exception {
//        String path = "";
//        String urls = "";
//        try {
//            if (files != null && files.length > 0) {
//                for (int i = 0; i < files.length; i++) {
//                    MultipartFile mf = files[i];
//                    if (!mf.isEmpty()) {
//                        // 生成uuid作为文件名称
//                        String uuid = UUID.randomUUID().toString().replaceAll("-", "");
//                        // 获得文件类型（可以判断如果不是图片，禁止上传）
//                        String contentType = mf.getContentType();
//                        logger.info("= = = > 图片类型：{}", contentType);
//                        // 获得文件后缀名称
//                        String imageAfterName = contentType.substring(contentType.indexOf("/") + 1);
//                        path = uuid + "." + imageAfterName;
//                        File newFile = new File(pathReal + path);
//                        logger.info("= = = > 图片创建位置：{}", pathReal + path);
//                        mf.transferTo(newFile);
//                        if (i == files.length - 1) {
//                            urls += hostPort + path;
//                        } else {
//                            urls += hostPort + path + ",";
//                        }
//                    }
//                }
//            }
//        } catch (Exception e) {
//            e.printStackTrace();
//            logger.error("#### 上传图片异常");
//        }
//        logger.info("= =  > 生成图片URL：{}", urls);
//        return urls;
//    }
//}
