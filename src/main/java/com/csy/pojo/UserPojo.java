package com.csy.pojo;

import java.util.Date;

public class UserPojo {
	
	//用户id
	private int					userId;
	//用户名
	private String				userName;
	//密码
	private String				userPwd;
	
	//用户介绍
	private String				userInfo;
	//用户电话
	private String				telNo;
	//用户QQ
	private String				qqNo;
	//用户邮箱
	private String				emailNo;
	//用户地址
	private String				userAddress;
	//用户名
	private String				realName;
	//身份证号
	private String				idCard;
	//地址
	private String				disableReason;
	//创建时间
	private Date				createTime;
	
	
	long						start;
	long						limit;
	

	
	
	public long getStart() {
		return start;
	}
	public void setStart(long start) {
		this.start = start;
	}
	public long getLimit() {
		return limit;
	}
	public void setLimit(long limit) {
		this.limit = limit;
	}
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getUserPwd() {
		return userPwd;
	}
	public void setUserPwd(String userPwd) {
		this.userPwd = userPwd;
	}
	public String getUserInfo() {
		return userInfo;
	}
	public void setUserInfo(String userInfo) {
		this.userInfo = userInfo;
	}
	public String getTelNo() {
		return telNo;
	}
	public void setTelNo(String telNo) {
		this.telNo = telNo;
	}
	public String getQqNo() {
		return qqNo;
	}
	public void setQqNo(String qqNo) {
		this.qqNo = qqNo;
	}
	public String getEmailNo() {
		return emailNo;
	}
	public void setEmailNo(String emailNo) {
		this.emailNo = emailNo;
	}
	public String getUserAddress() {
		return userAddress;
	}
	public void setUserAddress(String userAddress) {
		this.userAddress = userAddress;
	}
	public String getRealName() {
		return realName;
	}
	public void setRealName(String realName) {
		this.realName = realName;
	}
	public String getIdCard() {
		return idCard;
	}
	public void setIdCard(String idCard) {
		this.idCard = idCard;
	}
	public String getDisableReason() {
		return disableReason;
	}
	public void setDisableReason(String disableReason) {
		this.disableReason = disableReason;
	}
	public Date getCreateTime() {
		return createTime;
	}
	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("UserPojo [userId=");
		builder.append(userId);
		builder.append(", userName=");
		builder.append(userName);
		builder.append(", userPwd=");
		builder.append(userPwd);
		builder.append(", userInfo=");
		builder.append(userInfo);
		builder.append(", telNo=");
		builder.append(telNo);
		builder.append(", qqNo=");
		builder.append(qqNo);
		builder.append(", emailNo=");
		builder.append(emailNo);
		builder.append(", userAddress=");
		builder.append(userAddress);
		builder.append(", realName=");
		builder.append(realName);
		builder.append(", idCard=");
		builder.append(idCard);
		builder.append(", disableReason=");
		builder.append(disableReason);
		builder.append(", createTime=");
		builder.append(createTime);
		builder.append(", start=");
		builder.append(start);
		builder.append(", limit=");
		builder.append(limit);
		builder.append("]");
		return builder.toString();
	}
	

	
	
}
