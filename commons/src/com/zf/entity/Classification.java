package com.zf.entity;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name="classification")
public class Classification implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @Column(name = "classification_name")
    private String classificationName;

    @Column(name = "built_time")
    private String builtTime;


    public String getBuiltTime() {
        return builtTime;
    }

    public void setBuiltTime(String builtTime) {
        this.builtTime = builtTime;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getClassificationName() {
        return classificationName;
    }

    public void setClassificationName(String classificationName) {
        this.classificationName = classificationName;
    }

    @Override
    public String toString() {
        return "classification{" +
                "id=" + id +
                ", classificationName='" + classificationName + '\'' +
                ", builtTime='" + builtTime + '\'' +
                '}';
    }
}
