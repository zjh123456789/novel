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

    public Page4Navigator<Genre> list(int start, int size, int navigatePages){
        Sort sort = new Sort(Sort.Direction.DESC,"id");
        Pageable pageable = PageRequest.of(start,size,sort);
        Page page = genreDAO.findAll(pageable);
        return new Page4Navigator<Genre>(page,navigatePages);
    }
    public List<Genre> list(){
        Sort sort = new Sort(Sort.Direction.DESC,"id");
        return genreDAO.findAll(sort);
    }
}
