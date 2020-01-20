package com.yigang.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.yigang.dao.RepairDao;
import com.yigang.entity.RepairSearch;
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

    @Override
    public void insRepair(RepairSearch repairSearch) {
        repairDao.insRepair(repairSearch);
    }

    @Override
    public ResultUtil getWaitRepairList(Integer page, Integer limit, RepairSearch search) {
        PageHelper.startPage(page,limit);
        search.setRepairStatus("待导员审核");
        List<RepairSearch> repairInfo = repairDao.getWaitRepairList(search);
        PageInfo<RepairSearch> pageInfo = new PageInfo<RepairSearch>(repairInfo);
        ResultUtil resultUtil = new ResultUtil();
        resultUtil.setCode(0);
        resultUtil.setCount(pageInfo.getTotal());
        resultUtil.setData(pageInfo.getList());
        return resultUtil;
    }

    @Override
    public RepairSearch getRepairById(String repairId) {
        return  repairDao.getRepairById(repairId);
    }

    @Override
    public void updateReview(RepairSearch info) {
        repairDao.updateReview(info);
    }

    @Override
    public ResultUtil getWaitRepairListTwo(Integer page, Integer limit, RepairSearch search) {
        PageHelper.startPage(page,limit);
        search.setRepairStatus("待院长审核");
        List<RepairSearch> repairInfo = repairDao.getWaitRepairList(search);
        PageInfo<RepairSearch> pageInfo = new PageInfo<RepairSearch>(repairInfo);
        ResultUtil resultUtil = new ResultUtil();
        resultUtil.setCode(0);
        resultUtil.setCount(pageInfo.getTotal());
        resultUtil.setData(pageInfo.getList());
        return resultUtil;
    }

    @Override
    public void updateDealRepair(RepairSearch info) {
        repairDao.updateDealRepair(info);
    }

    @Override
    public ResultUtil getWaitRepairListTre(Integer page, Integer limit, RepairSearch search) {
        PageHelper.startPage(page,limit);
        search.setRepairStatus("处理中");
        List<RepairSearch> repairInfo = repairDao.getWaitRepairList(search);
        PageInfo<RepairSearch> pageInfo = new PageInfo<RepairSearch>(repairInfo);
        ResultUtil resultUtil = new ResultUtil();
        resultUtil.setCode(0);
        resultUtil.setCount(pageInfo.getTotal());
        resultUtil.setData(pageInfo.getList());
        return resultUtil;
    }
}
