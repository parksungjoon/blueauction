/**
 * Copyright(c) 2017, BlueAuction. All right reserved
 * @author 최명승
 * @since 2017. 11. 15.
 */
package kr.co.blueauction.reply.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import kr.co.blueauction.common.domain.SearchCriteria;
import kr.co.blueauction.reply.domain.Reply;

/**
 * 댓글 처리 Dao
 * @author 최명승
 * @since 2017. 11. 15.
 */
@Repository
public class MybatisReplyDao implements ReplyDao{
	
	Logger logger = LoggerFactory.getLogger(MybatisReplyDao.class);

	@Inject
	private SqlSession sqlSession;
	
	private static final String NAMESPACE = "kr.co.blueauction.mapper.RelplyMapper";
	
	/**
	 * 댓글 등록
	 * @param Reply
	 * @see kr.co.blueauction.reply.service.ReplyService#create(kr.co.blueauction.reply.domain.Reply)
	 */
	@Override
	public void create(Reply reply) throws Exception {
		sqlSession.insert(NAMESPACE + ".create", reply);
	}
	
	/**
	 * 댓글 수정
	 * @param Reply
	 * @see kr.co.blueauction.reply.service.ReplyService#create(kr.co.blueauction.reply.domain.Reply)
	 */
	@Override
	public void update(Reply reply) throws Exception {
		sqlSession.update(NAMESPACE + ".update", reply);
	}
	
	/**
	 * 댓글 삭제
	 * @param replyId
	 * @see kr.co.blueauction.reply.service.ReplyService#create(kr.co.blueauction.reply.domain.Reply)
	 */
	@Override
	public void delete(int replyId) throws Exception {
		sqlSession.update(NAMESPACE + ".delete", replyId);
	}
	
	/**
	 * 상품별 댓글 전체 삭제
	 * @param productId 
	 * @see kr.co.blueauction.reply.dao.ReplyDao#deleteAll(int)
	 */
	@Override
	public void deleteAll(int productId) throws Exception {
		sqlSession.delete(NAMESPACE + ".deleteAll", productId);
	}
	
	/**
	 * 댓글 목록 출력및 페이징 처리
	 * @param productId
	 * @param page
	 * @return List<Reply>
	 * @see kr.co.blueauction.reply.service.ReplyService#create(kr.co.blueauction.reply.domain.Reply)
	 */
	@Override
	public List<Reply> listPage(SearchCriteria cri, int productId) throws Exception {
		Map<String, Object> map=new HashMap<String, Object>();
		map.put("page", cri.getPage());
		map.put("productId", productId);
		return sqlSession.selectList(NAMESPACE + ".listPage", map);
	}
	
	/**
	 * 물품번호에 따른 전체 댓글 수 조회
	 * @param productId
	 * @return
	 * @see kr.co.blueauction.reply.service.ReplyService#create(kr.co.blueauction.reply.domain.Reply)
	 */
	@Override
	public int count(int productId) throws Exception {
		return sqlSession.selectOne(NAMESPACE + ".count", productId);
	}
	
	/**
	 * 댓글번호로 댓글 조회
	 * @param replyId
	 * @return Reply
	 * @see kr.co.blueauction.reply.service.ReplyService#create(kr.co.blueauction.reply.domain.Reply)
	 */
	@Override
	public Reply read(int replyId) throws Exception {
		return sqlSession.selectOne(NAMESPACE + ".read", replyId);
	}
	
	/**
	 * orderNo 증가
	 * @param Reply
	 * @see kr.co.blueauction.reply.service.ReplyService#create(kr.co.blueauction.reply.domain.Reply)
	 */
	@Override
	public void liftOrderNo(Reply reply) throws Exception {
		sqlSession.update(NAMESPACE + ".liftOrderNo", reply);
	}
}
