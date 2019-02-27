package com.zhujinghui.novel.dao;

import com.zhujinghui.novel.pojo.Admin;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @Description:    管理员DAO
 * @Author:        jinghui.zhu
 * @CreateDate:     2019/2/27 22:40
 * @Version:        1.0
 */
public interface AdminDAO extends JpaRepository<Admin,Integer> {
}
