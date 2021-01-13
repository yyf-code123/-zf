package com.zf.entity;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "collect")
public class Collect implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "collect_id")
    private Integer collectId;

    @Column(name = "article_id")
    private Integer articleId;

    @Column(name = "collect_time")
    private String collectTime;

    @Column(name = "collect_status")
    private String collectStatus;

    @Column(name = "user_id")
    private Integer userId;

    @Column(name = "collectCatalog_id")
    private Integer collectCatalogId;

    public Integer getCollectId() {
        return collectId;
    }

    public void setCollectId(Integer collectId) {
        this.collectId = collectId;
    }

    public Integer getArticleId() {
        return articleId;
    }

    public void setArticleId(Integer articleId) {
        this.articleId = articleId;
    }

    public String getCollectTime() {
        return collectTime;
    }

    public void setCollectTime(String collectTime) {
        this.collectTime = collectTime;
    }

    public String getCollectStatus() {
        return collectStatus;
    }

    public void setCollectStatus(String collectStatus) {
        this.collectStatus = collectStatus;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Integer getCollectCatalogId() {
        return collectCatalogId;
    }

    public void setCollectCatalogId(Integer collectCatalogId) {
        this.collectCatalogId = collectCatalogId;
    }

    @Override
    public String toString() {
        return "collect{" +
                "collectId=" + collectId +
                ", articleId=" + articleId +
                ", collectTime='" + collectTime + '\'' +
                ", collectStatus='" + collectStatus + '\'' +
                ", userId=" + userId +
                ", collectCatalogId=" + collectCatalogId +
                '}';
    }
}
