package com.zhujinghui.novel.dao;

import com.zhujinghui.novel.pojo.Genre;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @Author: JinghuiZhu
 * @Description: 小说类别DAO
 * @Date: Created in 15:42 2019/2/21
 * @Modified By:
 */

public interface GenreDAO extends JpaRepository<Genre,Integer> {
}
