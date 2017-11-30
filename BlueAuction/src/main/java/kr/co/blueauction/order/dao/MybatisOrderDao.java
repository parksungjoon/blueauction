/**
 * Copyright(c) 2017, BlueAuction. All right reserved
 * @author 김봉환
 * @since 2017. 11. 15.
 */
package kr.co.blueauction.order.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import kr.co.blueauction.common.domain.Criteria;
import kr.co.blueauction.order.domain.Orders;

/**
 * 중고, 옥션 물품 구매를위한 Order Dao
 * 
 * @author 김봉환
 * @since 2017. 11. 15
 */
@Repository
public class MybatisOrderDao implements OrdersDao{

	@Inject
	private SqlSession sqlSession;
	
	private static final String NAMESPACE = "kr.co.blueauction.mapper.ordersMapper";

	/**
	 * 주문 등록
	 * 
	 * @param orders
	 * @see kr.co.blueauction.order.service.OrderService#insert(kr.co.blueauction.order.domain.Orders)
	 */
	@Override
	public void insert(Orders orders) {
		sqlSession.insert(NAMESPACE+".insert", orders);
	}

	/**
	 * 주문 리스트 조회
	 * 
	 * @return
	 * @see kr.co.blueauction.order.service.OrderService#insert(kr.co.blueauction.order.domain.Orders)
	 */
	@Override
	public List<Orders> listAll() {
		return sqlSession.selectList(NAMESPACE+".listAll");
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
		return sqlSession.selectOne(NAMESPACE+".readByno", orderNo);
	}

	/**
	 * 주문 수정
	 * 
	 * @param orders
	 * @see kr.co.blueauction.order.service.OrderService#insert(kr.co.blueauction.order.domain.Orders)
	 */
	@Override
	public void update(Orders orders) {
		sqlSession.update(NAMESPACE+".update", orders);
	}
	
	/**
	 * 주문 수정
	 * 
	 * @param orderId
	 * @see kr.co.blueauction.order.service.OrderService#insert(kr.co.blueauction.order.domain.Orders)
	 */	
	@Override
	public void update(int orderId) throws Exception{
		 sqlSession.update(NAMESPACE+".payupdate", orderId);
	}

	/**
	 * 주문 삭제
	 * 
	 * @param orderNo
	 * @see kr.co.blueauction.order.service.OrderService#insert(kr.co.blueauction.order.domain.Orders)
	 */
	@Override
	public void delete(int orderNo) {
		sqlSession.delete(NAMESPACE+".delete", orderNo);
	}
	
	/**
	 * 로그인된 회원의 중고or 옥션 구매 리스트를 조회
	 * 
	 * @param orderNo
	 * @return
	 * @see kr.co.blueauction.order.service.OrderService#insert(kr.co.blueauction.order.domain.Orders)
	 */
	@Override
	public List<Orders> orderList(String memberId, String auctionFlag) throws Exception{
		Map<String, Object> map=new HashMap<String, Object>();
		map.put("memberId", memberId);
		map.put("auctionFlag", auctionFlag);
		return sqlSession.selectList(NAMESPACE+".orderList", map);
	}

	/**
	 * 로그인된 회원의 중고or 옥션 구매 리스트를 조회 -페이지
	 * 
	 * @param orderNo
	 * @return
	 * @see kr.co.blueauction.order.service.OrderService#insert(kr.co.blueauction.order.domain.Orders)
	 */
	public List<Orders> orderListCriteria(Criteria cri, String memberId, String auctionFlag) throws Exception{
		Map<String, Object> map=new HashMap<String, Object>();
		map.put("memberId", memberId);
		map.put("auctionFlag", auctionFlag);
		map.put("cri", cri);
		
		return sqlSession.selectList(NAMESPACE+".orderListCriteria", map);
	}
	
	/**
	 * 회원 아이디로 페이지 조회
	 * 
	 * @param memberId
	 * @param auctionFlag
	 * @return
	 * @see kr.co.blueauction.order.service.OrderService#insert(kr.co.blueauction.order.domain.Orders)
	 */
	public int countPaging(String memberId, String auctionFlag) throws Exception{
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("memberId", memberId);
		map.put("auctionFlag", auctionFlag);
		return sqlSession.selectOne(NAMESPACE+".countPaging", map);
	}
	
	/**
	 * 주문번호로 주문가저오기
	 * 
	 * @param orderId
	 * @return
	 * @see kr.co.blueauction.order.service.OrderService#insert(kr.co.blueauction.order.domain.Orders)
	 */
	@Override
	public Orders readByOrderId(int orderId) throws Exception{
		return sqlSession.selectOne(NAMESPACE+".orderselect", orderId);
	}

	/**
	 * 상품번호로 주문가저오기
	 * 
	 * @param productId
	 * @return
	 * @see kr.co.blueauction.order.service.OrderService#insert(kr.co.blueauction.order.domain.Orders)
	 */
	@Override
	public Orders readByProductId(int productId) throws Exception{
		return sqlSession.selectOne(NAMESPACE+".searchorder", productId);
	}
	
	/**
	 * 해당상품의 주문 개수
	 * 
	 * @param productId
	 * @return
	 * @see kr.co.blueauction.order.service.OrderService#insert(kr.co.blueauction.order.domain.Orders)
	 */
	public int ordercount(int productId) throws Exception{
		return sqlSession.selectOne(NAMESPACE+".ordercount", productId);
	}
}
