package kr.co.blueauction.product.dao;

import java.util.List;

import kr.co.blueauction.product.domain.Product;

public interface ProductDao {
	
	/** 상품 등록 */
	public void create(Product product)throws Exception;
	
	/** 전체 상품 리스트 조회 */
	public List<Product> listAll(String flag)throws Exception;
	
	/** 상품 아이디에 따른 상품 조회 */
	public Product read(int productId)throws Exception;
	
	/** 상품 삭제 */
	public void delete(int productId)throws Exception;
	
	/** 상품 수정 */
	public void update(Product product)throws Exception;
}
