package com.zhujinghui.novel.controller;

import com.zhujinghui.novel.pojo.Genre;
import com.zhujinghui.novel.service.GenreService;
import com.zhujinghui.novel.util.Page4Navigator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @Author: JinghuiZhu
 * @Description: 小说类别控制器
 * @Date: Created in 15:49 2019/2/21
 * @Modified By:
 */

@RestController
public class GenreController {

    @Autowired
    GenreService genreService;

    @GetMapping("/genres")
    public Page4Navigator<Genre> list(@RequestParam(value = "start", defaultValue = "0") int start, @RequestParam(value = "size", defaultValue = "3") int size){
        start = start<0?0:start;
        Page4Navigator<Genre> page4Navigator = genreService.list(start,size,5);
        return page4Navigator;
    }

    public List<Genre> list(){
        return genreService.list();
    }

}
