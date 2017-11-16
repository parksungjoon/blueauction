/**
 * Copyright(c) 2017, BlueAuction. All right reserved
 * @author 김수진
 * @since 2017. 11. 15.
 */
package kr.co.blueauction.bid.dao;

import java.util.List;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import kr.co.blueauction.bid.domain.Bid;

@Repository
public class MybatisBidDao implements BidDao{

	@Inject
	private SqlSession sqlSession;
	
	private static final String NAMESPACE = "kr.co.blueauction.mapper.bidMapper";

	@Override
	public void create(Bid bid) throws Exception {
		sqlSession.insert(NAMESPACE+".inset", bid);
	}

	@Override
	public void update(Bid bid) throws Exception {
		sqlSession.update(NAMESPACE+".update", bid);
	}

	@Override
	public void delete(int bidId) throws Exception {
		sqlSession.delete(NAMESPACE+".delete", bidId);
	}

	@Override
	public List<Bid> readByProductId(int productId) throws Exception {
		return sqlSession.selectList(NAMESPACE+".readByProductId", productId);
	}

	@Override
	public List<Bid> readByMemberId(String memberId) throws Exception {
		return sqlSession.selectList(NAMESPACE+".readByMemberId", memberId);
	}
}
