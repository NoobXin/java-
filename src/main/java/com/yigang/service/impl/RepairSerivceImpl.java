package com.yigang.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.yigang.dao.RepairDao;
import com.yigang.entity.RepairSearch;
import com.yigang.entity.User;
import com.yigang.service.RepairSerivce;
import com.yigang.utils.ResultUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class RepairSerivceImpl implements RepairSerivce {

    @Autowired
    private RepairDao repairDao;

    @Override
    public ResultUtil getAllRepairList(Integer page, Integer limit, RepairSearch search) {
        PageHelper.startPage(page,limit);
        List<RepairSearch> repairInfo = repairDao.getAllRepairList(search);
        PageInfo<RepairSearch> pageInfo = new PageInfo<RepairSearch>(repairInfo);
        ResultUtil resultUtil = new ResultUtil();
        resultUtil.setCode(0);
        resultUtil.setCount(pageInfo.getTotal());
        resultUtil.setData(pageInfo.getList());
        return resultUtil;
    }
}
