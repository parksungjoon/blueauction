/**
 * Copyright(c) 2017, BlueAuction. All right reserved
 * @author 김수진
 * @author 정지현
 * @since 2017. 11. 20.
 */
package kr.co.blueauction.favorite.service;

import java.util.List;

import kr.co.blueauction.favorite.domain.Favorite;

/**
 * 관심경매를 위한 Service interface
 * @author 정지현
 * @author 김수진
 * @since 2017. 11. 20.
 */
public interface FavoriteService {
	
	/** 관심물품 등록 */
	public void insert(Favorite favorite);
	
	/** 멤버아이디로 관심물품 조회 */
	public List<Favorite> readByMemberId (String memberId);
	
	/** 멤버아이디, 물품번호로  관심물품 반환 */
	public Favorite readByMemberProduct (String memberId, int productId);
	
	/** 물품아이디로 물품 조회 */
	public List<Favorite> readByProductId(int productId);
	
	/** 관심물품 삭제 */
	public void delete(Favorite favorite);
	
	/** 관심물품 여부 조회 */
	public String favoriteInsertOrDelete(Favorite favorite);
}
