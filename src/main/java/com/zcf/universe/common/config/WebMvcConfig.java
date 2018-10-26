package com.zcf.universe.common.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * 上传图片绝对地址与映射url地址
 */

@Configuration
public class WebMvcConfig implements WebMvcConfigurer {
    /**
     * 本地文件映射的url路径
     */
    @Value("${file.staticAccessPath}")
    private String staticAccessPath;

    /**
     * 映射图片资源绝对路径
     */
    @Value("${file.uploadFolder}")
    private String uploadFolder;

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        //文件磁盘图片url 映射
        registry.addResourceHandler(staticAccessPath).addResourceLocations("file:" + uploadFolder);
    }
}
