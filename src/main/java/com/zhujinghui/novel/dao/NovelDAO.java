package com.zhujinghui.novel.dao;

import com.zhujinghui.novel.pojo.Genre;
import com.zhujinghui.novel.pojo.Novel;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @Author: JinghuiZhu
 * @Description: 小说DAO
 * @Date: Created in 17:28 2019/2/22
 * @Modified By:
 */

public interface NovelDAO extends JpaRepository<Novel,Integer> {
    Page<Novel> findByGenre(Genre genre, Pageable pageable);
}
