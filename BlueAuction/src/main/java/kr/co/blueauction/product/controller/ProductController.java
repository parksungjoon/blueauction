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
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import kr.co.blueauction.bid.service.BidService;
import kr.co.blueauction.common.domain.SearchCriteria;
import kr.co.blueauction.favorite.domain.Favorite;
import kr.co.blueauction.favorite.service.FavoriteService;
import kr.co.blueauction.product.domain.Product;
import kr.co.blueauction.product.service.ProductService;

/**
 * 경매 리스트를 위한 ProductController 
 *
 * @author 정지현
 * @since 2017. 11. 22.
 */

@Controller
/*@RequestMapping("/product")*/
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
	@RequestMapping(value = "/auction/{type}/{smallid}", method = RequestMethod.GET)
	public String listPageGet(@PathVariable("type") int type, @PathVariable("smallid") int smallid, Model model, HttpSession session)throws Exception{
		model = listGet(type, smallid, model, session);
		
		return "/product/auction";
	}
	
	public Model listGet(int type, int smallid, Model model, HttpSession session) throws Exception {
		int page = 1; // 첫 페이지 설정
		String keyword = null;
		
		String memberId = productService.memberIdGet(session); // 로그인 회원 아이디 get
		
		SearchCriteria cri = productService.setCri(smallid, page, keyword); // 경매 SearchCriteria 설정
		
		List<Product> list = productService.listByCri(cri, type); // 검색조건에 따른 경매 리스트
		
		int count = productService.listBySearchCount(cri, type); // 검색조건에 따른 전체 리스트 수
		
		String checkEndPage = productService.checkEndPage(cri, count); // 끝페이지 인지 여부 검사(끝페이지 : "yes", 끝페이지x : "no")
		
		List<Favorite> favoriteList =  favoriteService.readByMemberId(memberId); // 로그인한 회원의 관심경매 리스트
		
		model.addAttribute("endpage", checkEndPage);
		model.addAttribute("list", list);
		model.addAttribute("type", type);
		model.addAttribute("smallid", smallid);
		model.addAttribute("favorite", favoriteList);
		
		return model;
	}
	
//	경매 리스트 조회 post
	/**
	 * @param type 경매 타입(경매 시작 전 / 경매 중 / 경매 종료)
	 * @param smallid 카테고리(의류, 잡화, 티켓, 가전제품)
	 * @param page 요청 페이지
	 * @param keyword 검색 값
	 * @param session
	 * @return map 리턴
	 */
	@RequestMapping(value="/auction/{type}/{smallid}", method=RequestMethod.POST)
	public ResponseEntity<Map<String, Object>> listPagePost(@PathVariable("type") int type, @PathVariable("smallid") int 	smallid, @RequestParam("page") int page, @RequestParam("keyword") String keyword, HttpSession session){
		String memberId = null;
		List<Favorite> favoriteList =  null;
		SearchCriteria cri = null;
		String checkEndPage = null;
		ResponseEntity<Map<String, Object>> entity = null;
		Map<String, Object> map = new HashMap<String, Object>();
		
		try {
			memberId = productService.memberIdGet(session); // 로그인 회원 아이디 get
			cri = productService.setCri(smallid, page, keyword); // 경매 SearchCriteria 설정
			
			List<Product> list = productService.listByCri(cri, type);
			int count = productService.listBySearchCount(cri, type); // 검색조건에 따른 전체 리스트 수
			checkEndPage = productService.checkEndPage(cri, count); // 끝페이지 인지 여부 검사(끝페이지 : "yes", 끝페이지x : "no")
			favoriteList =  favoriteService.readByMemberId(memberId); // 로그인한 회원의 관심경매 리스트
			
			map.put("type", type);
			map.put("smallid", smallid);
			map.put("keyword", keyword);
			map.put("list", list);
			map.put("favorite", favoriteList);
			
			entity = new ResponseEntity<Map<String,Object>>(map, HttpStatus.OK);
		} catch (Exception e) {
			e.printStackTrace();
			entity = new ResponseEntity<Map<String,Object>>(HttpStatus.BAD_REQUEST);
		} 
		
		return entity;
	}
	
}
