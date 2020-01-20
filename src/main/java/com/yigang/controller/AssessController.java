package com.yigang.controller;

import com.yigang.entity.User;
import com.yigang.entity.UserSearch;
import com.yigang.service.AssService;
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
@RequestMapping("/ass")
public class AssessController {

	@Autowired
	private UserService userService;

    @Autowired
	private AssService assService;

	@RequestMapping("getAllUserList")
	@ResponseBody
	public ResultUtil getAllUserList(Integer page, Integer limit,UserSearch search) {
		return userService.getAllUserList(page, limit,search);
	}
	
	@RequestMapping("userList")
	public String userList() {
		return "jsp/user/userList";
	}

	
	@RequestMapping("deleteUserById")
	@ResponseBody
	public ResultUtil deleteUserById(int id) {
		return userService.deleteUserById(id);
	}

	
	@RequestMapping("insertUser")
	@ResponseBody
	public ResultUtil insUser(User user){
		//防止浏览器提交
		User user1 = userService.selUserByUsername(user.getUsername());
		if(null != user1){
			return new ResultUtil(500,"用户名已存在，请重新填写！");
		}
		try {
			userService.insertUser(user);
			return ResultUtil.ok();
		} catch (Exception e) {
			return new ResultUtil(502,"网络错误，请检查网络！");
		}
	}

}
