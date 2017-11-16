
package kr.co.blueauction.product.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.inject.Inject;

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

import kr.co.blueauction.common.domain.PageMaker;
import kr.co.blueauction.common.domain.SearchCriteria;
import kr.co.blueauction.product.domain.Product;
import kr.co.blueauction.product.service.ProductService;

/**
 * 경매 리스트 출력을 위한 ProductController
 *
 * @author 정지현
 *
 */
@Controller
@RequestMapping("/product")
public class AuctionProductController {

	private static final Logger logger = Logger.getLogger(AuctionProductController.class);
	
	@Inject
	ProductService productService;
	
	/*@RequestMapping(value="/auction/{type}/{smallid}", method=RequestMethod.GET)
	public String listPageGet(@PathVariable("type") int type, @PathVariable("smallid") int smallid, @ModelAttribute("cri") SearchCriteria cri, Model model) throws Exception{
		logger.info("경매 리스트 시자자자자자자작");
		
		logger.info("경매 리스트 시작!!");
		cri.setCategory(2);
		logger.info(cri.toString());
		logger.info("type : " + type);
		logger.info("smallid : " + smallid);
		
		if(smallid != 0) {
			cri.setSmallid(smallid);
		}
		
		List<Product> list = productService.listByCri(cri, type);
		for (Product product : list) {
			logger.info(product.toString());
		}
		
		logger.info("-----------");
		int count = productService.listBySearchCount(cri, type);
		logger.info("count : " + count);
		model.addAttribute("list", list);
		model.addAttribute("type", type);
		
		PageMaker  pageMaker = new PageMaker();
		pageMaker.setCri(cri);
		pageMaker.setTotalCount(count);
		logger.info(pageMaker.toString());
		model.addAttribute("pageMaker", pageMaker);
		
		return "product/auction";
	}
//	경매 리스트 조회
	@RequestMapping(value="/auction/{type}/{smallid}", method=RequestMethod.POST)
	public String  listPagePost(@PathVariable("type") int type, @PathVariable("smallid") int smallid, @RequestParam("cri") SearchCriteria cri, Model model) throws Exception{
		logger.info("경매 리스트 시작!!");
		cri.setCategory(2);
		logger.info(cri.toString());
		logger.info("type : " + type);
		logger.info("smallid : " + smallid);
		
		if(smallid != 0) {
			cri.setSmallid(smallid);
		}
		
		List<Product> list = productService.listByCri(cri, type);
		for (Product product : list) {
			logger.info(product.toString());
		}
		
		logger.info("-----------");
		int count = productService.listBySearchCount(cri, type);
		logger.info("count : " + count);
		model.addAttribute("list", list);
		model.addAttribute("type", type);
		
		PageMaker  pageMaker = new PageMaker();
		pageMaker.setCri(cri);
		pageMaker.setTotalCount(count);
		logger.info(pageMaker.toString());
		model.addAttribute("pageMaker", pageMaker);
		
		return "product/auction";
	}*/
	
	@RequestMapping(value = "/auction/{type}/{smallid}", method = RequestMethod.GET)
	public String listPageGet(@PathVariable("type") int type, @PathVariable("smallid") int smallid, Model model)throws Exception{
		logger.info("경매 리스트  처음 출력 Get");
		logger.info( " type : " + type + "*****");
		logger.info("smallid : " + smallid);
		
		SearchCriteria cri = new SearchCriteria();
		cri.setCategory(2);
		
		if(smallid != 0) {
			cri.setSmallid(smallid);
		}
		logger.info(cri.toString());
		
		List<Product> list = productService.listByCri(cri, type);
		for (Product product : list) {
			logger.info(product.toString());
		}
		
		logger.info("-----------");
		int count = productService.listBySearchCount(cri, type);
		logger.info("count : " + count);
		model.addAttribute("list", list);
		model.addAttribute("type", type);
		model.addAttribute("smallid", smallid);
		
		PageMaker  pageMaker = new PageMaker();
		pageMaker.setCri(cri);
		pageMaker.setTotalCount(count);
		model.addAttribute("pageMaker", pageMaker);
		
		return "product/auction";
	}
	
//	경매 리스트 조회
	@RequestMapping(value="/auction/{type}/{smallid}", method=RequestMethod.POST)
	public ResponseEntity<Map<String, Object>> listPagePost(@PathVariable("type") int type, @PathVariable("smallid") int 	smallid, @RequestParam("page") int page){
		
		logger.info("경매 리스트 출력 시작");
		logger.info("type : " + type + "$$$$$");
		logger.info("page : " + page + "#####");
		logger.info("smallid : " + smallid);
		
		ResponseEntity<Map<String, Object>> entity = null;
		Map<String, Object> map = new HashMap<String, Object>();
		
		SearchCriteria cri = new SearchCriteria();
		cri.setCategory(2);
		cri.setPage(page);
		
		if(smallid != 0) {
			cri.setSmallid(smallid);
		}
		logger.info(cri.toString());
		
		try {
			List<Product> list = productService.listByCri(cri, type);
			
			for (Product product : list) {
				logger.info(product.toString());
			}
			
			map.put("type", type);
			map.put("smallid", smallid);
			map.put("list", list);
			entity = new ResponseEntity<Map<String,Object>>(map, HttpStatus.OK);
		} catch (Exception e) {
			e.printStackTrace();
			entity = new ResponseEntity<Map<String,Object>>(HttpStatus.BAD_REQUEST);
		}
		
		return entity;
	}
	
	/*@RequestMapping(value = "/auction/{type}/{smallid}", method = RequestMethod.POST)
	public String listPagePost(@PathVariable("type") int type, @PathVariable("smallid") int smallid,  @RequestParam("page") int page, Model model) throws Exception{
		logger.info("경매 리스트 출력 더보기 시작");
		logger.info( " type : " + type + "*****");
		logger.info("smallid : " + smallid);
		
		SearchCriteria cri = new SearchCriteria();
		cri.setCategory(2);
		logger.info("page : "+ page);
		cri.setPage(page);
		
		if(smallid != 0) {
			cri.setSmallid(smallid);
		}
		logger.info(cri.toString());
		
		List<Product> list = productService.listByCri(cri, type);
		for (Product product : list) {
			logger.info(product.toString());
		}
		
		logger.info("-----------");
		int count = productService.listBySearchCount(cri, type);
		logger.info("count : " + count);
		model.addAttribute("list", list);
		model.addAttribute("type", type);
		model.addAttribute("smallid", smallid);
		
		PageMaker  pageMaker = new PageMaker();
		pageMaker.setCri(cri);
		pageMaker.setTotalCount(count);
		model.addAttribute("pageMaker", pageMaker);
		
		return "product/auction";
	}*/
}
