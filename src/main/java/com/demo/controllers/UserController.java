package com.demo.controllers;

import com.demo.database.data.TDemoUser;
import com.demo.services.IUserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.annotation.Resource;

/**
 * 用户管理的控制器
 * @Author weixianbo
 * @CreateTime 2021/7/23 11:01
 * @Version 1.0.0
 */
@Controller
public class UserController {

    //注入服务接口对象
    @Resource
    private IUserService iuserService;

    /**
     * 查询用户数据
     * @param model
     * @param suserName
     * @return
     */
    @RequestMapping("/user/query")
    public String query(Model model, String suserName) {
        try {
            String nextPath = iuserService.query(model, suserName);
            return nextPath;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "error";
    }

    /**
     * 展示添加用户视图
     * @param model
     * @return
     */
    @RequestMapping("/user/addview")
    public String addViw(Model model) {
        try {
            String nextPath = iuserService.addView(model);
            return nextPath;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "error";
    }

    /**
     * 展示修改用户视图
     * @param model
     * @param id
     * @return
     */
    @RequestMapping(path = "/user/updateview/{id}", method = RequestMethod.GET)
    public String updateView(Model model, @PathVariable("id") Integer id) {
        try {
            String nextPath = iuserService.updateView(model, id);
            return nextPath;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "error";
    }

    /**
     * 添加用户
     * @param model
     * @param user
     * @return
     */
    @RequestMapping(value = "/user/add")
    public String add(Model model, TDemoUser user) {
        try {
            String nextPath = iuserService.add(model, user);
            return nextPath;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "error";
    }

    /**
     * 修改用户
     * @param model
     * @param user
     * @return
     */
    @RequestMapping("/user/update/{id}")
    public String update(Model model, TDemoUser user, @PathVariable("id") Integer id) {
        try {
            user.setUserId(id);
            String nextPath = iuserService.update(model, user);
            return nextPath;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "error";
    }

    /**
     * 删除用户
     * @param model
     * @param ids
     * @return
     */
    @RequestMapping("/user/delete")
    public String delete(Model model, @RequestParam("id") String ids) {
        try {
            String nextPath = iuserService.delete(model, ids);
            return nextPath;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "error";
    }

}
