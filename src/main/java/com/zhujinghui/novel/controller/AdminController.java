package com.zhujinghui.novel.controller;

import com.zhujinghui.novel.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Description:    管理员控制器
 * @Author:        jinghui.zhu
 * @CreateDate:     2019/2/27 22:53
 * @Version:        1.0
 */

@RestController
public class AdminController {

    @Autowired
    AdminService adminService;

}
