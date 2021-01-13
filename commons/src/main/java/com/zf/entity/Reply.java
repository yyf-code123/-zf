package com.zf.entity;

import javax.persistence.*;
import java.io.Serializable;

/**
 * 2021-01-12 19:27
 */
@Entity
@Table(name = "reply")
public class Reply implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "comment_id")
    private Integer commentId;  //评论id

    @Column(name = "reply_content")
    private String replyContent; //回复内容

    @Column(name = "from_user_id")
    private Integer fromUserId;//回复人id

    @Column(name = "to_user_id")
    private Integer toUserId;//被回复人id

    @Column(name = "pub_time")
    private String pubTime;//回复时间

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

    public String getReplyContent() {
        return replyContent;
    }

    public void setReplyContent(String replyContent) {
        this.replyContent = replyContent;
    }

    public Integer getFromUserId() {
        return fromUserId;
    }

    public void setFromUserId(Integer fromUserId) {
        this.fromUserId = fromUserId;
    }

    public Integer getToUserId() {
        return toUserId;
    }

    public void setToUserId(Integer toUserId) {
        this.toUserId = toUserId;
    }

    public String getPubTime() {
        return pubTime;
    }

    public void setPubTime(String pubTime) {
        this.pubTime = pubTime;
    }

    @Override
    public String toString() {
        return "Reply{" +
                "id=" + id +
                ", commentId=" + commentId +
                ", replyContent='" + replyContent + '\'' +
                ", fromUserId=" + fromUserId +
                ", toUserId=" + toUserId +
                ", pubTime='" + pubTime + '\'' +
                '}';
    }
}
