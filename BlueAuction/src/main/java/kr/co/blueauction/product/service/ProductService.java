package kr.co.blueauction.product.service;

import java.util.List;

import kr.co.blueauction.product.domain.Product;

public interface ProductService {
	
	/** 상품 등록 */
	public void create(Product product) throws Exception;
	
	/** 상품 전체 리스트 조회 */
	public List<Product> listAll(String flag) throws Exception;
	
	/** 아이디에 따른 상품 상세 조회 */
	public Product read(int productId) throws Exception;
	
	/** 상품 삭제 */
	public void delete(int productId) throws Exception;
	
	/** 상품 수정 */
	/*public void modify(Product product) throws Exception;*/
}
