package com.zhujinghui.novel.service;

import com.zhujinghui.novel.dao.GenreDAO;
import com.zhujinghui.novel.pojo.Genre;
import com.zhujinghui.novel.util.Page4Navigator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Author: JinghuiZhu
 * @Description: 小说类别Service
 * @Date: Created in 15:43 2019/2/21
 * @Modified By:
 */

@Service
public class GenreService {

    @Autowired
    GenreDAO genreDAO;

    /**
     * 分页查询小说
     *
     * @param start 页码
     * @param size 每页记录数
     * @param navigatePages 显示的分页超链
     * @return Page4Navigator<Genre> 类别分页封装类
     */
    public Page4Navigator<Genre> list(int start, int size, int navigatePages){
        Sort sort = new Sort(Sort.Direction.DESC,"id");
        Pageable pageable = PageRequest.of(start,size,sort);
        Page page = genreDAO.findAll(pageable);
        return new Page4Navigator<Genre>(page,navigatePages);
    }

    /**
     * 查询所有小说类别
     *
     * @param
     * @return List<Genre>
     */
    public List<Genre> list(){
        Sort sort = new Sort(Sort.Direction.DESC,"id");
        return genreDAO.findAll(sort);
    }

    /**
     * 添加小说类别
     *
     * @param genre 小说类别
     * @return void
     */
    public void add(Genre genre){
        genreDAO.save(genre);
    }

    /**
     * 删除小说类别
     *
     * @param id 小说类别主键
     * @return void
     */
    public void delete(int id){
        genreDAO.deleteById(id);
    }

    /**
     * 根据id 查询小说类别
     * @param id 小说类别主键
     * @return genre 查询的小说类别
     */
    public Genre get(int id){
        Genre genre = genreDAO.findById(id).get();
        return genre;
    }

    /**
     * 更新小说类别
     * @param genre 小说类别
     */
    public void update(Genre genre){
        genreDAO.save(genre);
    }
}
