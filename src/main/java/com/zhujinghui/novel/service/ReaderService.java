package com.zhujinghui.novel.service;

import com.zhujinghui.novel.dao.ReaderDAO;
import com.zhujinghui.novel.pojo.Reader;
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
 * @Description: 读者Service
 * @Date: Created in 14:09 2019/2/26
 * @Modified By:
 */

@Service
public class ReaderService {

    @Autowired
    ReaderDAO readerDAO;

    /**
     * 分页查询读者信息
     *
     * @param start 页码
     * @param size 每页记录数
     * @param navigatePages 显示的分页超链
     * @return Page4Navigator<Reader> 读者分页封装类
     */
    public Page4Navigator<Reader> list(int start, int size, int navigatePages){
        Sort sort = new Sort(Sort.Direction.DESC,"id");
        Pageable pageable = PageRequest.of(start,size,sort);
        Page page = readerDAO.findAll(pageable);
        return new Page4Navigator<>(page,navigatePages);
    }

    /**
     * 查询所有读者信息
     *
     * @param
     * @return List<Reader>
     */
    public List<Reader> list(){
        Sort sort = new Sort(Sort.Direction.DESC,"id");
        return readerDAO.findAll(sort);
    }

    /**
     * 读者注册
     *
     * @param reader 读者
     * @return void
     */
    public void add(Reader reader){
        readerDAO.save(reader);
    }

    /**
     * 读者注销账号
     *
     * @param id 读者主键
     * @return void
     */
    public void delete(int id){
        readerDAO.deleteById(id);
    }

    /**
     * 根据id 查询读者
     * @param id 读者主键
     * @return genre 查询读者信息
     */
    public Reader get(int id){
        Reader reader = readerDAO.findById(id).get();
        return reader;
    }

    /**
     * 更新读者信息
     * @param reader 读者
     */
    public void update(Reader reader){
        readerDAO.save(reader);
    }
}
