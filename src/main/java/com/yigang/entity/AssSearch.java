package com.yigang.entity;

import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

public class AssSearch {

    private int repairId;
    private String repairManId;
    private String repairStatus;
    private String roomNum;
    private String createPerId;
	@DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	private Date createTime;
	private String description;
	private String createTimeStart;
	private String createTimeEnd;
	private String reviewName;

	public String getReviewName() {
		return reviewName;
	}

	public void setReviewName(String reviewName) {
		this.reviewName = reviewName;
	}

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

	public String getRepairStatus() {
		return repairStatus;
	}

	public void setRepairStatus(String repairStatus) {
		this.repairStatus = repairStatus;
	}

	public String getRoomNum() {
		return roomNum;
	}

	public void setRoomNum(String roomNum) {
		this.roomNum = roomNum;
	}

	public String getRepairManId() {
		return repairManId;
	}

	public void setRepairManId(String repairManId) {
		this.repairManId = repairManId;
	}

	public String getCreatePerId() {
		return createPerId;
	}

	public void setCreatePerId(String createPerId) {
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
