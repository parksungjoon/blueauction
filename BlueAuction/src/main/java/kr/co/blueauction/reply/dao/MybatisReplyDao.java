package kr.co.blueauction.reply.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import kr.co.blueauction.common.domain.SearchCriteria;
import kr.co.blueauction.reply.domain.Reply;

@Repository
public class MybatisReplyDao implements ReplyDao{

	@Inject
	private SqlSession sqlSession;
	
	private static final String NAMESPACE = "kr.co.blueauction.mapper.RelplyMapper";
	
//	댓글 등록
	@Override
	public void create(Reply reply) throws Exception {
		sqlSession.insert(NAMESPACE + ".create", reply);
	}
	
//	댓글 수정
	@Override
	public void update(Reply reply) throws Exception {
		sqlSession.update(NAMESPACE + ".update", reply);
	}
	
//	댓글 삭제
	@Override
	public void delete(Reply reply) throws Exception {
		sqlSession.update(NAMESPACE + ".delete", reply);
	}
	
//	댓글 목록 출력 및 페이징 처리
	@Override
	public List<Reply> listPage(SearchCriteria cri) throws Exception {
		return sqlSession.selectList(NAMESPACE + ".listPage", cri);
	}
	
//	전체 댓글 수 계산
	@Override
	public int count(int productId) throws Exception {
		return sqlSession.selectOne(NAMESPACE + ".count", productId);
	}
}
