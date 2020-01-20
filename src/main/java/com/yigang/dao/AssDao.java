package com.yigang.dao;

import com.yigang.entity.AssSearch;
import com.yigang.entity.User;
import com.yigang.entity.UserSearch;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface AssDao {


    void insert(AssSearch info);

    List<AssSearch> getAssList(AssSearch search);

    void delete(int id);
}
