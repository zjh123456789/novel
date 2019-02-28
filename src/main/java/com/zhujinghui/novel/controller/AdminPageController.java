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
     * 后台首页
     */
    @GetMapping("/index")
    public String index(){
        return "admin/index";
    }

    /**
     * 后台首页
     */
    @GetMapping("/layui")
    public String layui(){
        return "index";
    }

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
        return "admin/genreList";
    }

    /**
     * 跳转到小说类别编辑页面
     */
    @GetMapping(value = "/admin_genre_edit")
    public String editGenre(){
        return "admin/genreEdit";
    }

    /**
     * 跳转到小说页面
     */
    @GetMapping(value = "/admin_novel_list")
    public String listNovel(){
        return "admin/novelList";
    }

    /**
     * 跳转到小说编辑页面
     */
    @GetMapping(value = "admin_novel_edit")
    public String editNovel(){
        return "admin/novelEdit";
    }

    /**
     * 跳转到章节页面
     */
    @GetMapping(value = "admin_chapter_list")
    public String listChapter(){
        return "admin/chapterList";
    }

    /**
     * 跳转到章节编辑页面
     */
    @GetMapping(value = "admin_chapter_edit")
    public String editChapter(){
        return "admin/chapterEdit";
    }

    /**
     * 跳转到读者管理页面
     */
    @GetMapping(value = "admin_reader_list")
    public String listReader(){
        return "admin/readerList";
    }

    /**
     * 跳转到读者编辑界面
     */
    @GetMapping(value = "admin_reader_edit")
    public String editReader(){
        return "admin/readerEdit";
    }

    /**
     * 跳转到管理员信息页面
     */
    @GetMapping(value = "admin_admin_list")
    public String listAdmin(){
        return "admin/adminList";
    }

    /**
     * 跳转到管理员编辑界面
     */
    @GetMapping(value = "admin_admin_edit")
    public String editAdmin(){
        return "admin/adminEdit";
    }

}
