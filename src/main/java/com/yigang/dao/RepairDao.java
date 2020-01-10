package com.yigang.dao;

import com.yigang.entity.RepairSearch;

import java.util.List;

public interface RepairDao {
    List<RepairSearch> getAllRepairList(RepairSearch search);
}
