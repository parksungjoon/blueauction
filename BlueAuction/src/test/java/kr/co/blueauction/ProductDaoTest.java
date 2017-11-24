package kr.co.blueauction;

import java.util.List;

import javax.inject.Inject;

import org.apache.log4j.Logger;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import kr.co.blueauction.common.domain.SearchCriteria;
import kr.co.blueauction.product.dao.ProductDao;
import kr.co.blueauction.product.domain.Product;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "file:src/main/webapp/WEB-INF/spring/*.xml" })
public class ProductDaoTest {

	
	@Inject
	private ProductDao productDao;
	
	Logger logger = Logger.getLogger(ProductDao.class);
	
//	@Test
	public void create()throws Exception{
		/*Product product = new Product();
		product.setCategoryId(1);
		product.setSmallid(3);
		product.setSeller("surinim");
		product.setSalemotive("저한테 안맞아서용");
		product.setUsingtime("열흘");
		product.setProductinfo("전자파쩜, 애플, 아이폰7");
		product.setPrice(300000);
		product.setDeliverytype("직거래");*/
		
		Product product = new Product();
		product.setCategoryId(2);
		product.setSmallid(2);
		product.setSeller("surinim");
		product.setSalemotive("저한테 안맞아서용");
		product.setUsingtime("두달");
		product.setProductinfo("m사이즈, 여성, 패딩");
		product.setPrice(20000);
		product.setDeliverytype("택배");
		product.setAuctionFlag("Y");
		product.setAuctionstart("2017-11-15 09:00:00");
		product.setAuctionend("2017-11-15 10:00:00");
		product.setBasicprice(15000);
		product.setAuctionstate("N");
		
		logger.info(product.toString());
		
		productDao.create(product);
		logger.info("잘 등록됨");
	}
	
//	@Test
	public void listAll()throws Exception{
		List<Product> list = productDao.listAll("Y");
		
		for (Product product : list) {
			logger.info(product.toString());
		}
	}
	
//	@Test
	public void read()throws Exception{
		Product product = productDao.read(6);
		logger.info(product.toString());
	}
	
//	@Test
	public void delete()throws Exception{
		productDao.delete(2);
		logger.info("잘 지워짐");
	}
	
//	@Test
	public void update()throws Exception{
		
	}
	
//	@Test
	public void listByCri()throws Exception{
		SearchCriteria cri = new SearchCriteria();
		cri.setPage(2);
		cri.setPerPageNum(3);
		cri.setCategory(2);
		cri.setKeyword("휴대폰케이스");
		
		logger.info(cri.toString());
		List<Product> list = productDao.listByCri(cri, 2, "recent");
		for (Product product : list) {
			logger.info(product.toString()); 
		}
		
		logger.info("잘 수행됨");
	}
	
	@Test
	public void listBySearchCount()throws Exception{
		SearchCriteria cri = new SearchCriteria();
		cri.setCategory(2);
		cri.setSmallid(0);
		
		int count = productDao.listBySearchCount(cri, 1);
		logger.info(count);
		logger.info("잘 수행 됨");
	}
	
}
