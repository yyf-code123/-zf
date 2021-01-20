package com.zf.service;

import com.zf.entity.Thumb;
import org.springframework.data.jpa.repository.Query;

public interface ThumbService {

    public Thumb findById(Integer id);

    public Thumb save(Thumb thumb);

    public Thumb update(Thumb thumb);

    public Integer delete(Integer id);

    public Long getThumbNumById(String condition,Integer id);

    public Thumb findByCommentIdAndUserId(Integer id, Integer userId);

    public Thumb findByReplyIdAndUserId(Integer id, Integer fromUserId);

    public void deleteByReplyIdAndUserId(Integer replyId, Integer userId);
}
