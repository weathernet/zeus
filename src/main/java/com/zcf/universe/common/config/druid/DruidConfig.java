package com.zcf.universe.common.config.druid;

import com.alibaba.druid.pool.DruidDataSource;
import com.alibaba.druid.support.http.StatViewServlet;
import com.alibaba.druid.support.http.WebStatFilter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * @author yuan
 * @date 2018/11/20 0020
 */
@Configuration
public class DruidConfig {

    //把DruidDataSource添加到ioc容器中，并且prefix = "spring.datasource"，让application.yml里的数据源其他配置属性生效
    @Bean
    @ConfigurationProperties(prefix = "spring.datasource")
    public DataSource druid() {
        return new DruidDataSource();
    }

    //配置druid监控

    //1.配置一个管理后台的servlet
    @Bean
    public ServletRegistrationBean startViewServlet() {
        ServletRegistrationBean servletRegistrationBean = new ServletRegistrationBean(new StatViewServlet(), "/druid/*");
        Map<String, String> map = new HashMap<>();
        //用户名
        map.put("loginUsername", "admin");
        //密码
        map.put("loginPassword", "admin");
        //IP白名单(没有配置或者为空，则允许所有访问)
        map.put("allow", "");
        //IP黑名单(存在共同时，deny优先于allow)
        map.put("deny", "192.168.15.109");
        servletRegistrationBean.setInitParameters(map);
        return servletRegistrationBean;
    }


    //2.配置一个web监控的filter
    @Bean
    public FilterRegistrationBean webStartFilter() {
        FilterRegistrationBean filterRegistrationBean = new FilterRegistrationBean(new WebStatFilter());
        Map<String, String> map = new HashMap<>();
        map.put("exclusions", "*.js,*.css,/druid/*");
        filterRegistrationBean.setInitParameters(map);
        filterRegistrationBean.setUrlPatterns(Arrays.asList("/*"));
        return filterRegistrationBean;
    }
}