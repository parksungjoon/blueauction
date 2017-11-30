/**
 * Copyright(c) 2017, BlueAuction. All right reserved
 * @author 김수진
 * @author 정지현
 * @author 최명승
 * @since 2017. 11. 15.
 */
package kr.co.blueauction.product.service;

import java.io.File;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.StringTokenizer;

import javax.annotation.Resource;
import javax.inject.Inject;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;

import com.google.gson.Gson;

import kr.co.blueauction.common.domain.Criteria;
import kr.co.blueauction.common.domain.PageMaker;
import kr.co.blueauction.common.domain.SearchCriteria;
import kr.co.blueauction.favorite.dao.FavoriteDao;
import kr.co.blueauction.member.domain.Member;
import kr.co.blueauction.photo.dao.PhotoDao;
import kr.co.blueauction.photo.domain.Photo;
import kr.co.blueauction.product.dao.ProductDao;
import kr.co.blueauction.product.domain.Product;

/**
 * 상품 관련 서비스 
 * @author 김수진
 * @author 정지현
 * @author 최명승
 * @since 2017. 11. 15.
 */
@Service
public class ProductServiceImpl implements ProductService {

	Logger logger = LoggerFactory.getLogger(ProductServiceImpl.class);

	@Inject
	ProductDao productDao;
	@Inject
	PhotoDao photoDao;
	@Inject
	FavoriteDao favoriteDao;
	@Resource(name = "uploadPath")
	private String uploadPath;

	/** 
	 * 상품 등록
	 * @param product
	 * @see kr.co.blueauction.product.service.ProductService#create(kr.co.blueauction.product.domain.Product)
	 */
	@Override
	@Transactional
	public void create(Product product) throws Exception {

		if (product.getCategoryId() == 2) {
			// 날짜 형식 변경
			StringTokenizer st = new StringTokenizer(product.getAuctionstart(), "T");
			String auctionstart = st.nextToken() + " " + st.nextToken();
			product.setAuctionstart(auctionstart);
		}

		// <br>처리
		String info = product.getProductinfo().replaceAll("\r\n", "<br>");
		product.setProductinfo(info);

		productDao.create(product);

		String[] files = product.getPhoto();

		if (files != null) {
			for (String photoName : files) {
				Photo photo = new Photo(product.getProductId(), photoName);
				photoDao.create(photo);
			}
		}

	}

	/** 
	 * 상품 전체 리스트 조회
	 * @param flag
	 * @return List<Product>
	 * @see kr.co.blueauction.product.service.ProductService#create(kr.co.blueauction.product.domain.Product)
	 */
	@Override
	public List<Product> listAll(String flag) throws Exception {
		return productDao.listAll(flag);
	}

	/** 
	 * 아이디에 따른 상품 상세 조회 
	 * @param productId
	 * @return Product
	 * @see kr.co.blueauction.product.service.ProductService#create(kr.co.blueauction.product.domain.Product)
	 */
	@Override
	public Product read(int productId) throws Exception {
		Product product = productDao.read(productId);

		List<Photo> photoList = photoDao.readByProductId(productId);

		String[] photoArr = null;
		if (photoList.size() > 0) {
			photoArr = new String[photoList.size()];

			for (int i = 0; i < photoArr.length; i++) {
				String tmp = photoList.get(i).getPhotoname();
				photoArr[i] = tmp.replaceAll("s_", "");
			}
		}

		if (photoArr != null) {
			product.setPhoto(photoArr);
		}
		
		// 개행문자 처리
		product.setProductinfo(product.getProductinfo().replaceAll("<br>", "\r\n"));

		return product;
	}

	/** 
	 * 상품 수정
	 * @param product
	 * @see kr.co.blueauction.product.service.ProductService#create(kr.co.blueauction.product.domain.Product)
	 */
	@Override
	@Transactional
	public void modify(Product product) throws Exception {
		
		if (!product.getAuctionFlag().equals("N")) {
			// 날짜 형식 변경
			StringTokenizer st = new StringTokenizer(product.getAuctionstart(), "T");
			String auctionstart = st.nextToken() + " " + st.nextToken();
			product.setAuctionstart(auctionstart);
		}

		// <br>처리
		String info = product.getProductinfo().replaceAll("\r\n", "<br>");
		product.setProductinfo(info);

		// 사진 삭제
		photoDao.deleteByproductId(product.getProductId());

		// 사진 등록
		String[] files = product.getPhoto();
		if (files != null) {
			for (int i = 0; i < files.length; i++) {
				Photo photo = new Photo(product.getProductId(), files[i]);
				photoDao.create(photo);
			}
		}

		// 상품 수정
		productDao.update(product);
	}

	/** 
	 * 상품 삭제
	 * @param productId
	 * @see kr.co.blueauction.product.service.ProductService#create(kr.co.blueauction.product.domain.Product)
	 */
	@Override
	@Transactional
	public void delete(int productId) throws Exception {
		favoriteDao.deleteByProductId(productId);
		photoDao.deleteByproductId(productId);
		productDao.delete(productId);
	}

	/** 
	 * {요청 페이지,  페이지당 출력 게시글 수, 검색 종류, 검색 값, 카테고리}에 대한 결과 조회
	 * @param cri
	 * @param type
	 * @param arrayType
	 * @return
	 * @see kr.co.blueauction.product.service.ProductService#create(kr.co.blueauction.product.domain.Product)
	 */
	@Override
	public List<Product> listByCri(SearchCriteria cri, int type, String arrayType) throws Exception {
		if (type != 1) {
			arrayType = "recent";
		}

		return productDao.listByCri(cri, type, arrayType);
	}

	/** 
	 * 검색 조건에 따른 전체 상품 리스트 수 
	 * @param cri
	 * @param type
	 * @return
	 * @see kr.co.blueauction.product.service.ProductService#create(kr.co.blueauction.product.domain.Product)
	 */
	@Override
	public int listBySearchCount(SearchCriteria cri, int type) throws Exception {
		return productDao.listBySearchCount(cri, type);
	}

	/** 
	 * 스케줄러 - 경매상태 변경
	 * @see kr.co.blueauction.product.service.ProductService#create(kr.co.blueauction.product.domain.Product)
	 */
	@Override
	public void updateAuctionsatate() throws Exception {
		productDao.updateAuctionsatate();
	}
	
	/** 
	 * 로그인된 회원의 중고or옥션 판매 물품 리스트를 조회 - 페이징
	 * @param memberId
	 * @param auctionFlag
	 * @return
	 * @see kr.co.blueauction.product.service.ProductService#create(kr.co.blueauction.product.domain.Product)
	 */
	@Override
	public Map<String, Object> productSellListCriteria(Criteria cri, String memberId, String auctionFlag) throws Exception{
		
		Map<String, Object> map= new HashMap<String, Object>();
		map.put("products", productDao.productSellListCriteria(cri, memberId, auctionFlag));
		
		return map;
	}
	
	/**
	 * 회원별 물품 페이지 수
	 * @param memberId
	 * @param auctionFlag
	 * @return
	 * @see kr.co.blueauction.product.service.ProductService#listCountCriteria(java.lang.String, java.lang.String)
	 */
	@Override
	public int listCountCriteria(String memberId, String auctionFlag) throws Exception{
		return productDao.countPaging(memberId, auctionFlag);
	}
	
	/**
	 * 로그인 회원 아이디 조회
	 * @param session
	 * @return
	 * @see kr.co.blueauction.product.service.ProductService#listCountCriteria(java.lang.String, java.lang.String)
	 */
	@Override
	public String memberIdGet(HttpSession session) throws Exception {
		String memberId = null;
		Member member = (Member) session.getAttribute("login");
		if (member == null) {
			member = new Member();
			member.setMemberId("");
		}

		memberId = member.getMemberId();
		return memberId;
	}

	/** 
	 * 경매 SearchCriteria 설정
	 * @param smallid
	 * @param page
	 * @param keyword
	 * @return
	 * @see kr.co.blueauction.product.service.ProductService#listCountCriteria(java.lang.String, java.lang.String)
	 */
	@Override
	public SearchCriteria setCri(int smallid, int page, String keyword) throws Exception {
		SearchCriteria cri = new SearchCriteria();
		cri.setCategory(2); // 카테고리 경매로 set
		cri.setPerPageNum(8); // 페이지당 출력 리스트 개수 설정
		cri.setPage(page);

		if (keyword != null) {
			cri.setKeyword(keyword);
		}

		if (smallid != 0) {
			cri.setSmallid(smallid);
		}

		return cri;
	}

	/** 
	 * 경매 마지막 페이지인지 여부 조회
	 * @param cri
	 * @param totalCount
	 * @return
	 * @see kr.co.blueauction.product.service.ProductService#listCountCriteria(java.lang.String, java.lang.String)
	 */
	@Override
	public String checkEndPage(SearchCriteria cri, int totalCount) throws Exception {
		String check = null;
		int endPage;

		endPage = (int) Math.ceil((double) totalCount / cri.getPerPageNum()); // 마지막 페이지 계산
		if (totalCount == 0) {
			check = "yes";
		} else {
			if (cri.getPage() == endPage) { // 요청페이지가 마지막 페이지면
				check = "yes";
			} else {
				check = "no";
			}
		}

		return check;
	}

	/** 
	 * 중고 상품 리스트 출력
	 * @param model
	 * @return
	 * @see kr.co.blueauction.product.service.ProductService#listCountCriteria(java.lang.String, java.lang.String)
	 */
	@Override
	@Transactional
	public Model listUsedItems(Model model) throws Exception {

		SearchCriteria cri = new SearchCriteria();
		cri.setCategory(1);
		cri.setPerPageNum(9);

		List<Product> list = productDao.listByCri(cri, 0, "recent");

		int count = productDao.listBySearchCount(cri, 0);

		PageMaker pageMaker = new PageMaker();
		pageMaker.setCri(cri);
		pageMaker.setTotalCount(count);

		for (Product product : list) {
			product.setMainphoto(product.getMainphoto().replaceAll("s_", ""));
		}

		Gson gson = new Gson();
		String jsonlist = gson.toJson(list);

		model.addAttribute("list", jsonlist);
		model.addAttribute("count", count);

		return model;
	}

	/** 
	 * 중고 상품 리스트 더 보기
	 * @param cri
	 * @return
	 * @see kr.co.blueauction.product.service.ProductService#listCountCriteria(java.lang.String, java.lang.String)
	 */
	@Override
	@Transactional
	public Map<String, Object> getMoreList(SearchCriteria cri) throws Exception {
		
		// 리스트 조회
		List<Product> list = productDao.listByCri(cri, 0, "recent");
		int count = productDao.listBySearchCount(cri, 0);
		
		// 페이지 계산
		PageMaker pageMaker = new PageMaker();
		pageMaker.setCri(cri);
		pageMaker.setTotalCount(count);
		
		// 썸네일 -> 원본 사진 변경
		for (Product product : list) {
			product.setMainphoto(product.getMainphoto().replaceAll("s_", ""));
		}
		
		Map<String, Object> resultMap = new HashMap<String, Object>();
		resultMap.put("list", list);
		resultMap.put("count", count);
		
		return resultMap;
	};

	/** 
	 * 중고 상품 상세 조회
	 * @param cri
	 * @return
	 * @see kr.co.blueauction.product.service.ProductService#listCountCriteria(java.lang.String, java.lang.String)
	 */
	@Override
	public Model getDetail(int productId, Model model) throws Exception {
		// 상품 정보 및 사진리스트 조회
		Product product = productDao.read(productId);
		List<Photo> photoList = photoDao.readByProductId(productId);

		String[] photoArr = null;
		
		// 파일 크기 계산
		int totalFileSize = 0;
		if (photoList.size() > 0) {
			photoArr = new String[photoList.size()];

			for (int i = 0; i < photoArr.length; i++) {
				String tmp = photoList.get(i).getPhotoname();
				photoArr[i] = tmp.replaceAll("s_", "");
				
				String filePath = uploadPath + photoArr[i];
				File fileInfo = new File(filePath);
				totalFileSize += fileInfo.length();
			}
		}

		// Product 객체에 사진 저장
		if (photoArr != null) {
			product.setPhoto(photoArr);
		}
		
		// 개행문자 처리
		product.setProductinfo(product.getProductinfo().replaceAll("<br>", "\r\n"));

		// json으로 변경
		Gson gson = new Gson();
		String jsonlist = gson.toJson(product);
		String filesSize = gson.toJson(totalFileSize);
		
		model.addAttribute("jsonproduct", jsonlist);
		model.addAttribute("product", product);
		model.addAttribute("filesSize", filesSize);

		return model;
	}

	/** 
	 * 중고 or  경매의 최근 등록된 4개의 리스트 조회
	 * @param category
	 * @return
	 * @see kr.co.blueauction.product.service.ProductService#listCountCriteria(java.lang.String, java.lang.String)
	 */
	@Override
	public List<Product> recentList(int category) throws Exception {
		return productDao.recentList(category);
	}
}
