package kr.co.blueauction.reply.service;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

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
		replyDao.create(reply);
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
	public List<Reply> listPage(SearchCriteria cri) throws Exception {
		return replyDao.listPage(cri);
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
