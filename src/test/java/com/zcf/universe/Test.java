package com.zcf.universe;

import ch.qos.logback.core.net.SyslogOutputStream;
import org.apache.commons.lang3.RandomStringUtils;
import org.apache.commons.lang3.RandomUtils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author yuan
 * @date 2018/11/1 0001
 */
public class Test {


    public static void main(String[] args) {
      String a = "advertising, banner, commodity, user, verifycode";
        List<String>  TableName= new ArrayList<>();
        String[] split = a.split(", ");
        for (int i = 0; i < split.length; i++) {
            String sss='"'+split[i]+'"';
            TableName.add(sss);
        }
        String s1 = TableName.toString();
        String s = s1.replaceAll(" ", "");
        System.out.println(s);

    }

}
