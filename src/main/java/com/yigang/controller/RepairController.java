package com.yigang.controller;

import com.yigang.entity.RepairSearch;
import com.yigang.entity.User;
import com.yigang.entity.UserSearch;
import com.yigang.service.RepairSerivce;
import com.yigang.service.UserService;
import com.yigang.utils.ResultUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;
import java.text.ParseException;

@Controller
@RequestMapping("/repair")
public class RepairController {

	@Autowired
	private RepairSerivce repairSerivce;


	@RequestMapping("repairList")
	public String repairList() {
		return "jsp/repair/repairList";
	}

	@RequestMapping("getAllRepairList")
	@ResponseBody
	public ResultUtil getAllRepairList(Integer page, Integer limit, RepairSearch search) {
		return repairSerivce.getAllRepairList(page, limit,search);
	}
//
//
//	@RequestMapping("editUser/{id}")
//	public String editUser(@PathVariable("id") int id, HttpSession session) {
//		User user = userService.getUserById(id);
//		session.setAttribute("user", user);
//		return "jsp/user/editUser";
//	}

	
	@RequestMapping("addUser")
	public String userAdd(){
		return "jsp/user/addUser";
	}

	@RequestMapping("userZc")
	public String userZc(){
		return "jsp/user/userZc";
	}




}
