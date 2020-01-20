package com.yigang.controller;

import com.yigang.entity.*;
import com.yigang.service.AssService;
import com.yigang.service.RepairSerivce;
import com.yigang.service.UserService;
import com.yigang.utils.EmailPost;
import com.yigang.utils.ResultUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;
import java.text.ParseException;
import java.util.Date;

@Controller
@RequestMapping("/ass")
public class AssessController {

	@Autowired
	private RepairSerivce repairSerivce;


    @Autowired
	private AssService assService;


	@RequestMapping("assList")
	public String repairList() {
		return "jsp/ass/assList";
	}

	/**
	 * 全部信息
	 * @param page
	 * @param limit
	 * @param search
	 * @return
	 */
	@RequestMapping("getAssList")
	@ResponseBody
	public ResultUtil getAssList(Integer page, Integer limit, AssSearch search) {
		return assService.getAssList(page, limit,search);
	}
	/*
	 * 评价修理任务
	 */
	@RequestMapping("/dealAss")
	@ResponseBody
	public ResultUtil dealAss(AssSearch info)  {
		int repairId = info.getRepairId();
		RepairSearch repairSearch = repairSerivce.getRepairById(Integer.toString(repairId));
		info.setCreatePerId(repairSearch.getCreatePerId());
		info.setDescription(repairSearch.getDescription());
		info.setCreateTime(new Date());
		info.setRepairManId(repairSearch.getRepairManId());
		assService.insert(info);
		return new ResultUtil(0);
	}

	/*
	 * 通过Id删除管理员
	 */
	@RequestMapping("/delete")
	@ResponseBody
	public ResultUtil delete(int id) {
		assService.delete(id);
		return ResultUtil.ok();
	}
}
