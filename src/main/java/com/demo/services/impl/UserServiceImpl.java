package com.demo.services.impl;

import com.demo.database.data.TDemoUser;
import com.demo.database.mapper.ITDemoUserMapper;
import com.demo.services.IUserService;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import javax.annotation.Resource;
import java.util.List;

/**
 * 用户管理的服务接口具体实现类
 * @Author weixianbo
 * @CreateTime 2021/7/23 10:09
 * @Version 1.0.0
 */
@Service
public class UserServiceImpl implements IUserService {

    //注入数据访问映射接口
    @Resource
    private ITDemoUserMapper iuserMapper;

    @Override
    public String query(Model model, String userName) throws Exception {
        //调用数据访问接口的查询方法
        List<TDemoUser> list = iuserMapper.queryAll(userName);
        //封装数据到模型中
        model.addAttribute("list", list);
        return "admin/user/userlist";
    }

    @Override
    public String addView(Model model) throws Exception {
        return "admin/user/useraddview";
    }

    @Override
    public String updateView(Model model, Integer id) throws Exception {
        //条件查询用户数据
        TDemoUser user = iuserMapper.queryById(id);
        model.addAttribute("user", user);
        return "admin/user/userupdateview";
    }

    @Override
    public String add(Model model, TDemoUser user) throws Exception {
        //调用数据接口的添加方法
        iuserMapper.add(user);
        //查询用户数据更新用户列表
        return query(model, null);
    }

    @Override
    public String update(Model model, TDemoUser user) throws Exception {
        iuserMapper.update(user);
        return query(model, null);
    }

    @Override
    public String delete(Model model, String ids) throws Exception {
        iuserMapper.delete(ids);
        return query(model, null);
    }
}
