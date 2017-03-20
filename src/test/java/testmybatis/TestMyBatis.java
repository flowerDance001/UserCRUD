package testmybatis;

import java.util.List;

import javax.annotation.Resource;

import org.apache.log4j.Logger;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.alibaba.fastjson.JSON;
import com.csy.pojo.UserPojo;
import com.csy.service.UserService;
import com.csy.service.order.UserOrder;
import com.csy.service.result.QueryBaseBatchResult;


@RunWith(SpringJUnit4ClassRunner.class)		//表示继承了SpringJUnit4ClassRunner类
@ContextConfiguration(locations = {"classpath:spring-mybatis.xml"})

public class TestMyBatis {
	private static Logger logger = Logger.getLogger(TestMyBatis.class);

	@Resource
	private UserService userService = null;

	@Test
	public void test1() {
		UserPojo user = userService.getUserById(273);
		// System.out.println(user.getUserName());
		// logger.info("鍊硷細"+user.getUserName());
		logger.info(JSON.toJSONString(user));
	}
	
	@Test
	public void test2() {
		 UserOrder order = new UserOrder();
		QueryBaseBatchResult<UserPojo> queryUserList = userService.queryUserList(order);
		List<UserPojo> pageList = queryUserList.getPageList();
		// System.out.println(user.getUserName());
		// logger.info("鍊硷細"+user.getUserName());
		logger.info(JSON.toJSONString(pageList));
		
	}
	
	@Test
	public void testInsterUser() {
		 UserPojo user = new UserPojo();
		 
		 user.setUserName("csy002");
		 user.setUserPwd("888888");
		 user.setRealName("陈思宇02");
		 
		int insterUser = userService.insterUser(user);
		
		logger.info(JSON.toJSONString(insterUser));
		
	}
	
	
	@Test
	public void testUpdateUser() {
		 UserPojo user = new UserPojo();
		 user.setUserId(274);
		 user.setUserName("csy003");
		 user.setUserPwd("888888");
		 user.setRealName("陈思宇03");
		 
		int updateUser = userService.updateUser(user);
		
		logger.info(JSON.toJSONString(updateUser));
		
	}
	
	@Test
	public void testDeleteUser() {
		 
		int userId = 274;
		int deleteUser = userService.deleteUserById(userId);
		
		logger.info(JSON.toJSONString(deleteUser));
		
	}
	
}
