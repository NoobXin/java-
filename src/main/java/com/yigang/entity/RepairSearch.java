package com.yigang.entity;

import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

public class RepairSearch {

    private int repairId;
    private int repairManId;
    private int repairStatus;
    private String roomNum;
    private int createPerId;
	@DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	private Date createTime;
	private String description;
	private String createTimeStart;
	private String createTimeEnd;


	public String getCreateTimeStart() {
		return createTimeStart;
	}

	public void setCreateTimeStart(String createTimeStart) {
		this.createTimeStart = createTimeStart;
	}

	public String getCreateTimeEnd() {
		return createTimeEnd;
	}

	public void setCreateTimeEnd(String createTimeEnd) {
		this.createTimeEnd = createTimeEnd;
	}

	public int getRepairId() {
		return repairId;
	}

	public void setRepairId(int repairId) {
		this.repairId = repairId;
	}

	public int getRepairManId() {
		return repairManId;
	}

	public void setRepairManId(int repairManId) {
		this.repairManId = repairManId;
	}

	public int getRepairStatus() {
		return repairStatus;
	}

	public void setRepairStatus(int repairStatus) {
		this.repairStatus = repairStatus;
	}

	public String getRoomNum() {
		return roomNum;
	}

	public void setRoomNum(String roomNum) {
		this.roomNum = roomNum;
	}

	public int getCreatePerId() {
		return createPerId;
	}

	public void setCreatePerId(int createPerId) {
		this.createPerId = createPerId;
	}

	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
}
