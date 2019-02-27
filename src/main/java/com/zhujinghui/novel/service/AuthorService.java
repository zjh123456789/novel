package com.zhujinghui.novel.service;

import com.zhujinghui.novel.dao.AuthorDAO;
import com.zhujinghui.novel.pojo.Author;
import com.zhujinghui.novel.util.Page4Navigator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Description:    作者Service
 * @Author:        jinghui.zhu
 * @CreateDate:     2019/2/27 22:43
 * @Version:        1.0
 */
@Service
public class AuthorService {

    @Autowired
    AuthorDAO authorDAO;

    /**
     * 分页查询读者信息
     *
     * @param start 页码
     * @param size 每页记录数
     * @param navigatePages 显示的分页超链
     * @return Page4Navigator<Author> 作者分页封装类
     */
    public Page4Navigator<Author> list(int start, int size, int navigatePages){
        Sort sort = new Sort(Sort.Direction.DESC,"id");
        Pageable pageable = PageRequest.of(start,size,sort);
        Page page = authorDAO.findAll(pageable);
        return new Page4Navigator<>(page,navigatePages);
    }

    /**
     * 查询所有作者信息
     *
     * @param
     * @return List<Author>
     */
    public List<Author> list(){
        Sort sort = new Sort(Sort.Direction.DESC,"id");
        return authorDAO.findAll(sort);
    }

    /**
     * 作者注册
     *
     * @param author 作者
     * @return void
     */
    public void add(Author author){
        authorDAO.save(author);
    }

    /**
     * 作者注销账号
     *
     * @param id 作者主键
     * @return void
     */
    public void delete(int id){
        authorDAO.deleteById(id);
    }

    /**
     * 根据id 查询作者
     *
     * @param id 作者主键
     * @return genre 作者信息
     */
    public Author get(int id){
        Author author = authorDAO.findById(id).get();
        return author;
    }

    /**
     * 更新作者信息
     *
     * @param author 作者
     */
    public void update(Author author){
        authorDAO.save(author);
    }
}
