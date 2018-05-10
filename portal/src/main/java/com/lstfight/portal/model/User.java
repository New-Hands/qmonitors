package com.lstfight.portal.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * auth 用户model
 * lombok使代码更加的简洁
 * @author lst
 */
@AllArgsConstructor
@ToString
public class User {
    @Getter
    @Setter
    private Integer id;

    @Getter
    @Setter
    private String name;

    @Getter
    @Setter
    private String passWord;

    @Getter
    @Setter
    private String email;

    @Getter
    @Setter
    private String phone;

}
