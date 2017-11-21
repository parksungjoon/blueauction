package kr.co.blueauction.favorite.service;

import java.util.List;

import kr.co.blueauction.favorite.domain.Favorite;

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
	public Favorite favoriteCheck(Favorite favorite);
}
