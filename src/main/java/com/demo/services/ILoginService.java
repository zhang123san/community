package com.demo.services;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.SessionAttribute;
import org.springframework.web.bind.support.SessionStatus;

import javax.servlet.http.HttpSession;

/**
 * 登录及注销的服务接口
 * @Author weixianbo
 * @CreateTime 2021/7/22 11:16
 * @Version 1.0.0
 */
public interface ILoginService {

    /**
     * 登录
     * @param model
     * @return
     * @throws Exception
     */
    public String login(Model model, String userName, String password) throws Exception;

    /**
     * 注销
     * @param model
     * @param session
     * @param sessionStatus
     * @return
     * @throws Exception
     */
    public String logout(Model model, HttpSession session,
                         SessionStatus sessionStatus) throws Exception;

}
