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

	@Override
	/** 로그인된 회원의 중고or 옥션 구매 리스트를 조회 **/
	public List<Orders> orderList(String memberId, String auctionFlag) throws Exception{
		List<Orders> orderList= ordersDao.orderList(memberId, auctionFlag);
		
		return orderList;

	}
}
