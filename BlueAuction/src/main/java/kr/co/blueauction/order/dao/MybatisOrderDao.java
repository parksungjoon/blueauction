package kr.co.blueauction.order.dao;

import java.util.List;

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
}
