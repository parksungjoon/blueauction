/**
 * Copyright(c) 2017, BlueAuction. All right reserved
 * @author 김수진
 * @since 2017. 11. 15.
 */
package kr.co.blueauction.bid.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import kr.co.blueauction.bid.domain.Bid;
import kr.co.blueauction.common.domain.Criteria;

/**
 * BID  데이터 베이스 인터페이스
 * @author 김수진
 * @since 2017. 11. 15.
 */
public interface BidDao {

	// bid등록
	public void create(Bid bid) throws Exception;
	
	//bid 수정
	public void update(Bid bid) throws Exception;
	
	//상품 id로 조회
	public List<Bid> readByProductId(int productId) throws Exception;
	
	// 회원id로 조회
	public List<Bid> readByMemberId(String memberId) throws Exception;
	
	// bid 삭제 
	public void delete(int bidId) throws Exception;
	
	//해당 아이디 bid 조회 페이징
	public List<Bid> bidListCriteria(Criteria cri, String memberId, String winning) throws Exception;
			
	//해당 아이디 bid count
	public int bidcount(String memberId, String winning) throws Exception;
	
	/* 해당 아이디의 가장 적은 시간 남은 경매 시간 조회 */
	public String leastTime(String memberId) throws Exception;

	/*경매 낙찰자 아이디 및 상품번호 조회*/
	public List<Bid> selectWinningList();
	
	/*winningstate 변경*/
	public void updateWinning(List<Bid> winningList);

	/*경매 결재시 최고가 조회*/
	public int getMaxPrice(int productId);
	
}
