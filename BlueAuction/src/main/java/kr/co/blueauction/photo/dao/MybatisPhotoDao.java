/**
 * Copyright(c) 2017, BlueAuction. All right reserved
 * @author 김수진
 * @since 2017. 11. 15.
 */
package kr.co.blueauction.photo.dao;

import java.util.List;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import kr.co.blueauction.bid.domain.Bid;
import kr.co.blueauction.photo.domain.Photo;

@Repository
public class MybatisPhotoDao implements PhotoDao{

	@Inject
	private SqlSession sqlSession;
	
	private static final String NAMESPACE = "kr.co.blueauction.mapper.photoMapper";

	@Override
	public void create(Photo photo) throws Exception {
		sqlSession.insert(NAMESPACE+".insert", photo);
	}

	@Override
	public void delete(int photoId) throws Exception {
		sqlSession.delete(NAMESPACE+".delete", photoId);
	}

	@Override
	public List<Photo> readByProductId(int productId) throws Exception {
		return sqlSession.selectList(NAMESPACE+".readByProductId", productId);
	}

	@Override
	public void deleteByproductId(int productId) throws Exception {
		sqlSession.delete(NAMESPACE+".deleteByproductId", productId);
		
	}

}
