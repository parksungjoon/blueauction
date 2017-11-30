/**
 * Copyright(c) 2017, BlueAuction. All right reserved
 * @author 김봉환
 * @since 2017. 11. 15.
 */
package kr.co.blueauction.order.dao;

import java.util.List;

import kr.co.blueauction.common.domain.Criteria;
import kr.co.blueauction.order.domain.Orders;

/**
 * 중고, 옥션 물품 구매를위한 Order Dao Interface
 * @author 김봉환
 * @since 2017. 11. 15
 */
public interface OrdersDao {
	/** 주문 등록 */
	public void insert(Orders orders);

	/** 주문 전체 반환 */
	public List<Orders> listAll();

	/** 주문 번호로 주문 반환 */
	public Orders readByNo(int orderNo);

	/** 주문 수정 */
	public void update(Orders orders);

	/** 주문 삭제 */
	public void delete(int orderNo);

	/** 로그인된 회원의 구매 리스트를 조회 */
	public List<Orders> orderList(String memberId, String auctionFlag) throws Exception;

	/** 로그인된 회원의 구매 리스트를 조회 패이징 */
	public List<Orders>orderListCriteria(Criteria cri, String memberId, String auctionFlag)
			throws Exception;
	public int countPaging(String memberId, String auctionFlag) throws Exception;

	/** 주문번호로 주문가저오기 **/
	public Orders readByOrderId(int orderId) throws Exception;
	
	/** 상품명으로 주문항목 가저오기 **/
	public Orders readByProductId(int productId) throws Exception;

	/** 결제완료 업뎃 **/
	public void update(int orderId) throws Exception;
	
	/** 해당상품의 주문 개수 **/
	public int ordercount(int productId) throws Exception;
}
