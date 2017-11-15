/**
 * Copyright(c) 2017, BlueAuction. All right reserved
 * @author 김수진
 * @since 2017. 11. 15.
 */
package kr.co.blueauction.bid.dao;

import java.util.List;

import kr.co.blueauction.bid.domain.Bid;

/**
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
}
