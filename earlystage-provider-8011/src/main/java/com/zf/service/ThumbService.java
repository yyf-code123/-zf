package com.zf.service;

import com.zf.entity.Thumb;
import org.springframework.data.jpa.repository.Query;

public interface ThumbService {

    public Thumb findById(Integer id);

    public Thumb save(Thumb thumb);

    public Thumb update(Thumb thumb);

    @Query(value = "delete from Thumb where id = ?1")
    public Integer delete(Integer id);
}
