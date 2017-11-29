package kr.co.blueauction.favorite.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import kr.co.blueauction.favorite.domain.Favorite;
/**
 * Copyright(c) 2017, BlueAuction. All right reserved
 * 
 * @author 김수진
 * @since 2017-11-13
 */
@Repository
public class MybatisFavoriteDao implements FavoriteDao{
	
	@Inject
	private SqlSession sqlSession;
	
	private static final String NAMESPACE = "kr.co.blueauction.mapper.favoriteMapper";

	@Override
	public void insert(Favorite favorite) {
		sqlSession.insert(NAMESPACE+".insert", favorite);
	}

	@Override
	public List<Favorite> readByMemberId(String memberId) {
		return sqlSession.selectList(NAMESPACE+".readByMemberId", memberId);
	}

	@Override
	public List<Favorite> readByProductId(int productId) {
		return sqlSession.selectList(NAMESPACE+".readByProductId", productId);
	}

	@Override
	public void delete(Favorite favorite) {
		sqlSession.delete(NAMESPACE+".delete", favorite);
	}
	
	@Override
	public void deleteByProductId(int productId) {
		sqlSession.delete(NAMESPACE+".deleteByProductId", productId);
	}
	
	
	@Override
	public Favorite favoriteCheck(Favorite favorite) {
		return sqlSession.selectOne(NAMESPACE + ".favoriteCheck", favorite);
	}

	@Override
	public Favorite readByMemberProduct(String memberId, int productId) {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("memberId", memberId);
		map.put("productId", productId);
		
		return sqlSession.selectOne(NAMESPACE+".readByMemberProduct", map);
	}
}
