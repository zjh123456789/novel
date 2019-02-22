package com.zhujinghui.novel.pojo;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.util.Date;

/**
 * @Author: JinghuiZhu
 * @Description: 小说POJO
 * @Date: Created in 15:57 2019/2/22
 * @Modified By:
 */

@Entity
@Table(name = "t_novel")
@JsonIgnoreProperties({"handler","hibernatelazyInitializer"})
public class Novel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "name")
    private String name;

    @Column(name = "desc")
    private String desc;

    @Column(name = "image_path")
    private String imagePath;

    @ManyToOne
    @JoinColumn(name = "genre_id")
    private Genre genre;

    @Column(name = "word_count")
    private int wordCount;

    @Column(name = "vote_number")
    private int voteNumber;

    @Column(name = "author_id")
    private int authorId;

    @Column(name = "create_time")
    private Date createTime;

    @Column(name = "update_uid")
    private int updateUid;

    @Column(name = "update_time")
    private Date updateTime;

    /**
     * 1:更新中; 2:已完结
     */
    @Column(name = "state")
    private int state;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public String getImagePath() {
        return imagePath;
    }

    public void setImagePath(String imagePath) {
        this.imagePath = imagePath;
    }

    public Genre getGenre() {
        return genre;
    }

    public void setGenre(Genre genre) {
        this.genre = genre;
    }

    public int getWordCount() {
        return wordCount;
    }

    public void setWordCount(int wordCount) {
        this.wordCount = wordCount;
    }

    public int getVoteNumber() {
        return voteNumber;
    }

    public void setVoteNumber(int voteNumber) {
        this.voteNumber = voteNumber;
    }

    public int getAuthorId() {
        return authorId;
    }

    public void setAuthorId(int authorId) {
        this.authorId = authorId;
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

    public int getState() {
        return state;
    }

    public void setState(int state) {
        this.state = state;
    }

    @Override
    public String toString() {
        return "Novel{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", desc='" + desc + '\'' +
                ", imagePath='" + imagePath + '\'' +
                ", genre=" + genre +
                ", wordCount=" + wordCount +
                ", voteNumber=" + voteNumber +
                ", authorId=" + authorId +
                ", createTime=" + createTime +
                ", updateUid=" + updateUid +
                ", updateTime=" + updateTime +
                ", state=" + state +
                '}';
    }
}
