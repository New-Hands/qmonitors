package com.lstfight.portal.mapper;

import com.lstfight.portal.auth.DataSource;
import com.lstfight.portal.model.User;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

/**
 * auth 用户登录数据repository
 *
 * @author lst
 */
@Mapper
@Repository
public interface UserMapper extends DataSource {

    /**
     * 查找
     * @param user 用户
     * @return 状态值
     */
    @Insert("insert into user value()")
    public int save(User user);

    /**
     * 查找
     * @return 状态值
     */
    @Select("select * from user ")
    public User findByNameAndId();

    /**
     * 查找
     * @param userName 用户名
     * @param passWord 密码
     * @return 状态值
     */
    @Select("select count(id) where username = #{userName} and pass_word = #{passWord}")
    int findByNameAndPassWord(String userName, String  passWord);
}
