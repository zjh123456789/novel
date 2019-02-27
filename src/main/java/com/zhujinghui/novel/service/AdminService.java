package com.zhujinghui.novel.service;

import com.zhujinghui.novel.dao.AdminDAO;
import com.zhujinghui.novel.pojo.Admin;
import com.zhujinghui.novel.util.Page4Navigator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Description:    管理员Service
 * @Author:        jinghui.zhu
 * @CreateDate:     2019/2/27 22:42
 * @Version:        1.0
 */

@Service
public class AdminService {

    @Autowired
    AdminDAO adminDAO;

    /**
     * 分页查询管理员信息
     *
     * @param start 页码
     * @param size 每页记录数
     * @param navigatePages 显示的分页超链
     * @return Page4Navigator<Admin> 管理员分页封装类
     */
    public Page4Navigator<Admin> list(int start, int size, int navigatePages){
        Sort sort = new Sort(Sort.Direction.DESC,"id");
        Pageable pageable = PageRequest.of(start,size,sort);
        Page page = adminDAO.findAll(pageable);
        return new Page4Navigator<>(page,navigatePages);
    }

    /**
     * 查询所有管理员信息
     *
     * @param
     * @return List<Admin>
     */
    public List<Admin> list(){
        Sort sort = new Sort(Sort.Direction.DESC,"id");
        return adminDAO.findAll(sort);
    }

    /**
     * 添加管理员
     *
     * @param admin 管理员
     * @return void
     */
    public void add(Admin admin){
        adminDAO.save(admin);
    }

    /**
     * 删除管理员
     *
     * @param id 管理员主键
     * @return void
     */
    public void delete(int id){
        adminDAO.deleteById(id);
    }

    /**
     * 根据id 查询管理员
     *
     * @param id 管理员主键
     * @return admin 管理员信息
     */
    public Admin get(int id){
        Admin admin = adminDAO.findById(id).get();
        return admin;
    }

    /**
     * 更新管理员信息
     *
     * @param admin 管理员
     */
    public void update(Admin admin){
        adminDAO.save(admin);
    }
}
