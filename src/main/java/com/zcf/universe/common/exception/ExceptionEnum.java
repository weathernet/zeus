package com.zcf.universe.common.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

/**
 * 全局异常的枚举
 *
 * @author yuan
 * @date 2018/11/6 0006
 */
@Getter
@NoArgsConstructor
@AllArgsConstructor
public enum ExceptionEnum {
    PHONE_STORY_BE_NULL(404,"没有查到该故事"),
    PHONE_NUMBER_BE_NULL(400,"手机号不能为空"),
    PHONE_NUMBER_BE_REPEAT(404,"手机号已存在"),
    HOUSE_LISTING_BE_REPEAT(404,"没有查到该房源"),
    HOUSE_LABEL_BE_REPEAT(404,"没有查到该房源"),
    HOME_PAGE_GROUPS_BE_NULL(404,"没有找到首页分组"),
    HONE_BANNER_BE_NULL(404,"没有找到轮播图");
    private int code;
    private String msg;
}
