package kr.co.blueauction.member.service;

import java.util.Date;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import kr.co.blueauction.login.LoginDTO;
import kr.co.blueauction.member.dao.MemberDao;
import kr.co.blueauction.member.domain.Member;

@Service
public class MemberServiceImpl implements MemberService {

	@Inject
	private MemberDao dao;

	@Override
	public Member login(LoginDTO dto) throws Exception {
		return dao.login(dto);
	}

	@Override
	public void keepLogin(String member_id, String sessionId, Date next) throws Exception {

		dao.keepLogin(member_id, sessionId, next);

	}

	@Override
	public Member checkLoginBefore(String value) {

		return dao.checkUserWithSessionKey(value);
	}
}
