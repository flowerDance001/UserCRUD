package com.csy.service.order;

import com.csy.service.order.base.QueryBaseOrder;

public class UserOrder extends QueryBaseOrder{
	
	//用户id
	private int						userId;
	//用户名
	private String					userName;
	//电话
	private String					telNo;
	
	private String					qqNo;
	
	private String					emailNo;
	//地址
	private String					userAddress;
	//真实姓名
	private String					realName;
	//身份证号码
	private String					idCard;

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

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("userOrder [userId=");
		builder.append(userId);
		builder.append(", userName=");
		builder.append(userName);
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
		builder.append("]");
		return builder.toString();
	}
	
	

}
