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

    /**
     * 重定向到 admin_genre_list
     */
    @GetMapping(value = "/admin")
    public String admin(){
        return "redirect:admin_genre_list";
    }

    /**
     * 跳转到小说类别页面
     */
    @GetMapping(value = "/admin_genre_list")
    public String listGenre(){
        return "admin/listGenre";
    }

    /**
     * 跳转到小说类别编辑页面
     */
    @GetMapping(value = "/admin_genre_edit")
    public String editGenre(){
        return "admin/editGenre";
    }
}
