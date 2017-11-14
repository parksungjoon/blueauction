package kr.co.blueauction.member.service;

import java.util.Date;

import kr.co.blueauction.login.LoginDTO;
import kr.co.blueauction.member.domain.Member;

public interface MemberService {

	public Member login(LoginDTO tdo) throws Exception;

	public void keepLogin(String memberId, String sessionid, Date next) throws Exception;

	public Member checkLoginBefore(String value);
	
	public void insertMember(Member member);
	
	public Member idCheck(String string); 
	
	public Member emailCheck(String string);

}
