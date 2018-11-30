package com.zcf.universe.pojo;

import lombok.Data;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotBlank;

/**
 * @author yuan
 * @date 2018/11/29 0029
 */
@Data
public class Test {
    @NotBlank(message = "code不能为空")
    private String name;
    @Length(max = 10, message = "name长度不能超过10")
    private String age;
}
