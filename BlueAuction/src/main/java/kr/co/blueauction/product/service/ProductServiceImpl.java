package kr.co.blueauction.product.service;

import java.util.List;

import javax.inject.Inject;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import kr.co.blueauction.common.domain.SearchCriteria;
import kr.co.blueauction.photo.dao.PhotoDao;
import kr.co.blueauction.photo.domain.Photo;
import kr.co.blueauction.product.dao.ProductDao;
import kr.co.blueauction.product.domain.Product;

@Service
public class ProductServiceImpl implements ProductService {

	Logger logger = LoggerFactory.getLogger(ProductServiceImpl.class);
	
	@Inject
	ProductDao productDao;
	@Inject
	PhotoDao photoDao;

	@Override
	public void create(Product product) throws Exception {
		
		productDao.create(product);
		
		String[] files = product.getPhoto();
		
		if (files != null) {
			for (String photoName : files) {
				productDao.addAttach(photoName, product.getProductId());
			}
		}
		
	}

	@Override
	public List<Product> listAll(String flag) throws Exception {
		return productDao.listAll(flag);
	}

	@Override
	public Product read(int productId) throws Exception {
		Product product = productDao.read(productId);

		List<Photo> photoList = photoDao.readByProductId(productId);
		String[] photoArr = null;
		if (photoList.size() > 0) {
			photoArr = new String[photoList.size()];

			for (int i = 0; i < photoArr.length; i++) {
				photoArr[i] = photoList.get(i).getPhotoname();
			}
		}
		
		if(photoArr != null){
			product.setPhoto(photoArr);
		}
		
		return product;
	}

	@Override
	public void delete(int productId) throws Exception {
		photoDao.deleteByproductId(productId);
		productDao.delete(productId);
	}

	@Override
	public List<Product> listByCri(SearchCriteria cri, int type) throws Exception {
		return productDao.listByCri(cri, type);
	}

	@Override
	public int listBySearchCount(SearchCriteria cri, int type) throws Exception {
		return productDao.listBySearchCount(cri, type);
	}

	@Override
	public void updateAuctionsatate() throws Exception {
		productDao.updateAuctionsatate();
	}

	@Override
	public List<Product> productSellList(String memberId, String auctionFlag) throws Exception {
		List<Product> productList = productDao.productSellList(memberId, auctionFlag);
		System.out.println("해당아이디에 상품리스트"+productList.toString());

		if (productList.size() > 0) {
			for (int i = 0; i < productList.size(); i++) {
				if (productList.get(i) != null) {
					int productId = productList.get(i).getProductId();
					System.out.println("productList.get(" + i + ").getProductId()" + String.valueOf(productId));

					List<Photo> photoList = photoDao.readByProductId(productId);
					String[] photoArr = null;
					if (photoList.size() > 0) {
						photoArr = new String[photoList.size()];

						for (int j = 0; j < photoArr.length; j++) {
							photoArr[j] = photoList.get(j).getPhotoname();
							System.out.println(photoArr[j]);
						}
						
					}
					
					productList.get(i).setPhoto(photoArr);
				
					
				//	System.out.println("photoarray : " +photoarray);
				}
			}
		}

		return productList;
	}
}
