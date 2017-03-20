package com.csy.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;

import testmybatis.TestMyBatis;

import com.csy.dao.UserDao;
import com.csy.pojo.UserPojo;
import com.csy.service.UserService;
import com.csy.service.order.UserOrder;
import com.csy.service.order.base.PageComponent;
import com.csy.service.result.QueryBaseBatchResult;


@Service("userService")
public class UserServiceImpl implements UserService{
	
	//private static Logger logger = Logger.getLogger(TestMyBatis.class);

	@Resource
	private UserDao userDao;
	
	@Override
	public UserPojo getUserById(int userId) {
		
		UserPojo userPojo = this.userDao.selectByPrimaryKey(userId);
		
		return userPojo;
	}

	@Override
	public QueryBaseBatchResult<UserPojo> queryUserList(UserOrder order) {
		//返回用户list
		QueryBaseBatchResult<UserPojo> result = new QueryBaseBatchResult<UserPojo>();
		try {
			UserPojo userPojo = new UserPojo();
			String realName = order.getRealName();
			if (!"".equals(realName)) {
				userPojo.setRealName(realName);
			}
			//查询用户总数
			long totalCount = userDao.selectByNameCount(userPojo);
			PageComponent component = new PageComponent(order, totalCount);
			userPojo.setStart(component.getFirstRecord());
			userPojo.setLimit(component.getPageSize());
			System.out.println("这里是查询条件："+userPojo);
			List<UserPojo> selectByName = userDao.selectByName(userPojo);
			System.out.println("这里是查询出来的用户："+selectByName);
			result.setSuccess(true);
			//返回用户list
			result.setPageList(selectByName);
			//设置总数
			result.setTotalCount(totalCount);
			//设置页数
			result.initPageParam(component);
			
		} catch (IllegalArgumentException e) {
			result.setSuccess(false);
			result.setMessage(e.getMessage());
		} catch (Exception e) {
			result.setSuccess(false);
		}
		return result;
	}

}
