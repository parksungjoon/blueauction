package kr.co.blueauction.product.controller;

import java.util.Calendar;
import java.util.List;

import javax.inject.Inject;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartFile;

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
@RequestMapping("/product/*")
public class UsedProductController {

	Logger logger = LoggerFactory.getLogger(UsedProductController.class);
	
	@Inject
	private ProductService productService;
	
	
//	중고상품 리스트 페이지 이동
	@RequestMapping(value="/used", method=RequestMethod.GET)
	public String list(Model model) {
		logger.info("중고 상품 리스트 페이지 이동");
		try {
			model = listGet(model);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "/product/usedlist";
	}
	
	private Model listGet(Model model) throws Exception {

		SearchCriteria cri = new SearchCriteria();
		cri.setCategory(1); // 카테고리 경매로 set
		cri.setPerPageNum(9);
		
		List<Product> list = productService.listByCri(cri, 0);
		
		int count = productService.listBySearchCount(cri, 0); // 검색조건에 따른 전체 리스트 수
		
		PageMaker pageMaker = new PageMaker();
		pageMaker.setCri(cri);
		pageMaker.setTotalCount(count);
		
		if(1 == pageMaker.getEndPage()) { // 1페이지가 마지막 페이지면
			model.addAttribute("endpage", "yes");
		}else {
			model.addAttribute("endpage", "no");
		}
		
		for (Product product : list) {
			product.setRegdate('"' + product.getRegdate() +  '"');
			product.setMainphoto('"' + product.getMainphoto() +  '"');
		}
		
		Gson gson = new Gson();
		String jsonlist = gson.toJson(list);
		
		model.addAttribute("list", jsonlist);
		
		return model;
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
			productService.create(product);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "/product/useditemdetail";
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
