package kr.co.blueauction;

import javax.inject.Inject;

import org.apache.log4j.Logger;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import kr.co.blueauction.product.dao.ProductDao;

@RunWith(SpringJUnit4ClassRunner.class)	
@ContextConfiguration(locations= {"file:src/main/webapp/WEB-INF/spring/root-context.xml"})
public class ProductDaoTest {
	
	@Inject
	private ProductDao productDao;
	
	Logger logger = Logger.getLogger(ProductDaoTest.class);
	
//	@Test
	public void updateAuction() throws Exception {
		productDao.updateAuctionsatate();
	}

}
