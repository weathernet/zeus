package com.zcf.universe.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Table;

@Setter
@Getter
@Table(name = "user")
public class User {
    @Id
    private Integer id;
    @Column(name = "user_name")
    private String userName;
    private String password;
    @Column(name = "nick_name")
    private String nickName;
}
