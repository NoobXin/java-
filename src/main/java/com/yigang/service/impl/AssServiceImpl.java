package com.yigang.service.impl;

import com.yigang.dao.AssDao;
import com.yigang.dao.UserDao;
import com.yigang.service.AssService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@Service
@Transactional
public class AssServiceImpl implements AssService {
	
	@Autowired
	private AssDao assDao;

}
