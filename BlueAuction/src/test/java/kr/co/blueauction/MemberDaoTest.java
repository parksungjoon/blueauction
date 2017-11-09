package kr.co.blueauction;

import javax.inject.Inject;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import kr.co.blueauction.member.dao.MemberDao;
import kr.co.blueauction.member.domain.Member;

@RunWith(SpringJUnit4ClassRunner.class)	//스프링 빈 컨테이너를 생성하는 어노테이션
@ContextConfiguration(locations= {"file:src/main/webapp/WEB-INF/spring/root-context.xml"})//설정파일의 위치
public class MemberDaoTest {
	
	@Inject
	private MemberDao memberDao;
	
	//@Test
	public void testTime(){
		System.out.println(memberDao.getTime());
	}
	
	@Test
	public void testInsertMember() {
		/*Member member=new Member();
		member.setUserid("이얼싼");
		member.setUserpw("쓰우류");
		member.setUsername("쓰빠");
		memberDao.insertMember(member);
		System.out.println("입력완료");*/
	}

}
