package com.zf.service.impl;

import com.zf.dao.ReplyDao;
import com.zf.entity.Reply;
import com.zf.service.ReplyService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class ReplyServiceImpl implements ReplyService {

    @Resource
    ReplyDao replyDao;

    @Override
    public Reply findById(Integer id) {
        return replyDao.findById(id).get();
    }

    @Override
    public Reply save(Reply reply) {
        return replyDao.save(reply);
    }

    @Override
    public Reply update(Reply reply) {
        return replyDao.save(reply);
    }

    @Override
    public Integer delete(Integer id) {
        return replyDao.delete(id);
    }

    @Override
    public List<Reply> getCommentAllReply(Integer commentId) {
        return replyDao.findByCommentId(commentId);
    }
}
