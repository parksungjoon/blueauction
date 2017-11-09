package kr.co.blueauction.member.dao;

import kr.co.blueauction.member.domain.Member;

public interface MemberDao {

	public String getTime();
	
	public void insertMember(Member member);
}
