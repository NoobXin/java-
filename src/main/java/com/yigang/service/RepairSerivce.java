package com.yigang.service;

import com.yigang.entity.RepairSearch;
import com.yigang.utils.ResultUtil;

public interface RepairSerivce {
    ResultUtil getAllRepairList(Integer page, Integer limit, RepairSearch search);
}
