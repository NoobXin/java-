package com.yigang.entity;

import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

public class AssSearch {

    private int id;
    private int repairId;
    private String repairManId;
    private String assess;
    private String createPerId;
	@DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	private Date createTime;
	private String description;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getRepairId() {
		return repairId;
	}

	public void setRepairId(int repairId) {
		this.repairId = repairId;
	}

	public String getRepairManId() {
		return repairManId;
	}

	public void setRepairManId(String repairManId) {
		this.repairManId = repairManId;
	}

	public String getAssess() {
		return assess;
	}

	public void setAssess(String assess) {
		this.assess = assess;
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
