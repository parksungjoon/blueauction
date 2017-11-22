package kr.co.blueauction.favorite.service;

import java.util.List;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Service;

import kr.co.blueauction.favorite.dao.FavoriteDao;
import kr.co.blueauction.favorite.domain.Favorite;

@Service
public class FavoriteServiceImpl implements FavoriteService {
	
	@Inject
	private FavoriteDao favoriteDao;
	
	@Override
	public void insert(Favorite favorite) {
		favoriteDao.insert(favorite);
	}

	@Override
	public List<Favorite> readByMemberId(String memberId) {
		return favoriteDao.readByMemberId(memberId);
	}

	@Override
	public List<Favorite> readByProductId(int productId) {
		return favoriteDao.readByProductId(productId);
	}

	@Override
	public void delete(Favorite favorite) {
		favoriteDao.delete(favorite);
	}
	
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
}
