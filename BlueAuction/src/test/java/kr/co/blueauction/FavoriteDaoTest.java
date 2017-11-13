package kr.co.blueauction;

import java.util.List;

import javax.inject.Inject;

import org.apache.log4j.Logger;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import kr.co.blueauction.favorite.dao.FavoriteDao;
import kr.co.blueauction.favorite.domain.Favorite;

@RunWith(SpringJUnit4ClassRunner.class)	
@ContextConfiguration(locations= {"file:src/main/webapp/WEB-INF/spring/root-context.xml"})
public class FavoriteDaoTest {
	
	@Inject
	private FavoriteDao favoriteDao;
	
	Logger logger = Logger.getLogger(FavoriteDaoTest.class);
	
//	@Test
	public void testInsert() {
		Favorite favorite = new Favorite("sujin", 1);
		favoriteDao.insert(favorite);
	}
	
//	@Test
	public void textListAll() {
		List<Favorite> list = favoriteDao.readByMemberId("sujin");
		for (Favorite favorite : list) {
			logger.info(favorite);
		}
	}
	
//	@Test
	public void textreadByNo() {
		List<Favorite> list = favoriteDao.readByProductId(1);
		for (Favorite favorite : list) {
			logger.info(favorite);
		}
	}

}
