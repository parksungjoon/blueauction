/**
 * Copyright(c) 2017, BlueAuction. All right reserved
 * @author 김수진
 * @author 정지현
 * @since 2017. 11. 20.
 */
package kr.co.blueauction.favorite.service;

import java.util.List;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Service;

import kr.co.blueauction.favorite.dao.FavoriteDao;
import kr.co.blueauction.favorite.domain.Favorite;

/**
 * 관심경매를 위한 Service
 * @author 정지현
 * @author 김수진
 * @since 2017. 11. 20.
 */
@Service
public class FavoriteServiceImpl implements FavoriteService {
	
	@Inject
	private FavoriteDao favoriteDao;
	
	/* 
	 * 관심물품 등록
	 * @parameter Favorite
	 * @see kr.co.blueauction.favorite.service.FavoriteService#insert(kr.co.blueauction.favorite.domain.Favorite)
	 */
	@Override
	public void insert(Favorite favorite) {
		favoriteDao.insert(favorite);
	}

	/* 
	 * 멤버아이디로 관심물품 조회
	 * @parameter String memberId
	 * @return List<Favorite>
	 * @see kr.co.blueauction.favorite.service.FavoriteService#insert(kr.co.blueauction.favorite.domain.Favorite)
	 */
	@Override
	public List<Favorite> readByMemberId(String memberId) {
		return favoriteDao.readByMemberId(memberId);
	}

	/* 
	 * 물품아이디로 관심물품 조회
	 * @parameter int productId
	 * @return List<Favorite>
	 * @see kr.co.blueauction.favorite.service.FavoriteService#insert(kr.co.blueauction.favorite.domain.Favorite)
	 */
	@Override
	public List<Favorite> readByProductId(int productId) {
		return favoriteDao.readByProductId(productId);
	}

	/* 
	 * 관심물품 삭제
	 * @parameter Favorite
	 * @see kr.co.blueauction.favorite.service.FavoriteService#insert(kr.co.blueauction.favorite.domain.Favorite)
	 */
	@Override
	public void delete(Favorite favorite) {
		favoriteDao.delete(favorite);
	}
	
	/* 
	 * 관심물품 여부 조회
	 * @parameter Favorite
	 * @return Favorite
	 * @see kr.co.blueauction.favorite.service.FavoriteService#insert(kr.co.blueauction.favorite.domain.Favorite)
	 */
	@Override
	public String favoriteInsertOrDelete(Favorite favorite) {
		String result = null;
		Favorite check = null;
		
		check = favoriteDao.favoriteCheck(favorite);
		
		if(check == null) {
			insert(favorite);
			result = "insert";
		}else {
			delete(favorite);
			result = "delete";
		}
		return result;
	}

	/* 
	 * 멤버아이디, 물품번호로  관심물품 반환
	 * @parameter memberId, productId
	 * @return Favorite
	 * @see kr.co.blueauction.favorite.service.FavoriteService#insert(kr.co.blueauction.favorite.domain.Favorite)
	 */
	@Override
	public Favorite readByMemberProduct(String memberId, int productId) {
		return favoriteDao.readByMemberProduct(memberId, productId);
	}
}
