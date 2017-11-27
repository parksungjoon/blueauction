/**
 * Copyright(c) 2017, BlueAuction. All right reserved
 * @author 김수진
 * @since 2017. 11. 15.
 */
package kr.co.blueauction.bid.service;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;

import kr.co.blueauction.bid.domain.Bid;
import kr.co.blueauction.common.domain.Criteria;

@Service
public interface BidService {
	// bid등록
	public void create(Bid bid) throws Exception;

	// bid 수정
	public void update(Bid bid) throws Exception;

	// 상품 id로 조회
	public List<Bid> readByProductId(int productId) throws Exception;

	// 회원id로 조회
	public List<Bid> readByMemberId(String memberId) throws Exception;

	// bid 삭제
	public void delete(int bidId) throws Exception;
	
	//해당아이디에 입찰, 낙찰 목록조회
	public Map<String, Object> bidList(String memberId, String winning) throws Exception;
	
	
	//해당아이디에 입찰, 낙찰 목록조회 패이징
	public Map<String, Object> bidListCriteria(Criteria cri, String memberId, String winning) throws Exception;
		
		
	/* 해당아이디에 입찰 리스트 수 */
	public int bidCountCriteria(String memberId, String winning) throws Exception;
	
	
	/* 해당아이디의 가장 적은 시간 남은 경매 시간 조회 */
	public String leastTime(String memberId) throws Exception;
	
	/*각 상품당 낙찰자, 상품id 값을 조회*/
	public List<Bid> selectWinningList();
	
	/*낙찰 결과 업데이트*/
	public void updateWinning(List<Bid> winningList);
	
	/*해당 물건의 최고 입찰가를 가져온다.*/
	public int getMaxPrice(int productId);
}
