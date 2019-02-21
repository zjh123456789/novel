package com.zhujinghui.novel.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * @Author: JinghuiZhu
 * @Description: 后台页面跳转控制器
 * @Date: Created in 15:47 2019/2/21
 * @Modified By:
 */

@Controller
public class AdminPageController {

    @GetMapping(value = "/admin")
    public String admin(){
        return "redirect:admin_genre_list";
    }

    @GetMapping(value = "/admin_genre_list")
    public String listGenre(){
        return "admin/listGenre";
    }
}
