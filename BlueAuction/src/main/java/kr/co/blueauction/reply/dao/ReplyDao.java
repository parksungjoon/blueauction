/**
 * Copyright(c) 2017, BlueAuction. All right reserved
 * @author 최명승
 * @since 2017. 11. 15.
 */
package kr.co.blueauction.reply.dao;

import java.util.List;

import kr.co.blueauction.common.domain.SearchCriteria;
import kr.co.blueauction.reply.domain.Reply;

/**
 * 댓글 처리 Dao
 * @author 최명승
 * @since 2017. 11. 15.
 */
public interface ReplyDao {

//	댓글 등록
	public void create(Reply reply) throws Exception;
	
//	댓글 수정
	public void update(Reply reply) throws Exception;
	
//	댓글 삭제
	public void delete(int replyId) throws Exception;
	
//	댓글 목록 출력 및 페이징 처리
	public List<Reply> listPage(SearchCriteria cri, int productId) throws Exception;
	
//	전체 댓글 수 계산
	public int count(int productId) throws Exception;
	
//	댓글 정보 조회
	public Reply read(int replyId) throws Exception;
	
//	orderno 증가
	public void liftOrderNo(Reply reply) throws Exception;
	
}
