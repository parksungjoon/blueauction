package kr.co.blueauction.product.dao;

import java.util.List;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import kr.co.blueauction.product.domain.Product;

@Repository
public class MybatisProductDao implements ProductDao {
	
	private static final String namespace="kr.co.blueauction.product.dao.ProductDao";
	
	@Inject
	private SqlSession sqlSession;
	
	/** 상품 등록 */
	@Override
	public void create(Product product) throws Exception {
		
	}
	
	/** 전체 상품 리스트 조회 */
	@Override
	public List<Product> listAll(String flag) throws Exception {
		return null;
	}
	
	/** 상품 아이디에 따른 상품 조회 */
	@Override
	public Product read(int productId) throws Exception {
		return null;
	}
	
	/** 상품 삭제 */
	@Override
	public void delete(int productId) throws Exception {
		
	}
	
	/** 상품 수정 */
	@Override
	public void update(Product product) throws Exception {
		
	}
	
}
