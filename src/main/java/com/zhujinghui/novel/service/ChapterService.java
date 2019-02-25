package com.zhujinghui.novel.service;

import com.zhujinghui.novel.dao.ChapterDAO;
import com.zhujinghui.novel.dao.NovelDAO;
import com.zhujinghui.novel.pojo.Chapter;
import com.zhujinghui.novel.pojo.Novel;
import com.zhujinghui.novel.util.Page4Navigator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

/**
 * @Author: JinghuiZhu
 * @Description: 小说章节Service
 * @Date: Created in 16:44 2019/2/25
 * @Modified By:
 */

@Service
public class ChapterService {
    @Autowired
    ChapterDAO chapterDAO;

    @Autowired
    NovelDAO novelDAO;

    /**
     * 分页查询章节
     * @param novelId 小说id
     * @param start 页码
     * @param size 每页记录数
     * @param navigatePages 显示的分页链接
     * @return 章节分页封装类
     */
    public Page4Navigator<Chapter> list(int novelId, int start, int size, int navigatePages){
        Novel novel = novelDAO.getOne(novelId);
        Sort sort = new Sort(Sort.Direction.DESC, "id");
        Pageable pageable = PageRequest.of(start, size, sort);
        Page<Chapter> page = chapterDAO.findByNovel(novel, pageable);
        return new Page4Navigator<>(page,navigatePages);
    }

    /**
     * 添加章节
     *
     * @param chapter 章节
     */
    public void add(Chapter chapter){
        chapterDAO.save(chapter);
    }

    /**
     * 根据id 删除章节
     * @param id 章节id
     */
    public void delete(int id){
        chapterDAO.deleteById(id);
    }

    /**
     * 根据id 查询章节
     * @param id 章节id
     * @return
     */
    public Chapter get(int id){
        Chapter chapter = chapterDAO.findById(id).get();
        return chapter;
    }

    /**
     * 更新章节
     *
     * @param chapter 章节
     */
    public void update(Chapter chapter){
        chapterDAO.save(chapter);
    }

}
