package com.yigang.service.impl;

import com.yigang.dao.RepaieDao;
import com.yigang.dao.UserDao;
import com.yigang.entity.RepairSearch;
import com.yigang.service.RepairSerivce;
import com.yigang.utils.ResultUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class RepairSerivceImpl implements RepairSerivce {

    @Autowired
    private RepaieDao repaieDao;

    @Override
    public ResultUtil getAllRepairList(Integer page, Integer limit, RepairSearch search) {
        return null;
    }
}
