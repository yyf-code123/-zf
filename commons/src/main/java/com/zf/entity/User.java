package com.zf.entity;

import javax.persistence.*;
import java.io.Serializable;

/**
 * 2021-01-12 17:27
 */
@Entity
@Table(name = "user")
public class User implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;  //用户id

    @Column(name = "user_nickname")
    private String userNickname;  //昵称

    @Column(name = "user_phone")
    private String userPhone;//手机

    @Column(name = "user_pass")
    private String userPass;//密码

    @Column(name = "user_sex")
    private String userSex; //性别

    @Column(name = "user_intro")
    private String userIntro; //简介

    @Column(name = "user_addr")
    private String userAddr;  //地址

    @Column(name = "user_work")
    private String userWork;  //职业

    @Column(name = "user_age")
    private Integer userAge;  //年龄

    @Column(name = "user_image")
    private String userImage; //头像

    @Column(name = "user_article_auth")
    private int user_article_auth; //发文权限

    @Column(name = "user_comment_auth")
    private int userCommentAuth; //评论权限

    @Column(name = "user_follow_number")
    private int userFollowNumber;  //关注数量

    @Column(name = "user_benoticed_number")
    private int userBenoticedNumber; //被关注数量

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUserNickname() {
        return userNickname;
    }

    public void setUserNickname(String userNickname) {
        this.userNickname = userNickname;
    }

    public String getUserPhone() {
        return userPhone;
    }

    public void setUserPhone(String userPhone) {
        this.userPhone = userPhone;
    }

    public String getUserPass() {
        return userPass;
    }

    public void setUserPass(String userPass) {
        this.userPass = userPass;
    }

    public String getUserSex() {
        return userSex;
    }

    public void setUserSex(String userSex) {
        this.userSex = userSex;
    }

    public String getUserIntro() {
        return userIntro;
    }

    public void setUserIntro(String userIntro) {
        this.userIntro = userIntro;
    }

    public String getUserAddr() {
        return userAddr;
    }

    public void setUserAddr(String userAddr) {
        this.userAddr = userAddr;
    }

    public String getUserWork() {
        return userWork;
    }

    public void setUserWork(String userWork) {
        this.userWork = userWork;
    }

    public Integer getUserAge() {
        return userAge;
    }

    public void setUserAge(Integer userAge) {
        this.userAge = userAge;
    }

    public String getUserImage() {
        return userImage;
    }

    public void setUserImage(String userImage) {
        this.userImage = userImage;
    }

    public int getUser_article_auth() {
        return user_article_auth;
    }

    public void setUser_article_auth(int user_article_auth) {
        this.user_article_auth = user_article_auth;
    }

    public int getUserCommentAuth() {
        return userCommentAuth;
    }

    public void setUserCommentAuth(int userCommentAuth) {
        this.userCommentAuth = userCommentAuth;
    }

    public int getUserFollowNumber() {
        return userFollowNumber;
    }

    public void setUserFollowNumber(int userFollowNumber) {
        this.userFollowNumber = userFollowNumber;
    }

    public int getUserBenoticedNumber() {
        return userBenoticedNumber;
    }

    public void setUserBenoticedNumber(int userBenoticedNumber) {
        this.userBenoticedNumber = userBenoticedNumber;
    }

    @Override
    public String toString() {
        return "one{" +
                "id=" + id +
                ", userNickname='" + userNickname + '\'' +
                ", userPhone='" + userPhone + '\'' +
                ", userPass='" + userPass + '\'' +
                ", userSex='" + userSex + '\'' +
                ", userIntro='" + userIntro + '\'' +
                ", userAddr='" + userAddr + '\'' +
                ", userWork='" + userWork + '\'' +
                ", userAge=" + userAge +
                ", userImage='" + userImage + '\'' +
                ", user_article_auth=" + user_article_auth +
                ", userCommentAuth=" + userCommentAuth +
                ", userFollowNumber=" + userFollowNumber +
                ", userBenoticedNumber=" + userBenoticedNumber +
                '}';
    }
}