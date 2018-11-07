package com.zcf.universe.common.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

/**
 * @author yuan
 * @date 2018/11/6 0006
 */
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class CommonException extends RuntimeException {
    private ExceptionEnum exceptionEnum;
}
