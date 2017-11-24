/*package kr.co.blueauction.product.controller;

import java.util.Calendar;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.inject.Inject;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributesModelMap;
import org.springframework.web.servlet.view.RedirectView;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.json.JsonGeneratorImpl;
import com.google.gson.Gson;

import kr.co.blueauction.common.domain.PageMaker;
import kr.co.blueauction.common.domain.SearchCriteria;
import kr.co.blueauction.favorite.domain.Favorite;
import kr.co.blueauction.favorite.service.FavoriteService;
import kr.co.blueauction.member.domain.Member;
import kr.co.blueauction.product.domain.Product;
import kr.co.blueauction.product.service.ProductService;
import kr.co.blueauction.product.util.UploadFileUtils;

@Controller
//@RequestMapping("/product/*")
public class UsedProductController {

	Logger logger = LoggerFactory.getLogger(UsedProductController.class);
	
	@Inject
	private ProductService productService;
	
	
//	중고상품 리스트 페이지 이동
	@RequestMapping(value="/used", method=RequestMethod.GET)
	public String list(Model model) {
		logger.info("중고 상품 리스트 페이지 이동");
		try {
			model = productService.listUsedItems(model);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "/product/usedlist";
	}
	
//	중고상품 리스트 더 보기
	@RequestMapping(value="/used", method=RequestMethod.POST)
	public ResponseEntity<Map<String, Object>> getMoreList(@RequestParam("page") int page, @RequestParam("keyword") String keyword) {

		logger.info("중고 상품 더 보기 실행");
		ResponseEntity<Map<String, Object>> entity = null;

		try {
			
			Map<String, Object> list = productService.getMoreList(page, keyword);
			
			entity = new ResponseEntity<Map<String,Object>>(list, HttpStatus.OK);
		} catch (Exception e) {
			entity = new ResponseEntity<Map<String,Object>>(HttpStatus.BAD_REQUEST);
			e.printStackTrace();
		}
		
		return entity;
	}
	
//	중고상품 등록 페이지 이동
	@RequestMapping(value="/used/register", method=RequestMethod.GET)
	public String createGet() {
		logger.info("중고 상품 등록 페이지 이동");
		return "/product/registerused";
	}
	
//	중고상품 등록
	@Transactional
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
	
//	중고상품 상세 보기 페이지 이동
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
	
//	중고상품 수정 페이지 이동
	@RequestMapping(value="/used/modify/{productId}", method=RequestMethod.GET)
	public String modifyGet(@PathVariable("productId") int productId, Model model) {
		Product product;
		try {
			product = productService.read(productId);
			model.addAttribute("product", product);
			logger.info("중고 상품 수정 페이지 이동");
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "/product/usedmodify";
	}
}
*/