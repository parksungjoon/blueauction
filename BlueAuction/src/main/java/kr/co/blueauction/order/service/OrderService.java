package kr.co.blueauction.order.service;

import java.util.List;

import kr.co.blueauction.order.domain.Orders;

public interface OrderService {
	/** 주문 등록 */
	public void insert(Orders orders);
	
	/** 주문 전체 반환 */
	public List<Orders> listAll();
	
	/** 주문 번호로 주문 반환*/
	public Orders readByNo(int orderNo);
	
	/** 주문 수정 */
	public void update(Orders orders);
	
	/** 주문 삭제 */
	public void delete(int orderNo);
}
