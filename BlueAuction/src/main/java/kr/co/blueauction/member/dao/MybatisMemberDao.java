package kr.co.blueauction.member.dao;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import kr.co.blueauction.login.LoginDTO;
import kr.co.blueauction.member.domain.Member;

@Repository
public class MybatisMemberDao implements MemberDao {
   
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
   
   @Override
   public Member login(LoginDTO dto) throws Exception{
      return sqlSession.selectOne(namespace + ".login", dto);
   }
    @Override
     public void keepLogin(String memberId, String sessionid, Date next) {

       Map<String, Object> paramMap = new HashMap<String, Object>();
       paramMap.put("memberId", memberId);
       paramMap.put("sessionid", sessionid);
       paramMap.put("next", next);
       
       sqlSession.update(namespace+".keepLogin", paramMap);
       
     }

     @Override
     public Member checkUserWithSessionKey(String value) {

       return sqlSession.selectOne(namespace +".checkUserWithSessionKey", value);
     }   
   

}