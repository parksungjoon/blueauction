package kr.co.blueauction.reply.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.inject.Inject;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import kr.co.blueauction.common.domain.PageMaker;
import kr.co.blueauction.common.domain.SearchCriteria;
import kr.co.blueauction.reply.dao.ReplyDao;
import kr.co.blueauction.reply.domain.Reply;

@Service
public class ReplyServiceImpl implements ReplyService {

	@Inject
	ReplyDao replyDao;
	
//	댓글 등록
	@Override
	public void create(Reply reply) throws Exception {
		
		if (reply.getReplyId() == 0) { // 신규글
			
			replyDao.create(reply);
			
		} else { // 댓글
			
			Reply parentReply = replyDao.read(reply.getReplyId());
			reply.setGroupNo(parentReply.getGroupNo());
			reply.setLevelNo(parentReply.getLevelNo()+1);
			reply.setOrderNo(parentReply.getOrderNo()+1);
			
			if (parentReply.getLevelNo() == 0) { // 첫 댓글
				
				replyDao.create(reply);
				
			} else { // 댓글의 댓글
				
				replyDao.liftOrderNo(parentReply);
				replyDao.create(reply);
				
			}
			
		}
		
	}
	
//	댓글 수정
	@Override
	public void update(Reply reply) throws Exception {
		replyDao.update(reply);
	}
	
//	댓글 삭제
	@Override
	public void delete(int replyId) throws Exception {
		replyDao.delete(replyId);
	}
	
//	댓글 목록 출력 및 페이징 처리
	@Override
	public Map<String, Object> listPage(int productId, int page) throws Exception {
		
		SearchCriteria cri = new SearchCriteria();
		cri.setPage(page);
		
		PageMaker pageMaker = new PageMaker();
		pageMaker.setCri(cri);
		
		Map<String, Object> pagingMap = new HashMap<String, Object>();
		
			int totalCount = replyDao.count(productId);
			pageMaker.setTotalCount(totalCount);
			
			List<Reply> list = replyDao.listPage(cri, productId);
			pagingMap.put("list", list);
			
			pagingMap.put("pageMaker", pageMaker);
			
		return pagingMap;
	}
	
//	전체 댓글 수 계산
	@Override
	public int count(int productId) throws Exception {
		return replyDao.count(productId);
	}
	
//	댓글 정보 조회
	@Override
	public Reply read(int replyId) throws Exception {
		return replyDao.read(replyId);
	}
	
//	orderno 증가
	@Override
	public void liftOrderNo(Reply reply) throws Exception {
		replyDao.liftOrderNo(reply);
	}
}
