package kr.co.blueauction.reply.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.inject.Inject;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import kr.co.blueauction.common.domain.PageMaker;
import kr.co.blueauction.common.domain.SearchCriteria;
import kr.co.blueauction.reply.domain.Reply;
import kr.co.blueauction.reply.service.ReplyService;

@RestController
@RequestMapping("/reply")
public class ReplyController {
	
	@Inject
	ReplyService replyService;
	
//	댓글 등록
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
	
//	댓글 수정
	@RequestMapping(value="/{replyId}", method= {RequestMethod.PUT, RequestMethod.PATCH})
	public ResponseEntity<String> update(@PathVariable("replyId") int replyId, @RequestBody Reply reply){
		
		ResponseEntity<String> entity = null;
		reply.setReplyId(replyId);
		
		try {
			replyService.update(reply);
			entity = new ResponseEntity<>("success", HttpStatus.OK);
		} catch (Exception e) {
			e.printStackTrace();
			entity = new ResponseEntity<String>(e.getMessage(), HttpStatus.BAD_REQUEST);
		}
		
		return entity;
	}
	
//	댓글 삭제
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
	
//	댓글 출력 및 페이징
	@RequestMapping(value="/{productId}/{page}", method=RequestMethod.GET )
	public ResponseEntity<Map<String, Object>> listPage(@PathVariable("productId") int productId, @PathVariable("page") int page) {
		
		ResponseEntity<Map<String, Object>> entity = null;
		
		SearchCriteria cri = new SearchCriteria();
		cri.setPage(page);
		
		PageMaker pageMaker = new PageMaker();
		pageMaker.setCri(cri);
		
		Map<String, Object> pagingMap = new HashMap<String, Object>();
		
		try {
			
			int totalCount = replyService.count(productId);
			pageMaker.setTotalCount(totalCount);
			
			List<Reply> list = replyService.listPage(cri);
			pagingMap.put("list", list);
			
			pagingMap.put("pageMaker", pageMaker);
			
			entity = new ResponseEntity<Map<String,Object>>(pagingMap, HttpStatus.OK);
			
		} catch (Exception e) {
			e.printStackTrace();
			entity = new ResponseEntity<Map<String, Object>>(HttpStatus.BAD_REQUEST);
		}
		
		return entity;
	}

}
