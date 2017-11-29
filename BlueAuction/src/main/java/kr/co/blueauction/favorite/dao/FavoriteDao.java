/**
 * Copyright(c) 2017, BlueAuction. All right reserved
 * @author 김수진
 * @since 2017. 11. 13.
 */
package kr.co.blueauction.favorite.dao;

import java.util.List;

import kr.co.blueauction.favorite.domain.Favorite;

/**
 * 관심상품관련 데이터베이스 interface
 * @author 김수진
 * @since 2017. 11. 13.
 */
public interface FavoriteDao {

	/** 관심물품 등록 */
	public void insert(Favorite favorite);

	/** 멤버별 관심물품 반환 */
	public List<Favorite> readByMemberId(String memberId);
	
	/** 멤버,상품에따른 관심물품 반환 */
	public Favorite readByMemberProduct(String memberId, int productId);

	/** 물품아이디로 물품 반환 */
	public List<Favorite> readByProductId(int productId);

	/** 관심물품 삭제 */
	public void delete(Favorite favorite);
	public void deleteByProductId(int productId);
	
	/** 관심물품 여부 조회*/
	public Favorite favoriteCheck(Favorite favorite);
}
