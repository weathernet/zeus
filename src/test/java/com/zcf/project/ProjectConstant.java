package com.zcf.project;

/**
 * @author yuan
 * @date 2018/11/15 0015
 */
public class ProjectConstant {
    public static final String BASE_PACKAGE = "com.zcf.universe";//生成代码所在的基础包名称，可根据自己公司的项目修改（注意：这个配置修改之后需要手工修改src目录项目默认的包路径，使其保持一致，不然会找不到类）
    public static final String MODEL_PACKAGE = BASE_PACKAGE + ".pojo";//生成的Model所在包
    public static final String MAPPER_PACKAGE = BASE_PACKAGE + ".mapper";//生成的Mapper所在包
    public static final String SERVICE_PACKAGE = BASE_PACKAGE + ".service";//生成的Service所在包
    public static final String CONTROLLER_PACKAGE = BASE_PACKAGE + ".controller";//生成的Controller所在包
    public static final String UTIL_PACKAGE = BASE_PACKAGE + ".utils";//生成的工具类所在的包
    public static final String JS_PACKAGE = BASE_PACKAGE + ".js";//生成的LayUiJS所在的包
    public static final String VIEW_PACKAGE = BASE_PACKAGE + ".view";//生成的LayUI视图所在的包
    public static final String MAPPER_INTERFACE_REFERENCE = "tk.mybatis.mapper.common.Mapper";//Mapper插件基础接口的完全限定名
}
