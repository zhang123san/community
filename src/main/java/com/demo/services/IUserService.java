package com.demo.services;

import com.demo.database.data.TDemoUser;
import org.springframework.ui.Model;

/**
 * 用户管理的服务接口
 * @Author weixianbo
 * @CreateTime 2021/7/23 9:43
 * @Version 1.0.0
 */
public interface IUserService {

    /**
     * 查询用户数据
     * @param model
     * @param userName
     * @return
     * @throws Exception
     */
    public String query(Model model, String userName) throws Exception;

    /**
     * 展示添加视图
     * @param model
     * @return
     * @throws Exception
     */
    public String addView(Model model) throws Exception;

    /**
     * 展示修改视图
     * @param model
     * @param id
     * @return
     * @throws Exception
     */
    public String updateView(Model model, Integer id) throws Exception;

    /**
     * 添加用户数据
     * @param model
     * @param user
     * @return
     * @throws Exception
     */
    public String add(Model model, TDemoUser user) throws Exception;

    /**
     * 修改用户数据
     * @param model
     * @param user
     * @return
     * @throws Exception
     */
    public String update(Model model, TDemoUser user) throws Exception;

    /**
     * 删除用户数据
     * @param model
     * @param ids
     * @return
     * @throws Exception
     */
    public String delete(Model model, String ids) throws Exception;

}
