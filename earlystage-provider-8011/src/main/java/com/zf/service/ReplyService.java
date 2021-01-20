package com.zf.service;

import com.zf.entity.Reply;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ReplyService {

    public Reply findById(Integer id);

    public Reply save(Reply reply);

    public Reply update(Reply reply);

    public Integer delete(Integer id);

    public List<Reply> getCommentAllReply(Integer commentId);
}
