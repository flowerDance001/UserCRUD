package com.csy.dao;

import java.util.List;

import com.csy.pojo.UserPojo;

public interface UserDao {
	
	/***
	 * 根据Id删除用户
	 * @param UserPojoId
	 * @return
	 */
    int deleteByPrimaryKey(Integer UserPojoId);
    
    int insert(UserPojo record);

    /***
     * 插入用户
     * @param record
     * @return
     */
    int insertSelective(UserPojo record);

    /***
     * 根据Id查询用户
     * @param UserPojoId
     * @return
     */
    UserPojo selectByPrimaryKey(Integer UserPojoId);
    
    /***
     * 条件查询用户
     * @param record
     * @return
     */
    List<UserPojo> selectByName(UserPojo record);
    
    /***
     * 查询用户总数
     * @param record
     * @return
     */
    long selectByNameCount(UserPojo record);

    /***
     * 修改用户
     * @param record
     * @return
     */
    int updateByPrimaryKeySelective(UserPojo record);

    int updateByPrimaryKey(UserPojo record);
}