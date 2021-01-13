package com.zf.entity;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name="collectcatalog")
public class CollectCatalog implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @Column(name = "collect_catalog_name")
    private String collectCatalogName;

    @Column(name = "user_id")
    private String userId;

    @Column(name = "collect_catalog_time")
    private String collectCatalogTime;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCollectCatalogName() {
        return collectCatalogName;
    }

    public void setCollectCatalogName(String collectCatalogName) {
        this.collectCatalogName = collectCatalogName;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getCollectCatalogTime() {
        return collectCatalogTime;
    }

    public void setCollectCatalogTime(String collectCatalogTime) {
        this.collectCatalogTime = collectCatalogTime;
    }

    @Override
    public String toString() {
        return "collectCatalog{" +
                "id=" + id +
                ", collectCatalogName='" + collectCatalogName + '\'' +
                ", userId='" + userId + '\'' +
                ", collectCatalogTime='" + collectCatalogTime + '\'' +
                '}';
    }
}
