package com.zf.service;

import com.zf.entity.Reply;
import org.springframework.data.jpa.repository.Query;

public interface ReplyService {

    public Reply findById(Integer id);

    public Reply save(Reply reply);

    public Reply update(Reply reply);

    @Query(value = "delete from Reply where id = ?1")
    public Integer delete(Integer id);
}
