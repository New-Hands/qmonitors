package com.lstfight.portal.web;


import com.lstfight.portal.mapper.UserMapper;
import com.lstfight.portal.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author lst
 */
@RestController
public class Login {

    private final UserMapper userMapper;

    /**
     * 使用构造方法的方式进行注入（注入的方式还需要研究啊）
     */
    @Autowired
    public Login(UserMapper userMapper) {
        this.userMapper = userMapper;
    }

    @RequestMapping("/login")
    public String login() {
        User byNameAndId = userMapper.findByNameAndId();
        System.out.println(byNameAndId+"are"+"efads");
        System.out.println("dfadfadssdfdsf");
        return "hedfdfdsfasdfdafffffffffffffffdddhhhdfdjjjfdsfasdhhhhhdsaf";
    }
}
