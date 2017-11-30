/**
 * Copyright(c) 2017, BlueAuction. All right reserved
 * @author 최명승
 * @since 2017. 11. 15.
 */
package kr.co.blueauction.reply.controller;

import java.util.Map;

import javax.inject.Inject;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import kr.co.blueauction.reply.domain.Reply;
import kr.co.blueauction.reply.service.ReplyService;


/**
 * 댓글 처리 Controller
 * @author 최명승
 * @since 2017. 11. 15.
 */
@RestController
@RequestMapping("/reply")
public class ReplyController {
	
	Logger logger = LoggerFactory.getLogger(ReplyController.class);
	
	@Inject
	ReplyService replyService;
	
	/**
	 * 댓글 등록
	 * @param reply
	 * @return ResponseEntity<String>
	 */
	@Transactional
	@RequestMapping(value="", method=RequestMethod.POST)
	public ResponseEntity<String> create(@RequestBody Reply reply){
		
		ResponseEntity<String> entity = null;
		
		try {
			
			replyService.create(reply);
			entity = new ResponseEntity<String>("success", HttpStatus.OK);
			
		} catch (Exception e) {
			e.printStackTrace();
			entity = new ResponseEntity<String>(e.getMessage(), HttpStatus.BAD_REQUEST);
		}
		
		return entity;
	};
	
	/**
	 * 댓글 수정
	 * @param Reply
	 * @return ResponseEntity<String>
	 */
	@RequestMapping(value="/{replyId}", method= {RequestMethod.PUT, RequestMethod.PATCH})
	public ResponseEntity<String> update(@PathVariable("replyId") int replyId, @RequestBody Reply reply){
		
		ResponseEntity<String> entity = null;
		reply.setReplyId(replyId);
		
		try {
			replyService.update(reply);
			entity = new ResponseEntity<String>("success", HttpStatus.OK);
		} catch (Exception e) {
			e.printStackTrace();
			entity = new ResponseEntity<String>(e.getMessage(), HttpStatus.BAD_REQUEST);
		}
		
		return entity;
	}
	
	/** 댓글 삭제
	 * @param replyId
	 * @return ResponseEntity<String>
	 */
	@RequestMapping(value="/{replyId}", method=RequestMethod.DELETE)
	public ResponseEntity<String> delete(@PathVariable("replyId") int replyId){
		ResponseEntity<String> entity = null;
		try {
			replyService.delete(replyId);
			entity = new ResponseEntity<String>("success", HttpStatus.OK);
		} catch (Exception e) {
			e.printStackTrace();
			entity = new ResponseEntity<String>(e.getMessage(), HttpStatus.BAD_REQUEST);
		}
		
		return entity;
	}
	
	/**
	 * 댓글 출력 및 페이징
	 * @param productId
	 * @param page
	 * @return
	 */
	@RequestMapping(value="/{productId}/{page}", method=RequestMethod.GET )
	public ResponseEntity<Map<String, Object>> listPage(@PathVariable("productId") int productId, @PathVariable("page") int page) {
		
		ResponseEntity<Map<String, Object>> entity = null;
		
		try {
			Map<String, Object> map = replyService.listPage(productId, page);
			entity = new ResponseEntity<Map<String,Object>>(map, HttpStatus.OK);
		} catch (Exception e) {
			e.printStackTrace();
			entity = new ResponseEntity<Map<String,Object>>(HttpStatus.BAD_REQUEST);
		}
		
		return entity;
	}

}
