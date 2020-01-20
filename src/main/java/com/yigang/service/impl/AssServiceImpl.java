package com.yigang.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.yigang.dao.AssDao;
import com.yigang.dao.UserDao;
import com.yigang.entity.AssSearch;
import com.yigang.entity.RepairSearch;
import com.yigang.service.AssService;
import com.yigang.utils.ResultUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


@Service
@Transactional
public class AssServiceImpl implements AssService {
	
	@Autowired
	private AssDao assDao;

	@Override
	public void insert(AssSearch info) {
		assDao.insert(info);
	}

	@Override
	public ResultUtil getAssList(Integer page, Integer limit, AssSearch search) {
		PageHelper.startPage(page,limit);
		List<AssSearch> info = assDao.getAssList(search);
		PageInfo<AssSearch> pageInfo = new PageInfo<AssSearch>(info);
		ResultUtil resultUtil = new ResultUtil();
		resultUtil.setCode(0);
		resultUtil.setCount(pageInfo.getTotal());
		resultUtil.setData(pageInfo.getList());
		return resultUtil;
	}

	@Override
	public void delete(int id) {
		assDao.delete(id);
	}
}
