package com.zhujinghui.novel.controller;

import com.zhujinghui.novel.pojo.Reader;
import com.zhujinghui.novel.service.ReaderService;
import com.zhujinghui.novel.util.Page4Navigator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @Author: JinghuiZhu
 * @Description: 读者控制器
 * @Date: Created in 14:23 2019/2/26
 * @Modified By:
 */

@RestController
public class ReaderController {

    @Autowired
    ReaderService readerService;

    @GetMapping("/readers")
    public Page4Navigator<Reader> list(@RequestParam(value = "start", defaultValue = "0") int start,
                                       @RequestParam(value = "size", defaultValue = "5") int size){
        start = start<0?0:start;
        Page4Navigator<Reader> page4Navigator = readerService.list(start,size,5);
        return page4Navigator;
    }

    @PostMapping("/readers")
    public Object add(Reader reader){
        readerService.add(reader);
        return reader;
    }

    @DeleteMapping("/readers/{id}")
    public String delete(@PathVariable("id") int id){
        readerService.delete(id);
        return null;
    }

    @GetMapping("/readers/{id}")
    public Reader get(@PathVariable("id") int id){
        Reader reader = readerService.get(id);
        return reader;
    }

    @PutMapping("/readers/{id}")
    public Object update(Reader reader){
        readerService.update(reader);
        return reader;
    }
}
