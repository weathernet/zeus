import com.project.NameUtils;
import com.project.ResultType;
import com.google.common.base.CaseFormat;
import freemarker.template.TemplateExceptionHandler;
import org.apache.commons.lang3.StringUtils;
import org.mybatis.generator.api.MyBatisGenerator;
import org.mybatis.generator.config.*;
import org.mybatis.generator.internal.DefaultShellCallback;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.sql.*;
import java.util.*;

import static com.project.JDBCProperties.*;
import static com.project.ProjectConstant.*;


/**
 * 代码生成器，根据数据表名称生成对应的Model、Mapper、Service、Controller简化开发。
 */
public class CodeGenerator {
    /**
     * 主程序入口
     */
    public static void main(String[] args) {
        //genLayUi("", null);//生成LayUi的返回值
        //genFile("",null);//生成文件上传工具
        genCode("");
        //genCodeByCustomModelName("输入表名","输入自定义Model名称");
//        List<ResultType> name = getTableName("move_order");
//        name.forEach(item->System.out.println(item.getName()));

    }

    public static List<ResultType> getTableName(String tableName) {
        try {
            String URL = JDBC_URL;
            String USER = JDBC_USERNAME;
            String PASSWORD = JDBC_PASSWORD;
            //1.加载驱动程序
            Class.forName(JDBC_DIVER_CLASS_NAME);
            //2.获得数据库链接
            Connection conn = null;
            conn = DriverManager.getConnection(URL, USER, PASSWORD);
            //3.通过数据库的连接操作数据库，实现增删改查（使用Statement类）
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery("select COLUMN_NAME,DATA_TYPE,COLUMN_COMMENT from information_schema.COLUMNS where table_name ='" + tableName + "'"
                    + "and table_schema = 'case'");
            //4.处理数据库的返回结果(使用ResultSet类)
            List<ResultType> all = new ArrayList<>();
            while (rs.next()) {
                String columnName = rs.getString("COLUMN_NAME");
                String humnName = NameUtils.getHumnName(columnName);
                String dataType = rs.getString("DATA_TYPE");
                String columnComment = rs.getString("COLUMN_COMMENT");
                ResultType resultType = new ResultType(humnName, dataType, columnComment, columnName);
                all.add(resultType);
            }
            //关闭资源
            rs.close();
            st.close();
            conn.close();
            return all;
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * 通过数据表名称生成代码，Model 名称通过解析数据表名称获得，下划线转大驼峰的形式。
     * 如输入表名称 "t_user_detail" 将生成 TUserDetail、TUserDetailMapper、TUserDetailService ...
     *
     * @param tableNames 数据表名称...
     */
    public static void genCode(String... tableNames) {
        for (String tableName : tableNames) {
            genCodeByCustomModelName(tableName, null);
        }
    }

    /**
     * 通过数据表名称，和自定义的 Model 名称生成代码
     * 如输入表名称 "t_user_detail" 和自定义的 Model 名称 "User" 将生成 User、UserMapper、UserService ...
     *
     * @param tableName 数据表名称
     * @param modelName 自定义的 Model 名称
     */
    public static void genCodeByCustomModelName(String tableName, String modelName) {
        genRestFulController(tableName, modelName);//获取RestFul接口
        getRestFulService(tableName, modelName);//获取RestFul接口
        genController(tableName, modelName);//获取LayUiController
        genService(tableName, modelName);//获取LayUiService
        genLayUiList(tableName, modelName);//获取表格
        genLayUiFrom(tableName, modelName);//获取form
        genLayUiJS(tableName, modelName);//获取LayUiJS
        getPoJo(tableName, modelName);//获取实体类
        getMapper(tableName, modelName);//获取Mapper
        //getMapperResult(tableName, modelName);
    }

    private static void genService(String tableName, String modelName) {
        try {
            freemarker.template.Configuration cfg = getConfiguration();
            Map<String, Object> data = new HashMap<>();
            data.put("date", DATE);
            data.put("author", AUTHOR);
            String modelNameUpperCamel = StringUtils.isEmpty(modelName) ? tableNameConvertUpperCamel(tableName) : modelName;
            data.put("modelNameUpperCamel", modelNameUpperCamel);
            data.put("modelNameLowerCamel", tableNameConvertLowerCamel(tableName));
            data.put("basePackage", BASE_PACKAGE);
            List<ResultType> tableName1 = getTableName(tableName);
            data.put("modeListDetails", tableName1);
            File file = new File(PROJECT_PATH + JAVA_PATH + PACKAGE_PATH_SERVICE + "layui/" + "LayUi" + modelNameUpperCamel + "Service.java");
            if (!file.getParentFile().exists()) {
                file.getParentFile().mkdirs();
            }
            cfg.getTemplate("service.ftl").process(data, new FileWriter(file));
            System.out.println(modelNameUpperCamel + "Service.java 生成成功");

        } catch (Exception e) {
            throw new RuntimeException("生成Service失败", e);
        }
    }

    private static void getRestFulService(String tableName, String modelName) {
        try {
            freemarker.template.Configuration cfg = getConfiguration();
            Map<String, Object> data = new HashMap<>();
            data.put("date", DATE);
            data.put("author", AUTHOR);
            String modelNameUpperCamel = StringUtils.isEmpty(modelName) ? tableNameConvertUpperCamel(tableName) : modelName;
            data.put("modelNameUpperCamel", modelNameUpperCamel);
            data.put("modelNameLowerCamel", tableNameConvertLowerCamel(tableName));
            data.put("basePackage", BASE_PACKAGE);
            File file = new File(PROJECT_PATH + JAVA_PATH + PACKAGE_PATH_SERVICE + modelNameUpperCamel + "Service.java");
            if (!file.getParentFile().exists()) {
                file.getParentFile().mkdirs();
            }
            cfg.getTemplate("service-restful.ftl").process(data, new FileWriter(file));
            System.out.println(modelNameUpperCamel + "Service.java 生成成功");

        } catch (Exception e) {
            throw new RuntimeException("生成Service失败", e);
        }
    }

    private static void genController(String tableName, String modelName) {
        try {
            freemarker.template.Configuration cfg = getConfiguration();
            Map<String, Object> data = new HashMap<>();
            data.put("date", DATE);
            data.put("author", AUTHOR);
            String modelNameUpperCamel = StringUtils.isEmpty(modelName) ? tableNameConvertUpperCamel(tableName) : modelName;
            data.put("baseRequestMapping", modelNameConvertMappingPath(modelNameUpperCamel));
            data.put("modelNameUpperCamel", modelNameUpperCamel);
            data.put("modelNameLowerCamel", CaseFormat.UPPER_CAMEL.to(CaseFormat.LOWER_CAMEL, modelNameUpperCamel));
            data.put("basePackage", BASE_PACKAGE);
            File file = new File(PROJECT_PATH + JAVA_PATH + PACKAGE_PATH_CONTROLLER + "console/" + "LayUi" + modelNameUpperCamel + "Controller.java");
            if (!file.getParentFile().exists()) {
                file.getParentFile().mkdirs();
            }
            cfg.getTemplate("controller.ftl").process(data, new FileWriter(file));

            System.out.println(modelNameUpperCamel + "Controller.java 生成成功");
        } catch (Exception e) {
            throw new RuntimeException("生成Controller失败", e);
        }
    }

    private static void genRestFulController(String tableName, String modelName) {
        try {
            freemarker.template.Configuration cfg = getConfiguration();
            Map<String, Object> data = new HashMap<>();
            data.put("date", DATE);
            data.put("author", AUTHOR);
            String modelNameUpperCamel = StringUtils.isEmpty(modelName) ? tableNameConvertUpperCamel(tableName) : modelName;
            data.put("baseRequestMapping", modelNameConvertMappingPath(modelNameUpperCamel));
            data.put("modelNameUpperCamel", modelNameUpperCamel);
            data.put("modelNameLowerCamel", CaseFormat.UPPER_CAMEL.to(CaseFormat.LOWER_CAMEL, modelNameUpperCamel));
            data.put("basePackage", BASE_PACKAGE);
            File file = new File(PROJECT_PATH + JAVA_PATH + PACKAGE_PATH_CONTROLLER + "api/" + modelNameUpperCamel + "Controller.java");
            if (!file.getParentFile().exists()) {
                file.getParentFile().mkdirs();
            }
            cfg.getTemplate("controller-restful.ftl").process(data, new FileWriter(file));

            System.out.println(modelNameUpperCamel + "Controller.java 生成成功");
        } catch (Exception e) {
            throw new RuntimeException("生成Controller失败", e);
        }
    }

    private static void genLayUiJS(String tableName, String modelName) {
        try {
            freemarker.template.Configuration cfg = getConfiguration();
            Map<String, Object> data = new HashMap<>();
            data.put("date", DATE);
            data.put("author", AUTHOR);
            String modelNameUpperCamel = StringUtils.isEmpty(modelName) ? tableNameConvertUpperCamel(tableName) : modelName;
            String modelNameLowerCamel = StringUtils.isEmpty(modelName) ? tableNameConvertLowerCamel(tableName) : modelName;
            data.put("baseRequestMapping", modelNameConvertMappingPath(modelNameUpperCamel));
            data.put("modelNameUpperCamel", modelNameUpperCamel);
            data.put("modelNameLowerCamel", CaseFormat.UPPER_CAMEL.to(CaseFormat.LOWER_CAMEL, modelNameUpperCamel));
            data.put("basePackage", BASE_PACKAGE);
            List<ResultType> tableName1 = getTableName(tableName);
            data.put("modeListDetails", tableName1);
            File file = new File(PROJECT_PATH + RESOURCES_PATH + PACKAGE_PATH_JS + modelNameLowerCamel + ".js");
            if (!file.getParentFile().exists()) {
                file.getParentFile().mkdirs();
            }
            cfg.getTemplate("layuijs.ftl").process(data, new FileWriter(file));
            System.out.println(modelNameUpperCamel + "Js生成成功");
        } catch (Exception e) {
            throw new RuntimeException("生成Js失败", e);
        }
    }

    private static void getPoJo(String tableName, String modelName) {
        try {
            freemarker.template.Configuration cfg = getConfiguration();
            Map<String, Object> data = new HashMap<>();
            data.put("date", DATE);
            data.put("author", AUTHOR);
            String modelNameUpperCamel = StringUtils.isEmpty(modelName) ? tableNameConvertUpperCamel(tableName) : modelName;
            data.put("baseRequestMapping", modelNameConvertMappingPath(modelNameUpperCamel));
            data.put("modelNameUpperCamel", modelNameUpperCamel);
            data.put("modelNameLowerCamel", CaseFormat.UPPER_CAMEL.to(CaseFormat.LOWER_CAMEL, modelNameUpperCamel));
            data.put("basePackage", BASE_PACKAGE);
            data.put("tableName", tableName);
            List<ResultType> tableName1 = getTableName(tableName);
            data.put("modeListDetails", tableName1);
            File file = new File(PROJECT_PATH + JAVA_PATH + PACKAGE_PATH_POJO + modelNameUpperCamel + ".java");
            if (!file.getParentFile().exists()) {
                file.getParentFile().mkdirs();
            }
            cfg.getTemplate("pojo.ftl").process(data, new FileWriter(file));
            System.out.println(modelNameUpperCamel + "POJO");
        } catch (Exception e) {
            throw new RuntimeException("POJO", e);
        }
    }

    private static void getMapper(String tableName, String modelName) {
        try {
            freemarker.template.Configuration cfg = getConfiguration();
            Map<String, Object> data = new HashMap<>();
            data.put("date", DATE);
            data.put("author", AUTHOR);
            String modelNameUpperCamel = StringUtils.isEmpty(modelName) ? tableNameConvertUpperCamel(tableName) : modelName;
            data.put("baseRequestMapping", modelNameConvertMappingPath(modelNameUpperCamel));
            data.put("modelNameUpperCamel", modelNameUpperCamel);
            data.put("modelNameLowerCamel", CaseFormat.UPPER_CAMEL.to(CaseFormat.LOWER_CAMEL, modelNameUpperCamel));
            data.put("basePackage", BASE_PACKAGE);
            data.put("tableName", tableName);
            List<ResultType> tableName1 = getTableName(tableName);
            data.put("modeListDetails", tableName1);
            File file = new File(PROJECT_PATH + JAVA_PATH + PACKAGE_PATH_MAPPER + modelNameUpperCamel + "Mapper.java");
            if (!file.getParentFile().exists()) {
                file.getParentFile().mkdirs();
            }
            cfg.getTemplate("mapper.ftl").process(data, new FileWriter(file));
            System.out.println(modelNameUpperCamel + "MAPPER");
        } catch (Exception e) {
            throw new RuntimeException("MAPPER", e);
        }
    }

    private static void getMapperResult(String tableName, String modelName) {
        try {
            freemarker.template.Configuration cfg = getConfiguration();
            Map<String, Object> data = new HashMap<>();
            data.put("date", DATE);
            data.put("author", AUTHOR);
            String modelNameUpperCamel = StringUtils.isEmpty(modelName) ? tableNameConvertUpperCamel(tableName) : modelName;
            data.put("baseRequestMapping", modelNameConvertMappingPath(modelNameUpperCamel));
            data.put("modelNameUpperCamel", modelNameUpperCamel);
            data.put("modelNameLowerCamel", CaseFormat.UPPER_CAMEL.to(CaseFormat.LOWER_CAMEL, modelNameUpperCamel));
            data.put("basePackage", BASE_PACKAGE);
            data.put("tableName", tableName);
            List<ResultType> tableName1 = getTableName(tableName);
            data.put("modeListDetails", tableName1);
            File file = new File(PROJECT_PATH + JAVA_PATH + PACKAGE_PATH_MAPPER + modelNameUpperCamel + ".java");
            if (!file.getParentFile().exists()) {
                file.getParentFile().mkdirs();
            }
            cfg.getTemplate("mapperResult.ftl").process(data, new FileWriter(file));
            System.out.println(modelNameUpperCamel + "MAPPER");
        } catch (Exception e) {
            throw new RuntimeException("MAPPER", e);
        }
    }


    private static void genLayUiList(String tableName, String modelName) {
        try {
            freemarker.template.Configuration cfg = getConfiguration();
            Map<String, Object> data = new HashMap<>();
            data.put("date", DATE);
            data.put("author", AUTHOR);
            String modelNameUpperCamel = StringUtils.isEmpty(modelName) ? tableNameConvertUpperCamel(tableName) : modelName;
            String modelNameLowerCamel = CaseFormat.UPPER_CAMEL.to(CaseFormat.LOWER_CAMEL, modelNameUpperCamel);//首字母小写
            data.put("baseRequestMapping", modelNameConvertMappingPath(modelNameUpperCamel));
            data.put("modelNameUpperCamel", modelNameUpperCamel);
            data.put("modelNameLowerCamel", CaseFormat.UPPER_CAMEL.to(CaseFormat.LOWER_CAMEL, modelNameUpperCamel));
            data.put("basePackage", BASE_PACKAGE);
            List<ResultType> tableName1 = getTableName(tableName);
            data.put("modeListDetails", tableName1);
            File file = new File(PROJECT_PATH + RESOURCES_PATH + PACKAGE_PATH_VIEW + "/" + modelNameLowerCamel + "/list.html");
            if (!file.getParentFile().exists()) {
                file.getParentFile().mkdirs();
            }
            cfg.getTemplate("layui-list.ftl").process(data, new FileWriter(file));

            System.out.println(modelNameUpperCamel + "/list.html生成成功");
        } catch (Exception e) {
            throw new RuntimeException("生成Controller失败", e);
        }
    }

    private static void genLayUiFrom(String tableName, String modelName) {
        try {
            freemarker.template.Configuration cfg = getConfiguration();
            Map<String, Object> data = new HashMap<>();
            data.put("date", DATE);
            data.put("author", AUTHOR);
            String modelNameUpperCamel = StringUtils.isEmpty(modelName) ? tableNameConvertUpperCamel(tableName) : modelName;
            String modelNameLowerCamel = CaseFormat.UPPER_CAMEL.to(CaseFormat.LOWER_CAMEL, modelNameUpperCamel);//首字母小写
            data.put("baseRequestMapping", modelNameConvertMappingPath(modelNameUpperCamel));
            data.put("modelNameUpperCamel", modelNameUpperCamel);
            data.put("modelNameLowerCamel", CaseFormat.UPPER_CAMEL.to(CaseFormat.LOWER_CAMEL, modelNameUpperCamel));
            data.put("basePackage", BASE_PACKAGE);
            List<ResultType> tableName1 = getTableName(tableName);
            data.put("modeListDetails", tableName1);
            File file = new File(PROJECT_PATH + RESOURCES_PATH + PACKAGE_PATH_VIEW + "/" + modelNameLowerCamel + "/form.html");
            if (!file.getParentFile().exists()) {
                file.getParentFile().mkdirs();
            }
            cfg.getTemplate("layui-form.ftl").process(data, new FileWriter(file));
            System.out.println(modelNameUpperCamel + "form.html 生成成功");
        } catch (Exception e) {
            throw new RuntimeException("生成失败", e);
        }
    }


    private static freemarker.template.Configuration getConfiguration() throws IOException {
        freemarker.template.Configuration cfg = new freemarker.template.Configuration(freemarker.template.Configuration.VERSION_2_3_23);
        cfg.setDirectoryForTemplateLoading(new File(TEMPLATE_FILE_PATH));
        cfg.setDefaultEncoding("UTF-8");
        cfg.setTemplateExceptionHandler(TemplateExceptionHandler.IGNORE_HANDLER);
        return cfg;
    }

    //获取文件上传的类型
    private static void genFile(String tableName, String modelName) {
        try {
            freemarker.template.Configuration cfg = getConfiguration();
            Map<String, Object> data = new HashMap<>();
            data.put("date", DATE);
            data.put("author", AUTHOR);
            String modelNameUpperCamel = StringUtils.isEmpty(modelName) ? tableNameConvertUpperCamel(tableName) : modelName;
            data.put("baseRequestMapping", modelNameConvertMappingPath(modelNameUpperCamel));
            data.put("modelNameUpperCamel", modelNameUpperCamel);
            data.put("modelNameLowerCamel", CaseFormat.UPPER_CAMEL.to(CaseFormat.LOWER_CAMEL, modelNameUpperCamel));
            data.put("basePackage", BASE_PACKAGE);
            File file = new File(PROJECT_PATH + JAVA_PATH + PACKAGE_PATH_UTIL + "FileUploadUtils.java");
            if (!file.getParentFile().exists()) {
                file.getParentFile().mkdirs();
            }
            cfg.getTemplate("fileupload.ftl").process(data, new FileWriter(file));

            System.out.println("FileUploadUtils.java 生成成功");
        } catch (Exception e) {
            throw new RuntimeException("生成FileUploadUtils.java失败", e);
        }
    }

    //LayUi的返回值类型
    private static void genLayUi(String tableName, String modelName) {
        try {
            freemarker.template.Configuration cfg = getConfiguration();
            Map<String, Object> data = new HashMap<>();
            data.put("date", DATE);
            data.put("author", AUTHOR);
            String modelNameUpperCamel = StringUtils.isEmpty(modelName) ? tableNameConvertUpperCamel(tableName) : modelName;
            data.put("baseRequestMapping", modelNameConvertMappingPath(modelNameUpperCamel));
            data.put("modelNameUpperCamel", modelNameUpperCamel);
            data.put("modelNameLowerCamel", CaseFormat.UPPER_CAMEL.to(CaseFormat.LOWER_CAMEL, modelNameUpperCamel));
            data.put("basePackage", BASE_PACKAGE);
            File file = new File(PROJECT_PATH + JAVA_PATH + PACKAGE_PATH_UTIL + "LayUiResult.java");
            if (!file.getParentFile().exists()) {
                file.getParentFile().mkdirs();
            }
            cfg.getTemplate("layui.ftl").process(data, new FileWriter(file));
            System.out.println("LayUiResult.java 生成成功");
        } catch (Exception e) {
            throw new RuntimeException("生成LayUiResult失败", e);
        }
    }
}
