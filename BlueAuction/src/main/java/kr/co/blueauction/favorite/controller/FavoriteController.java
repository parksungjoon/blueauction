/**
 * Copyright(c) 2017, BlueAuction. All right reserved
 * @author 정지현
 * @since 2017. 11. 20.
 */

package kr.co.blueauction.favorite.controller;

import java.util.Map;

import javax.inject.Inject;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import kr.co.blueauction.favorite.domain.Favorite;
import kr.co.blueauction.favorite.service.FavoriteService;
import kr.co.blueauction.member.domain.Member;

/**
 * 관심 경매 등록, 삭제를 위한 FavoriteController
 *
 * @author 정지현
 * @since 2015.11.20
 *
 */

@Controller
@RequestMapping("/favorite")
public class FavoriteController {
	
	private static final Logger logger = Logger.getLogger(FavoriteController.class);
	
	@Inject
	private FavoriteService favoriteService;
	
	// 관심 경매 등록, 삭제 post
	@RequestMapping(value="", method=RequestMethod.POST)
	public ResponseEntity<String> registOrDelete(@RequestParam("productId") int productId, HttpSession session){
		Member member = (Member) session.getAttribute("login");
		String memberId = member.getMemberId();
		String result = null;
		
		ResponseEntity<String> entity = null;
		
		logger.info("productId : " + productId);
		logger.info("memberId : " + memberId);
		
		Favorite favorite = new Favorite(memberId, productId);
		
		Favorite check = favoriteService.favoriteCheck(favorite);
		
		try {
			if(check == null) {
				favoriteService.insert(favorite);
				result = "insert";
				logger.info("관심경매 등록");
			}else {
				favoriteService.delete(favorite);
				result = "delete";
				logger.info("관심경매 삭제");
			}
			entity = new ResponseEntity<String>(result, HttpStatus.OK);
		} catch (Exception e) {
			e.printStackTrace();
			entity = new ResponseEntity<String>(HttpStatus.BAD_REQUEST);
		}
		return entity;
	}
}
