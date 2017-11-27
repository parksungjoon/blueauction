package kr.co.blueauction.product.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.StringTokenizer;

import javax.inject.Inject;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;

import com.google.gson.Gson;

import kr.co.blueauction.common.domain.PageMaker;
import kr.co.blueauction.common.domain.SearchCriteria;
import kr.co.blueauction.member.domain.Member;
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
	@Transactional
	public void create(Product product) throws Exception {
		
		if(product.getCategoryId() == 2) {
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
				String tmp = photoList.get(i).getPhotoname();
				photoArr[i] = tmp.replaceAll("s_", "");
			}
		}

		if (photoArr != null) {
			product.setPhoto(photoArr);
		}

		return product;
	}

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

	@Override
	@Transactional
	public void delete(int productId) throws Exception {
		photoDao.deleteByproductId(productId);
		productDao.delete(productId);
	}

	@Override
	public List<Product> listByCri(SearchCriteria cri, int type, String arrayType) throws Exception {
		if(type != 1) {
			arrayType = "recent";
		}
		
		return productDao.listByCri(cri, type, arrayType);
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

		if (productList.size() > 0) {
			for (int i = 0; i < productList.size(); i++) {
				if (productList.get(i) != null) {
					int productId = productList.get(i).getProductId();

					List<Photo> photoList = photoDao.readByProductId(productId);
					String[] photoArr = null;
					if (photoList.size() > 0) {
						photoArr = new String[photoList.size()];

						for (int j = 0; j < photoArr.length; j++) {
							photoArr[j] = photoList.get(j).getPhotoname();
						}

					}

					productList.get(i).setPhoto(photoArr);
				}
			}
		}

		return productList;
	}
	/** 로그인 회원 아이디 조회 */
	@Override
	public String memberIdGet(HttpSession session) throws Exception {
		String memberId = null;
		Member member = (Member) session.getAttribute("login");
		if(member == null) {
			member = new Member();
			member.setMemberId("");
		}
		
		memberId = member.getMemberId();
		return memberId;
	}
	
	/** 경매 SearchCriteria 설정 */
	@Override
	public SearchCriteria setCri(int smallid, int page, String keyword) throws Exception {
		SearchCriteria cri = new SearchCriteria();
		cri.setCategory(2); // 카테고리 경매로 set
		cri.setPerPageNum(8); // 페이지당 출력 리스트 개수 설정
		cri.setPage(page);
		
		if(keyword != null) {
			cri.setKeyword(keyword);
		}
		
		if(smallid != 0) {
			cri.setSmallid(smallid);
		}
		
		return cri;
	}
	
	/** 경매 마지막 페이지인지 여부 조회 */
	@Override
	public String checkEndPage(SearchCriteria cri, int totalCount) throws Exception {
		String check = null;
		int endPage;
		
		endPage = (int)Math.ceil((double)totalCount / cri.getPerPageNum()); // 마지막 페이지 계산
		if(totalCount == 0) {
			check = "yes";
		}else {
			if(cri.getPage() == endPage) { // 요청페이지가 마지막 페이지면
				check = "yes";
			}else {
				check = "no";
			}
		}
		
		return check;
	}
	
	/** 중고 상품 리스트 출력 */
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
	
	/** 중고상품 리스트 더 보기 */
	@Override
	@Transactional
	public Map<String, Object> getMoreList(int page, String keyword, int smallid) throws Exception {
		
		SearchCriteria cri = new SearchCriteria();
		cri.setCategory(1);
		cri.setPerPageNum(page);
		cri.setPage(1);
		cri.setSmallid(smallid);
		
		if(keyword != null) {
			cri.setKeyword(keyword);
		}
		
		List<Product> list = productDao.listByCri(cri, 0, "recent");
		for (Product product : list) {
		}
		int count = productDao.listBySearchCount(cri, 0);
		
		PageMaker pageMaker = new PageMaker();
		pageMaker.setCri(cri);
		pageMaker.setTotalCount(count);
		
		for (Product product : list) {
			product.setMainphoto(product.getMainphoto().replaceAll("s_", ""));
		}
		
		Map<String, Object> resultMap = new HashMap<String, Object>();
		resultMap.put("list", list);
		resultMap.put("count", count);
		
		return resultMap;
	};
	
	/** 중고상품 상세 보기 */
	@Override
	public Model getDetail(int productId, Model model) throws Exception {
		
		Product product = productDao.read(productId);

		// 개행처리
		String info = product.getProductinfo().replaceAll("<br>", "\r\n");
		product.setProductinfo(info);
		
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
		
		Gson gson = new Gson();
		String jsonlist = gson.toJson(product);
		
		model.addAttribute("jsonproduct", jsonlist);
		model.addAttribute("product", product);
		
		return model;
	}
	
	/** 중고 or 경매의 최근 등록된 4개의 리스트 조회 */
	@Override
	public List<Product> recentList(int category) throws Exception {
		return productDao.recentList(category);
	}
}
