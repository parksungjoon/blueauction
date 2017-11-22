/**
 * Copyright(c) 2017, BlueAuction. All right reserved
 * @author 김수진
 * @since 2017. 11. 15.
 */
package kr.co.blueauction.product.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.StringTokenizer;

import javax.annotation.Resource;
import javax.inject.Inject;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.springframework.http.HttpRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import kr.co.blueauction.bid.domain.Bid;
import kr.co.blueauction.bid.service.BidService;
import kr.co.blueauction.common.domain.SearchCriteria;
import kr.co.blueauction.favorite.domain.Favorite;
import kr.co.blueauction.favorite.service.FavoriteService;
import kr.co.blueauction.member.domain.Member;
import kr.co.blueauction.product.domain.Product;
import kr.co.blueauction.product.service.ProductService;

/**
 * 상품 관련 컨트롤러  ProductController
 * @author 김수진
 * @since 2017. 11. 13.
 */
@Controller
@RequestMapping("/product")
public class ProductDetailController {
	
	Logger logger = Logger.getLogger(ProductDetailController.class);
	
	@Inject
	private ProductService productService;
	
	@Inject 
	private BidService bidSevice;
	
	@Inject
	FavoriteService favoriteService;
	
	/*@RequestMapping(value = "auction/register", method = RequestMethod.GET)
	public String registerPOST(Model model, HttpSession session)throws Exception{
		
		return "/product/registerauction";
	}
	
	@RequestMapping(value = "auction/register", method = RequestMethod.POST)
	public String registPOST(Model model, HttpSession session, Product product)throws Exception{
		productService.create(product);
		
		
		return "/product/auction";
	}*/
	
	
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
/*	@RequestMapping(value="/auction/readpage/{productId}", method= RequestMethod.POST)
	public String readPage(@PathVariable("productId") int productId, Model model, HttpSession session,
			@ModelAttribute("type")String type,  @ModelAttribute("smallid")String smallid,  @ModelAttribute("keyword")String keyword,  @ModelAttribute("page")String page) throws Exception {
		Member member = (Member) session.getAttribute("login");
		model.addAttribute("login");
		
		Product	product = productService.read(productId); 	
		model.addAttribute(product);
		
		List<Bid> bidList = bidSevice.readByProductId(productId);
		model.addAttribute(bidList);
		
		return "/product/productdetail";
	}*/
	
	
	
	/*@RequestMapping(value="/auction/readpage/{productId}", method= RequestMethod.GET)
	public String readPage(@PathVariable("productId") int productId, Model model) throws Exception {
		Product	product = productService.read(productId); 	
		model.addAttribute(product);
		
		List<Bid> bidList = bidSevice.readByProductId(productId);
		model.addAttribute(bidList);
		
		return "/product/productdetail";
	}
	
	@RequestMapping(value="/auction/readpage/{productId}", method= RequestMethod.POST)
	public ResponseEntity<Map<String, Object>> read(@PathVariable("productId") int productId) throws Exception {
		ResponseEntity<Map<String, Object>> entity = null;
		
		Map<String, Object> map = new HashMap<String, Object>();
		
		Product	product = productService.read(productId); 	
		map.put("product", product);
		
		List<Bid> bidList = bidSevice.readByProductId(productId);
		map.put("bidList", bidList);
		
		map.put("page", page);
		map.put("keyword", keyword);
		map.put("smallid", smallid);
		map.put("type", type);
		
		entity = new ResponseEntity<Map<String, Object>>(map, HttpStatus.OK);
		
		return entity;
	}*/
	
	
	/*@RequestMapping(value="/modifypage/{productId}", method= RequestMethod.GET)
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
			@ModelAttribute("type")String type,  @ModelAttribute("smallid")String smallid,  @ModelAttribute("keyword")String keyword,  @ModelAttribute("page")String page) throws Exception {
		productService.delete(productId);
		
		logger.info("type : " + type + ", smallid : " + smallid +", keyword : " + keyword + "smallid : " + smallid);
		
		// 경로만 설정해주기.
		return "redirect:/product/acution/"+type+"/"+smallid;
	}
	
	@RequestMapping(value="/auction/register")
	public String register() {
		return "/product/registerauction";
	}*/
	
	
	
	/*@RequestMapping(value="/modify/{productId}", method= RequestMethod.PUT)
	public String modifyPagePUT(@PathVariable("productId") int productId, Product product, Model model, HttpSession session) throws Exception {
		logger.info("Controller : " + product.toString());
		
		// 사진 및 수정 데이터 저장
		productService.modify(product);
		
		Member member = (Member) session.getAttribute("login");
		model.addAttribute("login", member);
		
		product = productService.read(productId); 	
		model.addAttribute(product);
		
		List<Bid> bidList = bidSevice.readByProductId(productId);
		model.addAttribute(bidList);
		
		return "redirect:/product/productdetail/"+productId+"";
	}*/
}
