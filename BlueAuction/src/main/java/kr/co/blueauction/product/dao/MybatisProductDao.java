package kr.co.blueauction.product.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Repository;
import org.springframework.ui.Model;

import kr.co.blueauction.common.domain.Criteria;
import kr.co.blueauction.common.domain.SearchCriteria;
import kr.co.blueauction.product.domain.Product;

@Repository
public class MybatisProductDao implements ProductDao {
	
	private static final String namespace="kr.co.blueauction.product.dao.ProductDao";
	Logger logger = Logger.getLogger(MybatisProductDao.class);
	
	@Inject
	private SqlSession sqlSession;
	
	/** 상품 등록 */
	@Override
	public void create(Product product) throws Exception {
		sqlSession.insert(namespace + ".create", product);
	}
	
	/** 전체 상품 리스트 조회 */
	@Override
	public List<Product> listAll(String flag) throws Exception {
		return sqlSession.selectList(namespace + ".listAll", flag);
	}
	
	/** 상품 아이디에 따른 상품 조회 */
	@Override
	public Product read(int productId) throws Exception {
		return sqlSession.selectOne(namespace + ".read", productId);
	}
	
	/** 상품 삭제 */
	@Override
	public void delete(int productId) throws Exception {
		sqlSession.delete(namespace + ".delete", productId);
	}
	
	/** 상품 수정 */
	@Override
	public void update(Product product) throws Exception {
		sqlSession.update(namespace + ".update", product);
	}
	
	/** {요청 페이지,  페이지당 출력 게시글 수, 검색 종류, 검색 값, 카테고리}에 대한 결과 조회 */
	@Override
	public List<Product> listByCri(SearchCriteria cri, int type, String arrayType) throws Exception {
		Map<String, Object> paramMap = new HashMap<String, Object>();
		paramMap.put("cri", cri);
		paramMap.put("type", type);
		paramMap.put("arraytype", arrayType);
		
		return  sqlSession.selectList(namespace + ".listByCri", paramMap);
		
	}
	
	/** 검색 조건에 따른 전체 상품 리스트 수 */
	@Override
	public int listBySearchCount(SearchCriteria cri, int type) throws Exception {
		Map<String, Object> paramMap = new HashMap<String, Object>();
		paramMap.put("cri", cri);
		paramMap.put("type", type);
		
		return sqlSession.selectOne(namespace + ".listBySearchCount", paramMap);
	}

	@Override
	public void updateAuctionsatate() throws Exception {
		sqlSession.update(namespace+".updateAuctionsatate");
	}
	
	
	/** 로그인된 회원의 중고판매 물품 리스트를 조회 */
	@Override
	public List<Product> productSellList(String memberId, String auctionFlag) throws Exception{
		Map<String, Object> map=new HashMap<String, Object>();
		map.put("memberId", memberId);
		map.put("auctionFlag", auctionFlag);

	
		return sqlSession.selectList(namespace+".productSellList", map);
	}
	/** 로그인된 회원의 중고판매 물품 리스트를 조회  페이징처리*/
	@Override
	public List<Product> productSellListCriteria(Criteria cri, String memberId, String auctionFlag) throws Exception{
	
		Map<String, Object> map=new HashMap<String, Object>();
		map.put("memberId", memberId);
		map.put("auctionFlag", auctionFlag);
		map.put("cri", cri);
		
		List<Product> products =  sqlSession.selectList(namespace+".productSellListCriteria", map);
		
		return products;
		
	}
	@Override
	public int countPaging(String memberId, String auctionFlag) throws Exception{
		Map<String, Object> map = new HashMap<String, Object>();
		
		map.put("memberId", memberId);
		map.put("auctionFlag", auctionFlag);
		return sqlSession.selectOne(namespace+".countPaging", map);
	}
	
	
	/** 중고 상품 리스트 출력 */
	@Override
	public List<Product> listUsedItems() throws Exception {
		return sqlSession.selectList(namespace + ".listByCri");
	}
	
	/** 중고 or 경매의 최근 등록된 4개의 리스트 조회 */
	@Override
	public List<Product> recentList(int category) throws Exception {
		return sqlSession.selectList(namespace + ".recentList", category);
	}

}