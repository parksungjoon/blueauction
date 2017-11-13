package kr.co.blueauction.favorite.dao;

import java.util.List;

import kr.co.blueauction.favorite.domain.Favorite;

/**
 * Copyright(c) 2017, BlueAuction. All right reserved
 * 
 * @author 김수진
 * @since 2017-11-13
 */
public interface FavoriteDao {

	/** 관심물품 등록 */
	public void insert(Favorite favorite);

	/** 맴버별 관심물품 반환 */
	public List<Favorite> readByMemberId(String memberId);

	/** 물품아이디로 물품 반환 */
	public List<Favorite> readByProductId(int productId);

	/** 관심물품 삭제 */
	public void delete(int favoriteId);
}
