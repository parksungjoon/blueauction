/**
 * Copyright(c) 2017, BlueAuction. All right reserved
 * @author 최명승
 * @since 2017. 11. 15.
 */
package kr.co.blueauction.reply.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import kr.co.blueauction.common.domain.PageMaker;
import kr.co.blueauction.common.domain.SearchCriteria;
import kr.co.blueauction.reply.dao.ReplyDao;
import kr.co.blueauction.reply.domain.Reply;

/**
 * 댓글 처리 Service
 * @author 최명승
 * @since 2017. 11. 15.
 */
@Service
public class ReplyServiceImpl implements ReplyService {

	@Inject
	ReplyDao replyDao;
	
	/**
	 * 댓글 등록
	 * @param Reply
	 * @see kr.co.blueauction.reply.service.ReplyService#create(kr.co.blueauction.reply.domain.Reply)
	 */
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
	
	/**
	 * 댓글 수정
	 * @param Reply
	 * @see kr.co.blueauction.reply.service.ReplyService#create(kr.co.blueauction.reply.domain.Reply)
	 */
	@Override
	public void update(Reply reply) throws Exception {
		replyDao.update(reply);
	}
	
	/**
	 * 댓글 삭제
	 * @param replyId
	 * @see kr.co.blueauction.reply.service.ReplyService#create(kr.co.blueauction.reply.domain.Reply)
	 */
	@Override
	public void delete(int replyId) throws Exception {
		replyDao.delete(replyId);
	}
	
	/**
	 * 댓글 목록 출력및 페이징 처리
	 * @param productId
	 * @param page
	 * @return Map<String, Object>
	 * @see kr.co.blueauction.reply.service.ReplyService#create(kr.co.blueauction.reply.domain.Reply)
	 */
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
	
	/**
	 * 물품번호에 따른 전체 댓글 수 조회
	 * @param productId
	 * @return
	 * @see kr.co.blueauction.reply.service.ReplyService#create(kr.co.blueauction.reply.domain.Reply)
	 */
	@Override
	public int count(int productId) throws Exception {
		return replyDao.count(productId);
	}
	
	/**
	 * 댓글번호로 댓글 조회
	 * @param replyId
	 * @return Reply
	 * @see kr.co.blueauction.reply.service.ReplyService#create(kr.co.blueauction.reply.domain.Reply)
	 */
	@Override
	public Reply read(int replyId) throws Exception {
		return replyDao.read(replyId);
	}
	
	/**
	 * orderNo 증가
	 * @param Reply
	 * @see kr.co.blueauction.reply.service.ReplyService#create(kr.co.blueauction.reply.domain.Reply)
	 */
	@Override
	public void liftOrderNo(Reply reply) throws Exception {
		replyDao.liftOrderNo(reply);
	}
}
