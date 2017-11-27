package kr.co.blueauction.product.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.inject.Inject;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.google.gson.Gson;

import kr.co.blueauction.bid.domain.Bid;
import kr.co.blueauction.bid.service.BidService;
import kr.co.blueauction.common.domain.SearchCriteria;
import kr.co.blueauction.favorite.dao.FavoriteDao;
import kr.co.blueauction.favorite.domain.Favorite;
import kr.co.blueauction.favorite.service.FavoriteService;
import kr.co.blueauction.member.domain.Member;
import kr.co.blueauction.product.domain.Product;
import kr.co.blueauction.product.service.ProductService;

/**
 * 경매 리스트를 위한 ProductController 
 *
 * @author 정지현
 * @author 김수진
 * @author 최명승
 * 
 * @since 2017. 11. 13.
 */

@Controller
@RequestMapping("/product")
public class ProductController {
	
	private static final Logger logger = Logger.getLogger(AuctionProductController.class);
	
	@Inject
	private ProductService productService;
	
	@Inject 
	private BidService bidSevice;
	
	@Resource(name = "uploadPath")
	private String uploadPath;
	
	@Inject
	FavoriteService favoriteService;
	

	/**
	 * 관심경매 리스트 Get
	 * @param type 경매 타입(경매 시작 전 / 경매 중 / 경매 종료)
	 * @param smallid 카테고리(의류, 잡화, 티켓, 가전제품)
	 * @param model model
	 * @param session session
	 * @return model 리턴
	 * @throws Exception
	 */
	@RequestMapping(value = "/auction/{type}/{smallid}", method = {RequestMethod.GET, RequestMethod.DELETE})
	public String listPageGet(@PathVariable("type") int type, @PathVariable("smallid") int smallid, Model model, HttpSession session)throws Exception{
		Map<String, Object> map = listGet(type, smallid, session);
		
		model.addAttribute("endpage", map.get("endpage"));
		model.addAttribute("list", map.get("list"));
		model.addAttribute("type", map.get("type"));
		model.addAttribute("smallid", map.get("smallid"));
		model.addAttribute("favorite", map.get("favorite"));
		
		return "/product/auction";
	}
	
	/**
	 *  관심경매 리스트 Get
	 * @param type 경매 타입(경매 시작 전 / 경매 중 / 경매 종료)
	 * @param smallid 카테고리(의류, 잡화, 티켓, 가전제품)
	 * @param session session
	 * @return map 리턴
	 * @throws Exception
	 */
	public Map<String, Object> listGet(int type, int smallid, HttpSession session) throws Exception {
		Map<String, Object> map = new HashMap<String, Object>();
		
		int page = 1; // 첫 페이지 설정
		String keyword = null;
		String arrayType = "recent";
		
		String memberId = productService.memberIdGet(session); // 로그인 회원 아이디 get
		
		SearchCriteria cri = productService.setCri(smallid, page, keyword); // 경매 SearchCriteria 설정
		
		List<Product> list = productService.listByCri(cri, type, arrayType); // 검색조건에 따른 경매 리스트
		
		int count = productService.listBySearchCount(cri, type); // 검색조건에 따른 전체 리스트 수
		
		String checkEndPage = productService.checkEndPage(cri, count); // 끝페이지 인지 여부 검사(끝페이지 : "yes", 끝페이지x : "no")
		
		List<Favorite> favoriteList =  favoriteService.readByMemberId(memberId); // 로그인한 회원의 관심경매 리스트
		
		map.put("endpage", checkEndPage);
		map.put("list", list);
		map.put("type", type);
		map.put("smallid", smallid);
		map.put("favorite", favoriteList);
		
		return map;
	}
	
	/**
	 * 경매 리스트 조회 post
	 * @param type 경매 타입(경매 시작 전 / 경매 중 / 경매 종료)
	 * @param smallid 카테고리(의류, 잡화, 티켓, 가전제품)
	 * @param page 요청 페이지
	 * @param keyword 검색 값
	 * @param session
	 * @return map 리턴
	 */
	@RequestMapping(value="/auction/{type}/{smallid}", method=RequestMethod.POST)
	public ResponseEntity<Map<String, Object>> listPagePost(@PathVariable("type") int type, @PathVariable("smallid") int 	smallid, @RequestParam("page") int page, @RequestParam("keyword") String keyword, @RequestParam("arraytype") String arrayType, HttpSession session){
		String memberId = null;
		List<Favorite> favoriteList =  null;
		SearchCriteria cri = null;
		String checkEndPage = null;
		ResponseEntity<Map<String, Object>> entity = null;
		Map<String, Object> map = new HashMap<String, Object>();
		
		try {
			memberId = productService.memberIdGet(session); // 로그인 회원 아이디 get
			cri = productService.setCri(smallid, page, keyword); // 경매 SearchCriteria 설정
			
			List<Product> list = productService.listByCri(cri, type, arrayType);
			int count = productService.listBySearchCount(cri, type); // 검색조건에 따른 전체 리스트 수
			checkEndPage = productService.checkEndPage(cri, count); // 끝페이지 인지 여부 검사(끝페이지 : "yes", 끝페이지x : "no")
			favoriteList =  favoriteService.readByMemberId(memberId); // 로그인한 회원의 관심경매 리스트
			
			map.put("type", type);
			map.put("smallid", smallid);
			map.put("keyword", keyword);
			map.put("list", list);
			map.put("favorite", favoriteList);
			map.put("endpage", checkEndPage);
			
			entity = new ResponseEntity<Map<String,Object>>(map, HttpStatus.OK);
		} catch (Exception e) {
			e.printStackTrace();
			entity = new ResponseEntity<Map<String,Object>>(HttpStatus.BAD_REQUEST);
		} 
		
		return entity;
	}
	
	/**
	 * producdt 상세보기 
	 * @param productId 상품아이디 
	 * @param model model
	 * @param type 경매 타입(경매 시작 전 / 경매 중 / 경매 종료)
	 * @param smallid 카테고리(의류, 잡화, 티켓, 가전제품)
	 * @param keyword 검색값
	 * @param page 요청 페이지
	 * @return view String 값
	 * @throws Exception
	 */
	@RequestMapping(value="/auction/readpage/{productId}", method= RequestMethod.GET)
	public String readPage(@PathVariable("productId") int productId, Model model, HttpSession session) throws Exception {
		
		String memberId = productService.memberIdGet(session);
		Favorite favorite = new Favorite(0, "", 0, "");
		if(memberId.equals("")) {
			favorite = favoriteService.readByMemberProduct(memberId, productId);
		}
		model.addAttribute("favorite", favorite);
		
		Product	product = productService.read(productId); 	
		model.addAttribute(product);
		
		List<Bid> bidList = bidSevice.readByProductId(productId);
		model.addAttribute(bidList);
		
		return "/product/productdetail";
	}
	
	/**
	 * product 수정 페이지 
	 * @param productId 상품 아이디
	 * @param model model
	 * @return view String 값
	 * @throws Exception
	 */
	@RequestMapping(value="/auction/modifypage/{productId}", method= RequestMethod.POST)
	public String modifyPagePOST(@PathVariable("productId") int productId, Model model) throws Exception {
		Product product = productService.read(productId);
		Gson json = new Gson();
		String jsonlist = json.toJson(product);
		
		
		model.addAttribute("product", product);
		model.addAttribute("jsonP", jsonlist);
		
		return "/product/productModify";
	}
	
	/**
	 * product 수정 처리 및 db저장
	 * @param productId 상품 아이디
	 * @param model model
	 * @param product 상품 객체
	 * @param session session
	 * @return view String 값
	 * @throws Exception
	 */
	@RequestMapping(value="/auction/modify/{productId}", method= RequestMethod.POST)
	public String modifyPagePUT(@PathVariable("productId") int productId, Product product, Model model) throws Exception {
		
		// 사진 및 수정 데이터 저장
		productService.modify(product);
		
		String url = "redirect:/product/auction/readpage/"+productId+"";
		
		return url;
	}
	
	/**
	 * 경매 상품 삭제
	 * @param productId 상품아이디 
	 * @param model model
	 * @param type 경매 타입(경매 시작 전 / 경매 중 / 경매 종료)
	 * @param smallid 카테고리(의류, 잡화, 티켓, 가전제품)
	 * @param keyword 검색값
	 * @param page 요청 페이지
	 * @param session session
	 * @return view String 값
	 * @throws Exception
	 */
	@RequestMapping(value="/auction/remove/{productId}", method= RequestMethod.POST)
	public String remove(@PathVariable("productId")int productId, RedirectAttributes redirectAttributes, HttpSession session) throws Exception {
		productService.delete(productId);
		
		Map<String, Object> map = listGet(1, 0, session);
		redirectAttributes.addFlashAttribute(map);
		
		return "redirect:/product/auction/1/0";
	}
	
	/**
	 * 새 경매 등록  - GET방식
	 * @param model model
	 * @param session session
	 * @return view String 값
	 * @throws Exception
	 */
	@RequestMapping(value = "auction/register", method = RequestMethod.GET)
	public String registerGET(Model model)throws Exception{
		
		return "/product/registerauction";
	}
	
	
	/**
	 * 새 경매 등록 db저장 및 처리 - POST방식
	 * @param model model
	 * @param session session
	 * @param product 상품 객체
	 * @param redirectAttributes 
	 * @return 상품 리스트 화면으로 
	 * @throws Exception
	 */
	@RequestMapping(value = "auction/register", method = RequestMethod.POST)
	public String registerPOST(Model model, HttpSession session, Product product, RedirectAttributes redirectAttributes)throws Exception{
		productService.create(product);
		
		Map<String, Object> map = listGet(1, product.getSmallid(), session);
		
		redirectAttributes.addFlashAttribute(map);
		
		return "redirect:/product/auction/1/"+product.getSmallid()+"";
	}
	
	/**
	 * 중고상품 리스트 출력
	 * 
	 * @param model
	 * @return 상품 리스트
	 */
	@RequestMapping(value="/used", method=RequestMethod.GET)
	public String list(Model model) {
		try {
			model = productService.listUsedItems(model);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "/product/usedlist";
	}
	
	/**
	 * 중고상품 리스트 더 보기
	 * 
	 * @param page 출력할 페이지 번호
	 * @param keyword 검색어
	 * @return 상품 리스트
	 */
	@RequestMapping(value="/used", method=RequestMethod.POST)
	public ResponseEntity<Map<String, Object>> getMoreList(@RequestParam("page") int page, @RequestParam("keyword") String keyword, @RequestParam("smallid") int smallid) {

		ResponseEntity<Map<String, Object>> entity = null;

		try {
			
			Map<String, Object> list = productService.getMoreList(page, keyword, smallid);
			
			entity = new ResponseEntity<Map<String,Object>>(list, HttpStatus.OK);
		} catch (Exception e) {
			entity = new ResponseEntity<Map<String,Object>>(HttpStatus.BAD_REQUEST);
			e.printStackTrace();
		}
		
		return entity;
	}
	
	/**
	 * 중고상품 등록 페이지 이동
	 * 
	 * @return 뷰 주소
	 */
	@RequestMapping(value="/used/register", method=RequestMethod.GET)
	public String createGet() {
		return "/product/registerused";
	}
	
	/**
	 * 중고상품 등록
	 * 
	 * @param product 상품 객체
	 * @return 뷰 주소
	 */
	@RequestMapping(value="/used/register", method=RequestMethod.POST)
	public String createPost(Product product) {
		try {
			logger.info("중고상품 컨트롤러 실행");
			productService.create(product);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "redirect:/product/used";
	}
	
	/**
	 * 중고상품 상세 보기
	 * 
	 * @param productId 상품 아이디
	 * @param model
	 * @return 뷰 주소
	 */
	@RequestMapping(value="/used/{productId}", method=RequestMethod.GET)
	public String listPageGet(@PathVariable("productId") int productId, Model model) {
		try {
			Product product = productService.read(productId);
			model.addAttribute("product", product);
			logger.info("중고 상품 상세 보기 페이지 이동");
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "/product/useditemdetail";
	}
	
	/**
	 * 중고상품 수정 페이지 이동
	 * 
	 * @param productId 상품 아이디
	 * @param model 
	 * @return 뷰 주소
	 */
	@RequestMapping(value="/used/modify/{productId}", method=RequestMethod.GET)
	public String modifyGet(@PathVariable("productId") int productId, Model model) {
		Product product;
		try {
			model = productService.getDetail(productId, model);
			logger.info("중고 상품 수정 페이지 이동");
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "/product/usedmodify";
	}
	
	
	/**
	 * 중고상품 수정
	 * 
	 * @param product 상품 정보가 든 객체
	 * @return 뷰 주소
	 */
	@RequestMapping(value="/used/modify/{productId}", method=RequestMethod.POST)
	public String modifyPost(Product product) {
		try {
			productService.modify(product);
		} catch (Exception e) {
			e.printStackTrace();
		}
		logger.info("중고상품 정보 수정 후 상세 페이지로 이동");
		return "redirect:/product/used/" + product.getProductId();
	}
	
	/**
	 * 중고상품 삭제
	 * 
	 * @param productId 상품 아이디
	 * @return 뷰 주소
	 */
	@RequestMapping(value="/used/{productId}", method=RequestMethod.DELETE)
	public String delete(@PathVariable("productId") int productId) {
		try {
			productService.delete(productId);
		} catch (Exception e) {
			e.printStackTrace();
		}
		logger.info("중고상품 삭제 후 리스트로 이동");
		return "redirect:/product/used";
	}
	
	/**
	 * @return 중고 상품, 경매 상품 리스트
	 */
	@RequestMapping(value="/index", method=RequestMethod.POST)
	public ResponseEntity<Map<String, Object>> recentList(){
		Map<String, Object> map = new HashMap<String, Object>();
		ResponseEntity<Map<String, Object>> entity = null;
		List<Product> used = null;
		List<Product> auction = null;
		
		try {
			 used = productService.recentList(1); // 중고 상품 최근 등록된 4개 조회
			 auction = productService.recentList(2); // 경매 상품 최근 등록된 4개 조회
			 
			 map.put("used", used);
			 map.put("auction", auction);
			 
			 entity = new ResponseEntity<Map<String,Object>>(map, HttpStatus.OK);
		} catch (Exception e) {
			e.printStackTrace();
			entity = new ResponseEntity<Map<String,Object>>(HttpStatus.BAD_REQUEST);
		}
		
		return entity;
	}
}
