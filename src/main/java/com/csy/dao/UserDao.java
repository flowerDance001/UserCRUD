package com.csy.dao;

import java.util.List;

import com.csy.pojo.UserPojo;

public interface UserDao {
	
	/***
	 * ���Idɾ���û�
	 * @param UserPojoId
	 * @return
	 */
    int deleteByPrimaryKey(Integer UserPojoId);
    
    int insert(UserPojo record);

    /***
     * �����û�
     * @param record
     * @return
     */
    int insertSelective(UserPojo record);

    /***
     * ���Id��ѯ�û�
     * @param UserPojoId
     * @return
     */
    UserPojo selectByPrimaryKey(Integer UserPojoId);
    
    
    UserPojo selectUserByName(String userName);
    
    
    /***
     * ������ѯ�û�
     * @param record
     * @return
     */
    List<UserPojo> selectByName(UserPojo record);
    
    /***
     * ��ѯ�û�����
     * @param record
     * @return
     */
    long selectByNameCount(UserPojo record);

    /***
     * �޸��û�
     * @param record
     * @return
     */
    int updateByPrimaryKeySelective(UserPojo record);

    int updateByPrimaryKey(UserPojo record);
}