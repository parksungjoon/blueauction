package kr.co.blueauction;

import java.util.List;

import javax.inject.Inject;

import org.apache.log4j.Logger;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import kr.co.blueauction.order.dao.OrdersDao;
import kr.co.blueauction.order.domain.Orders;

@RunWith(SpringJUnit4ClassRunner.class)	
@ContextConfiguration(locations= {"file:src/main/webapp/WEB-INF/spring/root-context.xml"})
public class OrderDaoTest {
	
	@Inject
	private OrdersDao orderDao;
	
	Logger logger = Logger.getLogger(OrderDaoTest.class);
	
//	@Test
	public void testInsert() {
		Orders orders = new Orders("sujin", 1, "010-9221-6679", "549", "경북 구미시", "자이아파트", 10000);
		orderDao.insert(orders);
	}
	
//	@Test
	public void textListAll() {
		List<Orders> list = orderDao.listAll();
		for (Orders orders2 : list) {
			logger.info(orders2);
		}
	}
	
//	@Test
	public void textreadByNo() {
		Orders orders = orderDao.readByNo(1);
		logger.info(orders);
	}

}
