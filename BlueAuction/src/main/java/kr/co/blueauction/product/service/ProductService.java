package kr.co.blueauction.product.service;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.ui.Model;

import kr.co.blueauction.common.domain.Criteria;
import kr.co.blueauction.common.domain.SearchCriteria;
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
	public void modify(Product product) throws Exception;
	
	/** {요청 페이지,  페이지당 출력 게시글 수, 검색 종류, 검색 값, 카테고리}에 대한 결과 조회 */
	public List<Product> listByCri(SearchCriteria cri, int type, String arrayType) throws Exception;
	
	/** 검색 조건에 따른 전체 상품 리스트 수 */
	public int listBySearchCount(SearchCriteria cri, int type) throws Exception;
	
	/** 스케줄러 - 경매상태 변경 */
	public void updateAuctionsatate() throws Exception;
	
	/** 로그인된 회원의 중고or옥션 판매 물품 리스트를 조회 */
	public List<Product> productSellList(String memberId, String auctionFlag) throws Exception;

	/** 로그인된 회원의 중고or옥션 판매 물품 리스트를 조회 */
	public List<Product> productSellListCriteria(Criteria cri, String memberId, String auctionFlag) throws Exception;

	
	
	public int listCountCriteria(String memberId, String auctionFlag) throws Exception;

	/** 로그인 회원 아이디 조회 */
	public String memberIdGet(HttpSession session) throws Exception;
	
	/** 경매 페이지 SearchCriteria 설정 */
	public SearchCriteria setCri(int smallid, int page, String keyword) throws Exception;
	
	/** 경매 리스트 마지막 페이지인지 여부 조회 */
	public String checkEndPage(SearchCriteria cri,  int totalCount) throws Exception;
	
	/** 중고 상품 리스트 출력 */
	public Model listUsedItems(Model model) throws Exception;
	
	/** 중고 상품 리스트 더 보기 */
	public Map<String, Object> getMoreList(int page, String keyword) throws Exception;
	
	/** 중고 상품 상세 조회 */
	public Model getDetail(int productId, Model model) throws Exception;
	
	/** 중고 or  경매의 최근 등록된 4개의 리스트 조회 */
	public List<Product> recentList(int category) throws Exception;
}
