package kr.co.blueauction.member.dao;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import kr.co.blueauction.member.domain.Member;

@Repository
public class MybatisMemberDaoImpl implements MemberDao {
	
	@Inject
	private SqlSession sqlSession;
	
	private static final String namespace="kr.co.blueauction.mapper.MemberMapper";

	@Override
	public String getTime() {
		// TODO Auto-generated method stub
		return sqlSession.selectOne(namespace+".getTime");
	}

	@Override
	public void insertMember(Member member) {
		sqlSession.insert(namespace+".insertMember",member);

	}

}
