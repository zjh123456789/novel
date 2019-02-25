package com.zhujinghui.novel.pojo;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.util.Date;

/**
 * @Author: JinghuiZhu
 * @Description: 章节POJO
 * @Date: Created in 15:47 2019/2/25
 * @Modified By:
 */

@Entity
@Table(name = "t_chapter")
@JsonIgnoreProperties(value={"hibernateLazyInitializer","handler","fieldHandler"})
public class Chapter {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "title")
    private String title;

    @ManyToOne
    @JoinColumn(name = "novel_id")
    private Novel novel;

    @Column(name = "contents")
    private String contents;

    @Column(name = "word_count")
    private int wordCount;

    @Column(name = "create_uid")
    private int createUid;

    @Column(name = "create_time")
    private Date createTime;

    @Column(name = "update_uid")
    private int updateUid;

    @Column(name = "update_time")
    private Date updateTime;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Novel getNovel() {
        return novel;
    }

    public void setNovel(Novel novel) {
        this.novel = novel;
    }

    public String getContents() {
        return contents;
    }

    public void setContents(String contents) {
        this.contents = contents;
    }

    public int getWordCount() {
        return wordCount;
    }

    public void setWordCount(int wordCount) {
        this.wordCount = wordCount;
    }

    public int getCreateUid() {
        return createUid;
    }

    public void setCreateUid(int createUid) {
        this.createUid = createUid;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public int getUpdateUid() {
        return updateUid;
    }

    public void setUpdateUid(int updateUid) {
        this.updateUid = updateUid;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    @Override
    public String toString() {
        return "Chapter{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", novel=" + novel +
                ", contents='" + contents + '\'' +
                ", wordCount=" + wordCount +
                ", createUid=" + createUid +
                ", createTime=" + createTime +
                ", updateUid=" + updateUid +
                ", updateTime=" + updateTime +
                '}';
    }
}
