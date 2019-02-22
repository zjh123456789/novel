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

    /**
     * 跳转到小说页面
     */
    @GetMapping(value = "/admin_novel_list")
    public String listNovel(){
        return "admin/listNovel";
    }

    /**
     * 跳转到小说编辑页面
     */
    @GetMapping(value = "admin_novel_edit")
    public String editNovel(){
        return "admin/editNovel";
    }

    /**
     * 跳转到章节页面
     */
    @GetMapping(value = "admin_chapter_list")
    public String listChapter(){
        return "admin/listChapter";
    }

    /**
     * 跳转到章节编辑页面
     */
    @GetMapping(value = "admin_chapter_edit")
    public String editChapter(){
        return "admin/editChapter";
    }

    /**
     * 跳转到用户页面
     */
    @GetMapping(value = "admin_user_list")
    public String listUser(){
        return "admin/listUser";
    }

    /**
     * 跳转到用户编辑界面
     */
    @GetMapping(value = "admin_user_edit")
    public String editUser(){
        return "admin/editUser";
    }

}
