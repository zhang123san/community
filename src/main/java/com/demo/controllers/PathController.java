package com.demo.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * 请求路径处理的控制器
 * @Author weixianbo
 * @CreateTime 2021/7/22 9:54
 * @Version 1.0.0
 */
@Controller
public class PathController {

    @GetMapping("/")
    public String index() {
        return "login";
    }//省略了.html (默认)

    @GetMapping("/index")
    public String toIndex() {
        return "index";
    }

}
