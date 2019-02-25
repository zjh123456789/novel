package com.zhujinghui.novel.controller;

import com.zhujinghui.novel.pojo.Chapter;
import com.zhujinghui.novel.service.ChapterService;
import com.zhujinghui.novel.service.NovelService;
import com.zhujinghui.novel.util.Page4Navigator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Date;

/**
 * @Author: JinghuiZhu
 * @Description: 小说章节控制器
 * @Date: Created in 16:36 2019/2/25
 * @Modified By:
 */

@RestController
public class ChapterController {
    @Autowired
    ChapterService chapterService;

    @Autowired
    NovelService novelService;

    @GetMapping("/novels/{novelId}/chapters")
    public Page4Navigator<Chapter> list(@PathVariable("novelId") int novelId, @RequestParam(value = "start", defaultValue = "0") int start,
                                        @RequestParam(value = "size", defaultValue = "5") int size){
        start = start<0?0:start;
        Page4Navigator<Chapter> page4Navigator = chapterService.list(novelId, start, size, 5);
        return page4Navigator;
    }

    @GetMapping("/chapters/{id}")
    public Chapter get(@PathVariable("id") int id){
        Chapter chapter = chapterService.get(id);
        return chapter;
    }

    @PostMapping("/chapters")
    public Chapter get(@RequestBody Chapter chapter){
        chapter.setCreateTime(new Date());
        chapter.setUpdateTime(new Date());
        chapterService.add(chapter);
        return chapter;
    }

    @DeleteMapping("/chapters/{id}")
    public String delete(@PathVariable("id") int id){
        chapterService.delete(id);
        return null;
    }

    @PutMapping("/chapters")
    public Object update(@RequestBody Chapter chapter){
        chapterService.update(chapter);
        return chapter;
    }

}
