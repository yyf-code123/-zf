package com.zf.entity;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name="article")
public class Article  implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @Column(name = "title")
    private String title;

    @Column(name = "user_id")
    private Integer userId;

    @Column(name = "pubTime")
    private String pubTime;

    @Column(name = "content")
    private String content;

    @Column(name = "classification_id")
    private Integer classificationId;

    @Column(name = "delete_time")
    private String deleteTime;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getPubTime() {
        return pubTime;
    }

    public void setPubTime(String pubTime) {
        this.pubTime = pubTime;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Integer getClassificationId() {
        return classificationId;
    }

    public void setClassificationId(Integer classificationId) {
        this.classificationId = classificationId;
    }

    public String getDeleteTime() {
        return deleteTime;
    }

    public void setDeleteTime(String deleteTime) {
        this.deleteTime = deleteTime;
    }

    @Override
    public String toString() {
        return "Article{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", userId=" + userId +
                ", pubTime='" + pubTime + '\'' +
                ", content='" + content + '\'' +
                ", classificationId=" + classificationId +
                ", deleteTime='" + deleteTime + '\'' +
                '}';
    }
}
