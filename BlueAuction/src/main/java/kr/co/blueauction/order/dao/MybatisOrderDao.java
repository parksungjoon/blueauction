package kr.co.blueauction.order.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;


import kr.co.blueauction.order.domain.Orders;

@Repository
public class MybatisOrderDao implements OrdersDao{

	@Inject
	private SqlSession sqlSession;
	
	private static final String NAMESPACE = "kr.co.blueauction.mapper.ordersMapper";

	@Override
	public void insert(Orders orders) {
		sqlSession.insert(NAMESPACE+".insert", orders);
	}

	@Override
	public List<Orders> listAll() {
		return sqlSession.selectList(NAMESPACE+".listAll");
	}

	@Override
	public Orders readByNo(int orderNo) {
		return sqlSession.selectOne(NAMESPACE+".readByno", orderNo);
	}

	@Override
	public void update(Orders orders) {
		sqlSession.update(NAMESPACE+".update", orders);
	}

	@Override
	public void delete(int orderNo) {
		sqlSession.delete(NAMESPACE+".delete", orderNo);
	}
	/** 로그인된 회원의 구매 리스트를 조회 */
	@Override
	public List<Orders> orderList(String memberId, String auctionFlag) throws Exception{
		Map<String, Object> map=new HashMap<String, Object>();
		map.put("memberId", memberId);
		map.put("auctionFlag", auctionFlag);
		return sqlSession.selectList(NAMESPACE+".orderList", map);
	}
	
	/** 주문번호로 주문가저오기**/
	@Override
	public Orders select(int orderId) throws Exception{
		return sqlSession.selectOne(NAMESPACE+".orderselect", orderId);
	}
	
	/**결제하기**/
	@Override
	public void update(int orderId) throws Exception{
		 sqlSession.update(NAMESPACE+".payupdate", orderId);
	}
}
