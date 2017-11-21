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
	
	/** 로그인된 회원의 중고or 옥션 구매 리스트를 조회 **/
	public List<Orders> orderList(String memberId, String auctionFlag) throws Exception;
	/** 주문번호로 주문가저오기**/
	public Orders select(int orderId) throws Exception;
	/** 결제완료업데이트**/
	public void update(int orderId) throws Exception;
}
