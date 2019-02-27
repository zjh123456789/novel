package com.zhujinghui.novel.dao;

import com.zhujinghui.novel.pojo.Author;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @Description:    作者DAO
 * @Author:        jinghui.zhu
 * @CreateDate:     2019/2/27 22:41
 * @Version:        1.0
 */
public interface AuthorDAO extends JpaRepository<Author,Integer> {
}
