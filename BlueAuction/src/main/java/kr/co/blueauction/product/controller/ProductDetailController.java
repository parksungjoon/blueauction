/**
 * Copyright(c) 2017, BlueAuction. All right reserved
 * @author 김수진
 * @since 2017. 11. 15.
 */
package kr.co.blueauction.product.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.inject.Inject;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import kr.co.blueauction.bid.domain.Bid;
import kr.co.blueauction.bid.service.BidService;
import kr.co.blueauction.photo.domain.Photo;
import kr.co.blueauction.product.domain.Product;
import kr.co.blueauction.product.service.ProductService;

@Controller
@RequestMapping("/product")
public class ProductDetailController {
	
	@Inject
	private ProductService productService;
	
	@Inject 
	private BidService bidSevice;
	
	@RequestMapping(value="/auction/readpage/{productId}", method= RequestMethod.GET)
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
		
		//사진 불러오기
		/*List<String> fileList = boardService.getAttach(bno);
		String[] files = new String[fileList.size()];
		
		for(int i = 0; i<fileList.size(); i++) {
			files[i] = fileList.get(i);
		}
		board.setFiles(files);*/
		
		entity = new ResponseEntity<Map<String, Object>>(map, HttpStatus.OK);
		
		return entity;
	}
}
