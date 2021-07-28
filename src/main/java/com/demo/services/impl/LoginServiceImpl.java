package com.demo.services.impl;

import com.demo.database.data.TDemoUser;
import com.demo.database.mapper.ITDemoUserMapper;
import com.demo.services.ILoginService;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.SessionAttribute;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

/**
 * 登录及注销服务具体实现类
 * @Author weixianbo
 * @CreateTime 2021/7/22 11:23
 * @Version 1.0.0
 */
@Service
public class LoginServiceImpl implements ILoginService {

    //注入数据访问映射接口对象
    @Resource
    private ITDemoUserMapper iuserMapper;

    @Override
    public String login(Model model, String userName, String password) throws Exception {
        //访问数据映射接口，条件查询数据
        TDemoUser user = iuserMapper.queryByLogin(userName, password);
        //用户登录验证
        if(user != null) { //登录成功
            //封装数据到会话缓存中
            model.addAttribute("user", user);
            return "index";
        } else { //登录失败
            model.addAttribute("error", "用户名或密码错误!");
        }
        return "login";
    }

    @Override
    public String logout(Model model, HttpSession session,
                         SessionStatus sessionStatus) throws Exception {
        //使Session缓存失效
        session.invalidate();
        sessionStatus.setComplete();
        //重定向登录页面
        return "redirect:/";
    }
}
