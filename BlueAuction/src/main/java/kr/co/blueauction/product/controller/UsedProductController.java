package kr.co.blueauction.product.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartFile;

import kr.co.blueauction.product.util.UploadImageUtil;

@Controller
@RequestMapping("/product/*")
public class UsedProductController {

	Logger logger = LoggerFactory.getLogger(UsedProductController.class);
	
	
//	중고상품 등록 페이지 이동
	@RequestMapping(value="/used/register", method=RequestMethod.GET)
	public String create() {
		logger.info("중고 상품 상세 보기 페이지 이동");
		return "/product/registerused";
	}
	
//	이미지 파일 등록
	@RequestMapping(value="/attach/{productId}", method=RequestMethod.POST, produces="text/plain;charset=utf-8")
	public ResponseEntity<String> uploadImages(@PathVariable("productId") int productId, MultipartFile[] files) {
		
//		logger.info("이미지 컨트롤러 실행");
		ResponseEntity<String> entity = null;
		
		entity = new ResponseEntity<String>("success", HttpStatus.CREATED);
		
		return entity;
	}
	
//	중고상품 상세 보기 페이지 이동
	@RequestMapping(value="/{productId}", method=RequestMethod.GET)
	public String listPageGet() {
		logger.info("중고 상품 상세 보기 페이지 이동");
		return "/product/reproductdetail";
	}
	
}
