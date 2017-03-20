package com.csy.service;

import com.csy.pojo.UserPojo;
import com.csy.service.order.UserOrder;
import com.csy.service.result.QueryBaseBatchResult;


public interface UserService {

	/***
	 * 根据id查询用户
	 * @param userId
	 * @return
	 */
	 public UserPojo getUserById(int userId);
	 
	 	/**
		 * 查询用户信息列表
		 * @param userQueryOrder
		 * @return
		 */
		public QueryBaseBatchResult<UserPojo> queryUserList(UserOrder order);
		
		/**
		 * 插入用户
		 * @param user
		 * @return
		 */
		public int insterUser(UserPojo user);
		
		
		/***
		 * 修改用户
		 * @param user
		 * @return
		 */
		public int updateUser(UserPojo user);
		
		
		/***
		 * 删除用户
		 * @param userId
		 * @return
		 */
		public int deleteUserById(int userId);
}
