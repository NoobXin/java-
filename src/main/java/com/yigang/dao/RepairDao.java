package com.yigang.dao;

import com.yigang.entity.RepairSearch;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface RepairDao {
    List<RepairSearch> getAllRepairList(RepairSearch search);

    void insRepair(RepairSearch repairSearch);

    List<RepairSearch> getWaitRepairList(RepairSearch search);

    RepairSearch getRepairById(@Param("repairId")String repairId);

    int updateReview(RepairSearch info);

    void updateDealRepair(RepairSearch info);
}
