package com.zhujinghui.novel.dao;

import com.zhujinghui.novel.pojo.Reader;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @Author: JinghuiZhu
 * @Description: 读者DAO
 * @Date: Created in 14:08 2019/2/26
 * @Modified By:
 */

public interface ReaderDAO extends JpaRepository<Reader,Integer> {
}
