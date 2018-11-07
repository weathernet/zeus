package com.zcf.universe.common.exception;

import lombok.Data;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author yuan
 * @date 2018/11/6 0006
 */
@Data
public class ExceptionResult {
    private int status;
    private String message;
    private String timestamp;

    public ExceptionResult(ExceptionEnum em) {
        this.status = em.getCode();
        this.message = em.getMsg();
        this.timestamp = getTime();
    }


    public static String getTime() {
        Date date = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//目标格式
        String dateString = sdf.format(date);
        return dateString;
    }

}
