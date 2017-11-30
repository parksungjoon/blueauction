/**
 * Copyright(c) 2017, BlueAuction. All right reserved
 * @author 김수진
 * @author 정지현
 * @author 최명승
 * @since 2017. 11. 15.
 */
package kr.co.blueauction.product.dao;

import java.util.List;

import kr.co.blueauction.common.domain.Criteria;
import kr.co.blueauction.common.domain.SearchCriteria;
import kr.co.blueauction.product.domain.Product;

/**
 * 상품 관련 Dao interface
 * @author 김수진
 * @author 정지현
 * @author 최명승
 * @since 2017. 11. 15.
 */
public interface ProductDao {
	
	/** 상품 등록 */
	public void create(Product product) throws Exception;
	
	/** 전체 상품 리스트 조회 */
	public List<Product> listAll(String flag)throws Exception;
	
	/** 상품 아이디에 따른 상품 조회 */
	public Product read(int productId)throws Exception;
	
	/** 상품 삭제 */
	public void delete(int productId)throws Exception;
	
	/** 상품 수정 */
	public void update(Product product)throws Exception;
	
	/** {요청 페이지,  페이지당 출력 게시글 수, 검색 종류, 검색 값, 카테고리}에 대한 결과 조회  */
	public List<Product> listByCri(SearchCriteria cri, int type, String arrayType) throws Exception;
	
	/** 검색 조건에 따른 전체 상품 리스트 수 */
	public int listBySearchCount(SearchCriteria cri, int type) throws Exception;
	
	/** 경매 상태 변경 */
	public void updateAuctionsatate() throws Exception;
	
	/**페이징처리 로그인된 회원의 중고판매 물품 리스트를 조회 */
	public List<Product> productSellListCriteria(Criteria criteria, String memberId, String auctionFlag) throws Exception;
	
	public int countPaging(String memberId, String auctionFlag) throws Exception;
	
	
	/** 중고상품 리스트 출력 */
	public List<Product> listUsedItems() throws Exception;
	
	/** 중고 or 경매의 최근 등록된 4개의 리스트 조회 */
	public List<Product> recentList(int category) throws Exception;
	
}
