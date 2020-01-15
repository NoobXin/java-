package com.yigang.controller;

import com.yigang.entity.Admin;
import com.yigang.entity.RepairSearch;
import com.yigang.entity.User;
import com.yigang.entity.UserSearch;
import com.yigang.service.AdminService;
import com.yigang.service.RepairSerivce;
import com.yigang.service.UserService;
import com.yigang.utils.EmailPost;
import com.yigang.utils.MD5Utils;
import com.yigang.utils.ResultUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;
import java.text.ParseException;
import java.util.Date;

@Controller
@RequestMapping("/repair")
public class RepairController {

	@Autowired
	private RepairSerivce repairSerivce;

	@Autowired
	private AdminService adminService;


	@RequestMapping("repairList")
	public String repairList() {
		return "jsp/repair/repairList";
	}

	@RequestMapping("waitRepairList")
	public String waitRepairList() {
		return "jsp/repair/waitRepairList";
	}

	@RequestMapping("waitRepairListTwo")
	public String waitRepairListTwo() {
		return "jsp/repair/waitRepairListTwo";
	}

	@RequestMapping("dealRepair")
	public String dealRepair(Model model,String repairId) {
		RepairSearch info = repairSerivce.getRepairById(repairId);
		model.addAttribute("info", info);
		return "jsp/repair/dealRepair";
	}

	/**
	 * 全部信息
	 * @param page
	 * @param limit
	 * @param search
	 * @return
	 */
	@RequestMapping("getAllRepairList")
	@ResponseBody
	public ResultUtil getAllRepairList(Integer page, Integer limit, RepairSearch search) {
		return repairSerivce.getAllRepairList(page, limit,search);
	}

	/**
	 * 待导员处理
	 * @param page
	 * @param limit
	 * @param search
	 * @return
	 */
	@RequestMapping("getWaitRepairList")
	@ResponseBody
	public ResultUtil getWaitRepairList(Integer page, Integer limit, RepairSearch search) {
		return repairSerivce.getWaitRepairList(page, limit,search);
	}
	/**
	 * 待院长处理
	 * @param page
	 * @param limit
	 * @param search
	 * @return
	 */
	@RequestMapping("getWaitRepairListTwo")
	@ResponseBody
	public ResultUtil getWaitRepairListTwo(Integer page, Integer limit, RepairSearch search) {
		return repairSerivce.getWaitRepairListTwo(page, limit,search);
	}
	@RequestMapping("addRepair")
	public String addRepair(){
		return "jsp/repair/addRepair";
	}

	/**
	 * 提交报修单
	 * @param repairSearch
	 * @param session
	 * @return
	 */
	@RequestMapping("insRepair")
	@ResponseBody
	public ResultUtil insRepair(RepairSearch repairSearch,HttpSession session){
		Admin admin = (Admin) session.getAttribute("admin");
		repairSearch.setCreatePerId(admin.getNickname());
		repairSearch.setRepairStatus("待导员审核");
		repairSearch.setCreateTime(new Date());
		repairSerivce.insRepair(repairSearch);
		return ResultUtil.ok();
	}

	/**
	 * 导员审核
	 * @param repairId
	 * @return
	 */
	@RequestMapping("reviewByTea")
	@ResponseBody
	public ResultUtil reviewByTea(String repairId,HttpSession session) {
		RepairSearch info = repairSerivce.getRepairById(repairId);
		Admin admin = (Admin) session.getAttribute("admin");
		info.setReviewName(admin.getNickname());
		info.setRepairStatus("待院长审核");
		repairSerivce.updateReview(info);
		return ResultUtil.ok();
	}
	/**
	 * 院长审核
	 * @param repairId
	 * @return
	 */
	@RequestMapping("reviewByDean")
	@ResponseBody
	public ResultUtil reviewByDean(String repairId,HttpSession session) {
		RepairSearch info = repairSerivce.getRepairById(repairId);
		Admin admin = (Admin) session.getAttribute("admin");
		info.setReviewName(admin.getNickname());
		info.setRepairStatus("待分配处理");
		repairSerivce.updateReview(info);
		return ResultUtil.ok();
	}
	/*
	 * 分配修理任务
	 */
	@RequestMapping("/updateDealRepair")
	@ResponseBody
	public ResultUtil updateDealRepair(RepairSearch info) throws Exception {
		Admin admin = adminService.getAdminByNickname(info.getRepairManId());
		if (admin == null) {
			return new ResultUtil(501, "请输出正确得修理人姓名！");
		}
		//发送邮件
		EmailPost.postMail(admin.getEmail(),info.getDescription());
		info.setRepairStatus("处理中");
		repairSerivce.updateDealRepair(info);
		return new ResultUtil(0);
	}
}
