/**
 * Copyright(c) 2017, BlueAuction. All right reserved
 * @author 김수진
 * @since 2017. 11. 15.
 */
package kr.co.blueauction.bid.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.sun.mail.imap.protocol.Namespaces.Namespace;

import kr.co.blueauction.bid.domain.Bid;
import kr.co.blueauction.common.domain.Criteria;
import kr.co.blueauction.member.domain.Member;

@Repository
public class MybatisBidDao implements BidDao {

	@Inject
	private SqlSession sqlSession;

	private static final String NAMESPACE = "kr.co.blueauction.mapper.bidMapper";

	@Override
	public void create(Bid bid) throws Exception {
		sqlSession.insert(NAMESPACE + ".inset", bid);
	}

	@Override
	public void update(Bid bid) throws Exception {
		sqlSession.update(NAMESPACE + ".update", bid);
	}

	@Override
	public void delete(int bidId) throws Exception {
		sqlSession.delete(NAMESPACE + ".delete", bidId);
	}

	@Override
	public List<Bid> readByProductId(int productId) throws Exception {
		return sqlSession.selectList(NAMESPACE + ".readByProductId", productId);
	}

	@Override
	public List<Bid> readByMemberId(String memberId) throws Exception {
		return sqlSession.selectList(NAMESPACE + ".readByMemberId", memberId);
	}

	@Override
	// 해당 아이디 bid 조회
	public List<Bid> bidList(String memberId, String winning) throws Exception {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("memberId", memberId);
		map.put("winning", winning);
		return sqlSession.selectList(NAMESPACE + ".bidList", map);

	}
	//해당아이디에 입찰, 낙찰 목록조회
	@Override
	public List<Bid> bidListCriteria(Criteria cri, String memberId, String winning) throws Exception{
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("memberId", memberId);
		map.put("winning", winning);
		map.put("cri", cri);
		return sqlSession.selectList(NAMESPACE + ".bidListCriteria", map);

	}
			
		

	@Override
	public String leastTime(String memberId) throws Exception {
		return sqlSession.selectOne(NAMESPACE + ".leastTime", memberId);
	}

	@Override
	public List<Bid> selectWinningList() {

		return sqlSession.selectList(NAMESPACE + ".winningList");
	}

	@Override
	public void updateWinning(List<Bid> winningList) {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("winningList", winningList);
		sqlSession.update(NAMESPACE + ".updateWinning", map);

	}

	// 해당 아이디 bid count
	@Override
	public int bidcount(String memberId, String winning) throws Exception{
		Map<String, Object> map=new HashMap<String, Object>();
		map.put("memberId", memberId);
		map.put("winning", winning);
		return sqlSession.selectOne(NAMESPACE + ".countPaging", map);
		
		
	}

	@Override
	public int getMaxPrice(int productId) {
		// TODO Auto-generated method stub
		return sqlSession.selectOne(NAMESPACE + ".maxBidPrice", productId);
	}
}
