package com.yigang.service;

import com.yigang.entity.RepairSearch;
import com.yigang.utils.ResultUtil;

public interface RepairSerivce {
    ResultUtil getAllRepairList(Integer page, Integer limit, RepairSearch search);

    void insRepair(RepairSearch repairSearch);

    ResultUtil getWaitRepairList(Integer page, Integer limit, RepairSearch search);

    RepairSearch getRepairById(String repairId);

    void updateReview(RepairSearch info);

    ResultUtil getWaitRepairListTwo(Integer page, Integer limit, RepairSearch search);

    void updateDealRepair(RepairSearch info);
}
