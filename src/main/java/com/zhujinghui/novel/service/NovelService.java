package com.zhujinghui.novel.service;

import com.zhujinghui.novel.dao.GenreDAO;
import com.zhujinghui.novel.dao.NovelDAO;
import com.zhujinghui.novel.pojo.Genre;
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
 * @Description: 小说Service
 * @Date: Created in 17:30 2019/2/22
 * @Modified By:
 */

@Service
public class NovelService {

    @Autowired
    NovelDAO novelDAO;

    @Autowired
    GenreDAO genreDAO;

    /**
     * 分页查询小说
     *
     * @param genreId 类别id
     * @param start 页码
     * @param size 每页记录数
     * @param navigatePages 显示的分页超链
     * @return 小说分页封装类
     */
    public Page4Navigator<Novel> list(int genreId, int start, int size, int navigatePages){
        Genre genre = genreDAO.getOne(genreId);
        Sort sort = new Sort(Sort.Direction.DESC, "id");
        Pageable pageable = PageRequest.of(start, size, sort);
        Page<Novel> page = novelDAO.findByGenre(genre, pageable);
        return new Page4Navigator<>(page,navigatePages);
    }

    /**
     * 添加小说
     *
     * @param novel 小说
     */
    public void add(Novel novel){
        novelDAO.save(novel);
    }

    /**
     * 根据id 删除小说
     *
     * @param id 小说主键id
     */
    public void delete(int id){
        novelDAO.deleteById(id);
    }

    /**
     * 根据id 查询小说
     *
     * @param id 小说主键id
     * @return novel 小说
     */
    public Novel get(int id){
        Novel novel = novelDAO.findById(id).get();
        return novel;
    }

    /**
     * 更新小说
     *
     * @param novel 小说
     */
    public void update(Novel novel){
        novelDAO.save(novel);
    }

}
