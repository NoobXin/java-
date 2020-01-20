package com.yigang.service;

import com.yigang.entity.AssSearch;
import com.yigang.entity.User;
import com.yigang.entity.UserSearch;
import com.yigang.utils.ResultUtil;

public interface AssService {

    void insert(AssSearch info);

    ResultUtil getAssList(Integer page, Integer limit, AssSearch search);

    void delete(int id);
}
