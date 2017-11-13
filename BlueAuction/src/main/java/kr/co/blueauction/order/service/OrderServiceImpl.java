package kr.co.blueauction.order.service;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import kr.co.blueauction.order.dao.OrdersDao;
import kr.co.blueauction.order.domain.Orders;

@Service
public class OrderServiceImpl implements OrderService {

	
	@Inject
	private OrdersDao ordersDao;
	
	@Override
	public void insert(Orders orders) {
		ordersDao.insert(orders);
	}

	@Override
	public List<Orders> listAll() {
		return ordersDao.listAll();
	}

	@Override
	public Orders readByNo(int orderNo) {
		return ordersDao.readByNo(orderNo);
	}

	@Override
	public void update(Orders orders) {
		ordersDao.update(orders);
	}

	@Override
	public void delete(int orderNo) {
		ordersDao.delete(orderNo);
	}

}
