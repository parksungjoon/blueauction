package kr.co.blueauction.product.service;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import kr.co.blueauction.common.domain.SearchCriteria;
import kr.co.blueauction.photo.dao.PhotoDao;
import kr.co.blueauction.photo.domain.Photo;
import kr.co.blueauction.product.dao.ProductDao;
import kr.co.blueauction.product.domain.Product;

@Service
public class ProductServiceImpl implements ProductService {
	
	@Inject ProductDao productDao;
	@Inject PhotoDao photoDao;
	
	@Override
	public void create(Product product) throws Exception {
		productDao.create(product);
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
		if(photoList.size() > 0) {
			photoArr = new String[photoList.size()];
			
			for (int i = 0; i < photoArr.length; i++) {
				photoArr[i] = photoList.get(i).getPhotoname();
			}
		}
		
		product.setPhoto(photoArr);
		
		return product;
	}
	
	@Override
	public void delete(int productId) throws Exception {
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
	
}
