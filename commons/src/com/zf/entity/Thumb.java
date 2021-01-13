package com.zf.entity;

import javax.persistence.*;
import java.io.Serializable;

/**
 * 2021-01-12 19:17
 */
@Entity
@Table(name = "thumb")
public class Thumb implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "comment_id")
    private Integer commentId; //评论id

    @Column(name = "reply_id")
    private Integer replyId;  //回复id

    @Column(name = "user_id")
    private Integer userId; //用户id

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getCommentId() {
        return commentId;
    }

    public void setCommentId(Integer commentId) {
        this.commentId = commentId;
    }

    public Integer getReplyId() {
        return replyId;
    }

    public void setReplyId(Integer replyId) {
        this.replyId = replyId;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    @Override
    public String toString() {
        return "Thumb{" +
                "id=" + id +
                ", commentId=" + commentId +
                ", replyId=" + replyId +
                ", userId=" + userId +
                '}';
    }
}
