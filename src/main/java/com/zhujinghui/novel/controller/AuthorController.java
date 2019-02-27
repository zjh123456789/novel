package com.zhujinghui.novel.controller;

import com.zhujinghui.novel.service.AuthorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Description:    作者控制器
 * @Author:        jinghui.zhu
 * @CreateDate:     2019/2/27 22:54
 * @Version:        1.0
 */

@RestController
public class AuthorController {

    @Autowired
    AuthorService authorService;
}
