package com.demo.database.mapper;

import com.demo.database.data.TDemoUser;
import org.apache.ibatis.annotations.*;

import java.util.List;

/**
 * 用户表的数据访问映射接口
 * @Author weixianbo
 * @CreateTime 2021/7/22 15:27
 * @Version 1.0.0
 */
public interface ITDemoUserMapper {

    /**
     * 查询所有用户数据或根据用户条件查询
     * @return
     */
    @Select("<script>"
            + "select * from t_demo_user"
            +   "<where>"
            +     "<if test='userName!=null'>"
            +        "user_name like '%${userName}%'"
            +     "</if>"
            +   "</where>"
            + "</script>")
    public List<TDemoUser> queryAll(String userName) throws Exception;

    /**
     * 条件查询，登录
     * @param userName
     * @param password
     * @return
     * @throws Exception
     */
    @Select("select * from t_demo_user where user_name=#{userName} " +
            "and user_password=#{password}")
    public TDemoUser queryByLogin(@Param("userName") String userName,
            @Param("password") String password) throws Exception;

    /**
     * 条件查询，根据ID查找用户
     * @param id
     * @return
     * @throws Exception
     */
    @Select("select * from t_demo_user where user_id=#{id}")
    public TDemoUser queryById(Integer id) throws Exception;

    /**
     * 添加用户
     * @param user
     * @throws Exception
     */
    @Insert("insert into t_demo_user(user_name,user_password,user_gender,user_birthday)"
            + " values(#{userName},#{userPassword},#{userGender},#{userBirthday})")
    public void add(TDemoUser user) throws Exception;

    /**
     * 修改用户
     * @param user
     * @throws Exception
     */
    @Update("update t_demo_user set user_name=#{userName},user_password=#{userPassword},"
           + "user_gender=#{userGender},user_birthday=#{userBirthday} where user_id=#{userId}")
    public void update(TDemoUser user) throws Exception;

    /**
     * 删除用户
     * @param ids
     * @throws Exception
     */
    @Delete("delete from t_demo_user where user_id in(${ids})")
    public void delete(String ids) throws Exception;

}
