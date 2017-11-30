/**
 * Copyright(c) 2017, BlueAuction. All right reserved
 * @author 김봉환
 * @since 2017. 11. 15.
 */
package kr.co.blueauction.order.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import kr.co.blueauction.common.domain.Criteria;
import kr.co.blueauction.order.dao.OrdersDao;
import kr.co.blueauction.order.domain.Orders;
import kr.co.blueauction.product.dao.ProductDao;
import kr.co.blueauction.product.domain.Product;

/**
 * 중고, 옥션 물품 구매를위한 Order Service
 * 
 * @author 김봉환
 * @since 2017. 11. 15
 */
@Service
public class OrderServiceImpl implements OrderService {

	@Inject
	private OrdersDao ordersDao;
	@Inject
	private ProductDao productDao;

	/**
	 * 주문 등록
	 * 
	 * @param orders
	 * @see kr.co.blueauction.order.service.OrderService#insert(kr.co.blueauction.order.domain.Orders)
	 */
	@Override
	public void insert(Orders orders) {
		ordersDao.insert(orders);
	}

	/**
	 * 주문 리스트 조회
	 * 
	 * @return
	 * @see kr.co.blueauction.order.service.OrderService#insert(kr.co.blueauction.order.domain.Orders)
	 */
	@Override
	public List<Orders> listAll() {
		return ordersDao.listAll();
	}

	/**
	 * 주문 번호로 주문 조회
	 * 
	 * @param orderNo
	 * @return
	 * @see kr.co.blueauction.order.service.OrderService#insert(kr.co.blueauction.order.domain.Orders)
	 */
	@Override
	public Orders readByNo(int orderNo) {
		return ordersDao.readByNo(orderNo);
	}

	/**
	 * 주문 수정
	 * 
	 * @param orders
	 * @see kr.co.blueauction.order.service.OrderService#insert(kr.co.blueauction.order.domain.Orders)
	 */
	@Override
	public void update(Orders orders) {
		ordersDao.update(orders);
	}
	/**
	 * 주문 수정
	 * 
	 * @param orderId
	 * @see kr.co.blueauction.order.service.OrderService#insert(kr.co.blueauction.order.domain.Orders)
	 */
	@Override
	public void update(int orderId) throws Exception {
		ordersDao.update(orderId);
	}

	/**
	 * 주문 삭제
	 * 
	 * @param orderNo
	 * @see kr.co.blueauction.order.service.OrderService#insert(kr.co.blueauction.order.domain.Orders)
	 */
	@Override
	public void delete(int orderNo) {
		ordersDao.delete(orderNo);
	}


	/**
	 * 로그인된 회원의 중고or 옥션 구매 리스트를 조회 -페이지
	 * 
	 * @param orderNo
	 * @return
	 * @see kr.co.blueauction.order.service.OrderService#insert(kr.co.blueauction.order.domain.Orders)
	 */
	@Override
	public Map<String, Object> orderListCriteria(Criteria cri, String memberId, String auctionFlag) throws Exception {
		Map<String, Object> map = new HashMap<String, Object>();
		List<Product> productList = new ArrayList<Product>();
		List<Orders> orderList = ordersDao.orderListCriteria(cri, memberId, auctionFlag);
		map.put("orderList", orderList);

		if (orderList != null) {
			Product product = null;
			for (Orders order : orderList) {
				product = productDao.read(order.getProductId());
				productList.add(product);
			}
			map.put("productList", productList);
		}

		return map;
	}

	/**
	 * 회원 아이디로 페이지 조회
	 * 
	 * @param memberId
	 * @param auctionFlag
	 * @return
	 * @see kr.co.blueauction.order.service.OrderService#insert(kr.co.blueauction.order.domain.Orders)
	 */
	@Override
	public int listCountCriteria(String memberId, String auctionFlag) throws Exception {
		return ordersDao.countPaging(memberId, auctionFlag);
	}

	/**
	 * 주문번호로 주문가저오기
	 * 
	 * @param orderId
	 * @return
	 * @see kr.co.blueauction.order.service.OrderService#insert(kr.co.blueauction.order.domain.Orders)
	 */
	@Override
	public Orders readByOrderId(int orderId) throws Exception {
		return ordersDao.readByOrderId(orderId);
	}

	/**
	 * 상품번호로 주문가저오기
	 * 
	 * @param productId
	 * @return
	 * @see kr.co.blueauction.order.service.OrderService#insert(kr.co.blueauction.order.domain.Orders)
	 */
	@Override
	public Orders readByProductId(int productId) throws Exception {
		return ordersDao.readByProductId(productId);
	}

	/**
	 * 해당상품의 주문 개수
	 * 
	 * @param productId
	 * @return
	 * @see kr.co.blueauction.order.service.OrderService#insert(kr.co.blueauction.order.domain.Orders)
	 */
	@Override
	public int ordercount(int productId) throws Exception {
		return ordersDao.ordercount(productId);
	}
}
