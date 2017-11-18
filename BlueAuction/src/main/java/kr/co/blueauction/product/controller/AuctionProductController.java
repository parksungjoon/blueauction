/**
 * Copyright(c) 2017, BlueAuction. All right reserved
 * @author 김수진
 * @since 2017. 11. 15.
 */

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
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import kr.co.blueauction.bid.domain.Bid;
import kr.co.blueauction.bid.service.BidService;
import kr.co.blueauction.common.domain.SearchCriteria;
import kr.co.blueauction.favorite.domain.Favorite;
import kr.co.blueauction.favorite.service.FavoriteService;
import kr.co.blueauction.member.domain.Member;
import kr.co.blueauction.product.domain.Product;
import kr.co.blueauction.product.service.ProductService;

/**
 * 경매 리스트 출력을 위한 ProductController
 *
 * @author 정지현
 * @author 김수진
 * @since 2017. 11. 13.
 *
 */
@Controller
@RequestMapping("/product")
public class AuctionProductController {

	private static final Logger logger = Logger.getLogger(AuctionProductController.class);
	
	@Inject
	private ProductService productService;
	
	@Inject 
	private BidService bidSevice;
	
	@Resource(name = "uploadPath")
	private String uploadPath;
	
	@Inject
	FavoriteService favoriteService;
	
	@Inject
	HttpSession session;
	
//	경매 리스트 조회 get
	@RequestMapping(value = "/auction/{type}/{smallid}", method = RequestMethod.GET)
	public String listPageGet(@PathVariable("type") int type, @PathVariable("smallid") int smallid, Model model)throws Exception{
		model = listGet(type, smallid, model);
		
		return "product/auction";
	}
	
	public Model listGet(int type, int smallid, Model model) throws Exception {
		Member member = (Member) session.getAttribute("login");
		if(member == null) {
			member = new Member();
			member.setMemberId("");
		}
		
		String memberId = member.getMemberId();
		SearchCriteria cri = new SearchCriteria();
		cri.setCategory(2); // 카테고리 경매로 set
		
		if(smallid != 0) {
			cri.setSmallid(smallid);
		}
		
		List<Product> list = productService.listByCri(cri, type);
		
		int count = productService.listBySearchCount(cri, type); // 검색조건에 따른 전체 리스트 수
		model.addAttribute("list", list);
		model.addAttribute("type", type);
		model.addAttribute("smallid", smallid);
		
		List<Favorite> favoriteList =  favoriteService.readByMemberId(memberId);
		
		model.addAttribute("favorite", favoriteList);
		
		return model;
	}
	
//	경매 리스트 조회 post
	@RequestMapping(value="/auction/{type}/{smallid}", method=RequestMethod.POST)
	public ResponseEntity<Map<String, Object>> listPagePost(@PathVariable("type") int type, @PathVariable("smallid") int 	smallid, @RequestParam("page") int page, @RequestParam("keyword") String keyword){
		Member member = (Member) session.getAttribute("login");
		if(member == null) {
			member = new Member();
			member.setMemberId("");
		}
		
		logger.info("member : " + member.toString());
		String memberId = member.getMemberId();
		
		logger.info("경매 리스트 Post");
		logger.info("type : " + type + "$$$$$");
		logger.info("page : " + page + "#####");
		logger.info("smallid : " + smallid);
		logger.info("keyword : " + keyword);
		logger.info("memberId : " + memberId);
		
		ResponseEntity<Map<String, Object>> entity = null;
		Map<String, Object> map = new HashMap<String, Object>();
		
		List<Favorite> favoriteList =  null;
		SearchCriteria cri = new SearchCriteria();
		cri.setCategory(2);
		cri.setPage(page);
		
		if(keyword != null) {
			cri.setKeyword(keyword);
		}
		
		if(smallid != 0) {
			cri.setSmallid(smallid);
		}
		logger.info(cri.toString());
		
		try {
			List<Product> list = productService.listByCri(cri, type);
			
			for (Product product : list) {
				logger.info(product.toString());
			}
			
			favoriteList = favoriteService.readByMemberId(memberId);
			
			logger.info("------------");
			for (Favorite favorite : favoriteList) {
				logger.info(favorite);
			}
			logger.info("------------");
			
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
	
	/**
	 * producdt 상세보기 
	 * @param productId
	 * @param model
	 * @param type
	 * @param smallid
	 * @param keyword
	 * @param page
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value="/auction/readpage/{productId}", method= RequestMethod.POST)
	public String readPage(@PathVariable("productId") int productId, Model model,
			@ModelAttribute("type")int type,  @ModelAttribute("smallid")int smallid,  @ModelAttribute("keyword")String keyword,  @ModelAttribute("page")int page) throws Exception {
		Member member = (Member) session.getAttribute("login");
		model.addAttribute("login");
		
		Product	product = productService.read(productId); 	
		model.addAttribute(product);
		
		List<Bid> bidList = bidSevice.readByProductId(productId);
		model.addAttribute(bidList);
		
		return "/product/productdetail";
	}
	
	@RequestMapping(value="/modifypage/{productId}", method= RequestMethod.GET)
	public String modifyPageGET(@PathVariable("productId") int productId, Model model) throws Exception {
		Product product = productService.read(productId);
		model.addAttribute("product", product);
			
		return "/product/productModify";
	}
	
	@RequestMapping(value="/modifypage/{productId}", method= RequestMethod.POST)
	public String modifyPagePOST(@PathVariable("productId") int productId, Model model) throws Exception {
		// 파일 업로드...!!
		
		logger.info("아직 완료 안됨");
		
		return "/";
	}
	
	@RequestMapping(value="/remove/{productId}", method= RequestMethod.POST)
	public String remove(@PathVariable("productId") int productId, Model model,
			@ModelAttribute("type")int type,  @ModelAttribute("smallid")int smallid,  @ModelAttribute("keyword")String keyword,  @ModelAttribute("page")int page) throws Exception {
		productService.delete(productId);
		
		logger.info("type : " + type + ", smallid : " + smallid +", keyword : " + keyword + "smallid : " + smallid);
		
		model = listGet(type, smallid, model);
		
		// 경로만 설정해주기.
		return "/product/auction";
	}
	
	@RequestMapping(value="/auction/register")
	public String register() {
		return "/product/registerauction";
	}
	
}