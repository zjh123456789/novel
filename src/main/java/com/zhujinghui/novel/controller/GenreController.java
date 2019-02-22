package com.zhujinghui.novel.controller;


import com.zhujinghui.novel.pojo.Genre;
import com.zhujinghui.novel.service.GenreService;
import com.zhujinghui.novel.util.ImageUtil;
import com.zhujinghui.novel.util.Page4Navigator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.imageio.ImageIO;
import javax.servlet.http.HttpServletRequest;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
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

    /**
     * 返回小说类别分页数据
     *
     * @param start 页码
     * @param size 每页记录数
     * @return 小说分页数据
     */
    @GetMapping("/genres")
    public Page4Navigator<Genre> list(@RequestParam(value = "start", defaultValue = "0") int start,
                                      @RequestParam(value = "size", defaultValue = "3") int size){
        start = start<0?0:start;
        Page4Navigator<Genre> page4Navigator = genreService.list(start,size,5);
        return page4Navigator;
    }

    /**
     * 添加小说类别
     *
     * @param genre 单个小说类别
     * @param image 类别图片
     * @param request 请求
     * @return genre 小说类别
     * @throws IOException 写入文件异常
     */
    @PostMapping("/genres")
    public Object add(Genre genre, MultipartFile image, HttpServletRequest request) throws IOException {
        genreService.add(genre);
        saveOrUpdateImageFile(genre,image,request);
        return genre;
    }

    /**
     * 根据id 删除小说类别
     *
     * @param id 小说类别id
     * @param request 请求
     * @return null
     */
    @DeleteMapping("/genres/{id}")
    public String delete(@PathVariable("id") int id, HttpServletRequest request){
        genreService.delete(id);
        File imageFolder = new File(request.getServletContext().getRealPath("img/genre"));
        File file = new File(imageFolder,id+".jpg");
        file.delete();
        return null;
    }

    /**
     * 根据id 查询小说类别
     *
     * @param id 类别主键
     * @return genre
     */
    @GetMapping("/genres/{id}")
    public Genre get(@PathVariable("id") int id){
        Genre genre = genreService.get(id);
        return genre;
    }

    @PutMapping("/genres/{id}")
    public Object update(Genre genre, MultipartFile image, HttpServletRequest request) throws IOException {
        String name = request.getParameter("name");
        genre.setName(name);
        genreService.update(genre);
        if (image != null){
            saveOrUpdateImageFile(genre, image, request);
        }
        return genre;
    }

    /**
     * 保存或更新图片
     *
     * @param genre 小说类别
     * @param image 图片
     * @param request 请求
     * @throws IOException 写入文件异常
     */
    public void saveOrUpdateImageFile(Genre genre, MultipartFile image, HttpServletRequest request) throws IOException {
        File imageFolder = new File(request.getServletContext().getRealPath("img/genre"));
        File file = new File(imageFolder,genre.getId()+".jpg");
        if (!file.getParentFile().exists()){
            file.getParentFile().mkdirs();
        }
        image.transferTo(file);
        BufferedImage img = ImageUtil.change2jpg(file);
        ImageIO.write(img,"jpg",file);
    }

    /**
     * 查询所有小说
     *
     * @return List<Genre> 所有小说
     */
    public List<Genre> list(){
        return genreService.list();
    }

}
