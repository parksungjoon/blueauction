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

/**
 * 입찰 데이터베이스 접근 및 갱신
 * @author 김수진
 * @author 박성준
 * @author 김봉환
 * @since 2017. 11. 15.
 */
@Repository
public class MybatisBidDao implements BidDao {

	@Inject
	private SqlSession sqlSession;

	private static final String NAMESPACE = "kr.co.blueauction.mapper.bidMapper";

	/* 
	 * 입찰 등록
	 * @parameter Bid 입찰도메인
	 * @see kr.co.blueauction.bid.dao.BidDao#create(kr.co.blueauction.bid.domain.Bid)
	 */
	@Override
	public void create(Bid bid) throws Exception {
		sqlSession.insert(NAMESPACE + ".inset", bid);
	}

	/* 
	 * 입찰 수정
	 * @parameter Bid 입찰도메인
	 * @see kr.co.blueauction.bid.dao.BidDao#create(kr.co.blueauction.bid.domain.Bid)
	 */
	@Override
	public void update(Bid bid) throws Exception {
		sqlSession.update(NAMESPACE + ".update", bid);
	}

	/* 
	 * 입찰 삭제
	 * @parameter bidId 입찰번호
	 * @see kr.co.blueauction.bid.dao.BidDao#create(kr.co.blueauction.bid.domain.Bid)
	 */
	@Override
	public void delete(int bidId) throws Exception {
		sqlSession.delete(NAMESPACE + ".delete", bidId);
	}

	/* 
	 * 상품 id로 입찰 조회
	 * @parameter productId 상품 id
	 * @return List<Bid>
	 * @see kr.co.blueauction.bid.dao.BidDao#create(kr.co.blueauction.bid.domain.Bid)
	 */
	@Override
	public List<Bid> readByProductId(int productId) throws Exception {
		return sqlSession.selectList(NAMESPACE + ".readByProductId", productId);
	}

	/* 
	 * memberId로 입찰 조회
	 * @parameter memberId 
	 * @return List<Bid>
	 * @see kr.co.blueauction.bid.dao.BidDao#create(kr.co.blueauction.bid.domain.Bid)
	 */
	@Override
	public List<Bid> readByMemberId(String memberId) throws Exception {
		return sqlSession.selectList(NAMESPACE + ".readByMemberId", memberId);
	}

	/* 
	 * 회원아이디로 입찰 조회
	 * @parameter memberId 
	 * @parameter winning 
	 * @return List<Bid>
	 * @see kr.co.blueauction.bid.dao.BidDao#create(kr.co.blueauction.bid.domain.Bid)
	 */
	@Override
	public List<Bid> bidList(String memberId, String winning) throws Exception {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("memberId", memberId);
		map.put("winning", winning);
		return sqlSession.selectList(NAMESPACE + ".bidList", map);

	}

	/* 
	 * 회원아이디로 입찰 조회 - 페이징
	 * @parameter Criteria 페이지 처리에 관련된 객체
	 * @parameter memberId 
	 * @parameter winning 
	 * @return List<Bid>
	 * @see kr.co.blueauction.bid.dao.BidDao#create(kr.co.blueauction.bid.domain.Bid)
	 */
	@Override
	public List<Bid> bidListCriteria(Criteria cri, String memberId, String winning) throws Exception{
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("memberId", memberId);
		map.put("winning", winning);
		map.put("cri", cri);
		
		return sqlSession.selectList(NAMESPACE + ".bidListCriteria", map);
	}
			
	/* 
	 * 회원 아이디로 입찰목록중 가장 적게 남은경매 시간 조회
	 * @parameter memberId 
	 * @return String 경매 시간 반환
	 * @see kr.co.blueauction.bid.dao.BidDao#create(kr.co.blueauction.bid.domain.Bid)
	 */
	@Override
	public String leastTime(String memberId) throws Exception {
		return sqlSession.selectOne(NAMESPACE + ".leastTime", memberId);
	}

	/* 
	 * 경매 낙찰자 아이디 및 상품번호 조회
	 * @return List<Bid>
	 * @see kr.co.blueauction.bid.dao.BidDao#create(kr.co.blueauction.bid.domain.Bid)
	 */
	@Override
	public List<Bid> selectWinningList() {
		return sqlSession.selectList(NAMESPACE + ".winningList");
	}

	/* 
	 * 낙찰자 리스트로 winningstate 변경
	 * @parameter winningList 
	 * @see kr.co.blueauction.bid.dao.BidDao#create(kr.co.blueauction.bid.domain.Bid)
	 */
	@Override
	public void updateWinning(List<Bid> winningList) {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("winningList", winningList);
		sqlSession.update(NAMESPACE + ".updateWinning", map);

	}

	/* 
	 * 회원 아이디의 입찰 수
	 * @parameter memberId, winning
	 * @return int 
	 * @see kr.co.blueauction.bid.dao.BidDao#create(kr.co.blueauction.bid.domain.Bid)
	 */
	@Override
	public int bidcount(String memberId, String winning) throws Exception{
		Map<String, Object> map=new HashMap<String, Object>();
		map.put("memberId", memberId);
		map.put("winning", winning);
		return sqlSession.selectOne(NAMESPACE + ".countPaging", map);
		
		
	}

	/* 
	 * 경매 결재시 최고가 조회
	 * @parameter productId
	 * @return int
	 * @see kr.co.blueauction.bid.dao.BidDao#create(kr.co.blueauction.bid.domain.Bid)
	 */
	@Override
	public int getMaxPrice(int productId) {
		return sqlSession.selectOne(NAMESPACE + ".maxBidPrice", productId);
	}
}
