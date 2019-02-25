package com.zhujinghui.novel.dao;

import com.zhujinghui.novel.pojo.Chapter;
import com.zhujinghui.novel.pojo.Novel;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @Author: JinghuiZhu
 * @Description: 小说章节DAO
 * @Date: Created in 16:41 2019/2/25
 * @Modified By:
 */
public interface ChapterDAO extends JpaRepository<Chapter, Integer> {
    Page<Chapter> findByNovel(Novel novel, Pageable pageable);
}
