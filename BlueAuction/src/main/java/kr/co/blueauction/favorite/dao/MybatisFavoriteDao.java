/**
 * Copyright(c) 2017, BlueAuction. All right reserved
 * @author 김수진
 * @since 2017. 11. 13.
 */
package kr.co.blueauction.favorite.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import kr.co.blueauction.favorite.domain.Favorite;


/**
 * 관심상품관련 데이터베이스
 * @author 김수진
 * @since 2017. 11. 13.
 */
@Repository
public class MybatisFavoriteDao implements FavoriteDao{
	
	@Inject
	private SqlSession sqlSession;
	
	private static final String NAMESPACE = "kr.co.blueauction.mapper.favoriteMapper";

	/* 
	 * 관심경매 등록
	 * @parameter Favorite
	 * @see kr.co.blueauction.favorite.dao.FavoriteDao#insert(kr.co.blueauction.favorite.domain.Favorite)
	 */
	@Override
	public void insert(Favorite favorite) {
		sqlSession.insert(NAMESPACE+".insert", favorite);
	}

	/* 
	 * 회원 아이디로 관심경매 조회
	 * @parameter String 회원 아이디
	 * @return List<Favorite>
	 * @see kr.co.blueauction.favorite.dao.FavoriteDao#insert(kr.co.blueauction.favorite.domain.Favorite)
	 */
	@Override
	public List<Favorite> readByMemberId(String memberId) {
		return sqlSession.selectList(NAMESPACE+".readByMemberId", memberId);
	}

	/* 
	 * 상품번호로 관심경매 조회
	 * @parameter int 상품번호
	 * @return List<Favorite>
	 * @see kr.co.blueauction.favorite.dao.FavoriteDao#insert(kr.co.blueauction.favorite.domain.Favorite)
	 */
	@Override
	public List<Favorite> readByProductId(int productId) {
		return sqlSession.selectList(NAMESPACE+".readByProductId", productId);
	}

	/* 
	 * 관심경매 삭제
	 * @parameter Favorite
	 * @see kr.co.blueauction.favorite.dao.FavoriteDao#insert(kr.co.blueauction.favorite.domain.Favorite)
	 */
	@Override
	public void delete(Favorite favorite) {
		sqlSession.delete(NAMESPACE+".delete", favorite);
	}
	
	/* 
	 * 상품번호로 관심경매 삭제
	 * @parameter int 상품번호
	 * @see kr.co.blueauction.favorite.dao.FavoriteDao#insert(kr.co.blueauction.favorite.domain.Favorite)
	 */
	@Override
	public void deleteByProductId(int productId) {
		sqlSession.delete(NAMESPACE+".deleteByProductId", productId);
	}
	
	/* 
	 * 관심물품 여부 조회
	 * @parameter Favorite
	 * @return Favorite
	 * @see kr.co.blueauction.favorite.dao.FavoriteDao#insert(kr.co.blueauction.favorite.domain.Favorite)
	 */
	@Override
	public Favorite favoriteCheck(Favorite favorite) {
		return sqlSession.selectOne(NAMESPACE + ".favoriteCheck", favorite);
	}

	/* 
	 * 회원아이디와 물품번호로 관심경매 조회
	 * @parameter memberId, productId
	 * @return Favorite
	 * @see kr.co.blueauction.favorite.dao.FavoriteDao#insert(kr.co.blueauction.favorite.domain.Favorite)
	 */
	@Override
	public Favorite readByMemberProduct(String memberId, int productId) {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("memberId", memberId);
		map.put("productId", productId);
		
		return sqlSession.selectOne(NAMESPACE+".readByMemberProduct", map);
	}
}
