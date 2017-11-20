package kr.co.blueauction.product.controller;

import java.util.Calendar;
import java.util.List;

import javax.inject.Inject;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartFile;

import kr.co.blueauction.product.domain.Product;
import kr.co.blueauction.product.service.ProductService;
import kr.co.blueauction.product.util.UploadFileUtils;

@Controller
@RequestMapping("/product/*")
public class UsedProductController {

	Logger logger = LoggerFactory.getLogger(UsedProductController.class);
	
	@Inject
	private ProductService productService;
	
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
		logger.info("중고 상품 등록 컨트롤러 실행");
		try {
			productService.create(product);
		} catch (Exception e) {
			e.printStackTrace();
		}
		logger.info("중고 상품 등록 컨트롤러 실행 후 페이지 이동");
		return "redirect:/product/reproductdetail";
	}
	
//	중고상품 상세 보기 페이지 이동
	@RequestMapping(value="/{productId}", method=RequestMethod.GET)
	public String listPageGet() {
		logger.info("중고 상품 상세 보기 페이지 이동");
		return "/product/reproductdetail";
	}
	
}
