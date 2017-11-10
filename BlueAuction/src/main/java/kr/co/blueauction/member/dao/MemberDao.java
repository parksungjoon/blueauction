package kr.co.blueauction.member.dao;

import java.util.Date;

import kr.co.blueauction.login.LoginDTO;
import kr.co.blueauction.member.domain.Member;

public interface MemberDao {

	public String getTime();
	
	public void insertMember(Member member);
	
	public Member login(LoginDTO dto)throws Exception;
	
	public void keepLogin(String uid, String sessionId, Date next);
	
	 public Member checkUserWithSessionKey(String value);	
}
