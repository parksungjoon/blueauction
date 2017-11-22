package kr.co.blueauction.favorite.service;

import java.util.List;

import kr.co.blueauction.favorite.domain.Favorite;

/**
 * 관심경매 등록 위한 Service
 *
 * @author 정지현
 * @since 2017. 11. 20.
 *
 */
public interface FavoriteService {
	
	/** 관심물품 등록 */
	public void insert(Favorite favorite);
	
	/** 맴버별 관심물품 반환 */
	public List<Favorite> readByMemberId (String memberId);
	
	/** 물품아이디로 물품 반환 */
	public List<Favorite> readByProductId(int productId);
	
	/** 관심물품 삭제 */
	public void delete(Favorite favorite);
	
	/** 관심물품 여부 조회 */
	public String favoriteInsertOrDelete(Favorite favorite);
}
