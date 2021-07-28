package com.demo.controllers;

import com.demo.services.ILoginService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

/**
 * 登录及注销控制器
 * @Author weixianbo
 * @CreateTime 2021/7/22 11:37
 * @Version 1.0.0
 */
@Controller
@SessionAttributes({"user"})
public class LoginController {

    //注入登录及注销服务接口对象
    @Resource
    private ILoginService iloginService;

    /**
     * 登录
     * @param model
     * @param userName
     * @param password
     * @return
     */
    @PostMapping("/login")
    public String login(Model model, String userName, String password) {
        try {
            //访问登录服务接口
            String nextPath = iloginService.login(model, userName, password);
            //返回下一个视图的路径
            return nextPath;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "error";
    }

    /**
     * 注销
     * @param model
     * @param session
     * @param sessionStatus
     * @return
     */
    @GetMapping("/logout")
    public String logout(Model model, HttpSession session, SessionStatus sessionStatus) {
        try {
            String nextPath = iloginService.logout(model, session, sessionStatus);
            return nextPath;
        } catch(Exception e) {
            e.printStackTrace();
        }
        return "error";
    }

}
