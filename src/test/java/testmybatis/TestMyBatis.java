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
}
