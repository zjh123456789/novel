package com.zhujinghui.novel.controller;

import com.zhujinghui.novel.pojo.Novel;
import com.zhujinghui.novel.service.GenreService;
import com.zhujinghui.novel.service.NovelService;
import com.zhujinghui.novel.util.Page4Navigator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Date;

/**
 * @Author: JinghuiZhu
 * @Description: 小说控制器
 * @Date: Created in 17:44 2019/2/22
 * @Modified By:
 */

@RestController
public class NovelController {

    @Autowired
    NovelService novelService;

    @Autowired
    GenreService genreService;

    /**
     * 查询分页小说数据
     *
     * @param genreId 小说类别id
     * @param start 页码
     * @param size 每页记录数
     * @return 分页小说数据
     */
    @GetMapping("/genres/{genreId}/novels")
    public Page4Navigator<Novel> list(@PathVariable("genreId") int genreId, @RequestParam(value = "start", defaultValue = "0") int start,
                                      @RequestParam(value = "size", defaultValue = "5") int size){
        start = start<0?0:start;
        Page4Navigator<Novel> page4Navigator = novelService.list(genreId, start, size, 5);
        return page4Navigator;
    }

    /**
     * 根据id 查询小说
     *
     * @param id 小说主键id
     * @return novel
     */
    @GetMapping("/novels/{id}")
    public Novel get(@PathVariable("id") int id){
        Novel novel = novelService.get(id);
        return novel;
    }

    /**
     * 添加小说
     *
     * @param novel 小说
     * @return novel 添加属性后的小说
     */
    @PostMapping("/novels")
    public Object add(@RequestBody Novel novel){
        novel.setCreateTime(new Date());
        novel.setUpdateTime(new Date());
        novelService.add(novel);
        return novel;
    }

    /**
     * 删除小说
     *
     * @param id 小说主键id
     * @return null
     */
    @DeleteMapping("/novels/{id}")
    public String delete(@PathVariable("id") int id){
        novelService.delete(id);
        return null;
    }

    /**
     * 更新小说信息
     *
     * @param novel
     * @return novel
     */
    @PutMapping("/novels")
    public Object update(@RequestBody Novel novel){
        novelService.update(novel);
        return novel;
    }


}
