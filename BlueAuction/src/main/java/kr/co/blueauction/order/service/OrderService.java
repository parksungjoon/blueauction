/**
 * Copyright(c) 2017, BlueAuction. All right reserved
 * @author 김봉환
 * @since 2017. 11. 15.
 */
package kr.co.blueauction.order.service;

import java.util.List;
import java.util.Map;

import kr.co.blueauction.common.domain.Criteria;
import kr.co.blueauction.order.domain.Orders;

/**
 * 중고, 옥션 물품 구매를위한 Order Service Interface
 * @author 김봉환
 * @since 2017. 11. 15
 */
public interface OrderService {
	/** 주문 등록 */
	public void insert(Orders orders);
	
	/** 주문 전체 반환 */
	public List<Orders> listAll();
	
	/** 주문 번호로 주문 반환*/
	public Orders readByNo(int orderNo);
	
	/** 주문 수정 */
	public void update(Orders orders);
	/** 결제완료업데이트**/
	public void update(int orderId) throws Exception;
	
	/** 주문 삭제 */
	public void delete(int orderNo);
	
	/** 로그인된 회원의 중고or 옥션 구매 리스트를 조회 페이징**/
	public Map<String, Object> orderListCriteria(Criteria cri, String memberId, String auctionFlag) throws Exception;
	
	/** 회원 아이디로 상품 수 가져오기 */
	public int listCountCriteria(String memberId, String auctionFlag) throws Exception;
	
	/** 주문번호로 주문가저오기**/
	public Orders readByOrderId(int orderId) throws Exception;
	
	/** 상품번호로 주문가저오기**/
	public Orders readByProductId(int productId) throws Exception;
	
	/** 해당상품의 주문 개수 **/
	public int ordercount(int productId) throws Exception;
}
