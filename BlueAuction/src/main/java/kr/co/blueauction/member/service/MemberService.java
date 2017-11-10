package kr.co.blueauction.member.service;

import java.util.Date;

import kr.co.blueauction.login.LoginDTO;
import kr.co.blueauction.member.domain.Member;

public interface MemberService {

	public Member login(LoginDTO tdo) throws Exception;

	public void keepLogin(String member_id, String sessionId, Date next) throws Exception;

	public Member checkLoginBefore(String value);

}
