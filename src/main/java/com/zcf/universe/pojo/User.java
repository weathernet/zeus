package com.zcf.universe.pojo;

import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

@Data
@Table(name = "user")
@Component
public class User extends HostPrefix {
    @Id
    private Integer id;
    @Column(name = "user_name")
    private String userName;
    private String password;
    @Column(name = "nick_name")
    private String nickName;

    public String getUserName() {
        return HOST_PORT + userName;
    }


}
