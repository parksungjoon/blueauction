package kr.co.blueauction;

import java.util.List;

import javax.inject.Inject;

import org.junit.After;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import kr.co.blueauction.common.domain.SearchCriteria;
import kr.co.blueauction.member.dao.MemberDao;
import kr.co.blueauction.member.domain.Member;
import kr.co.blueauction.reply.dao.ReplyDao;
import kr.co.blueauction.reply.domain.Reply;

@RunWith(SpringJUnit4ClassRunner.class)	//스프링 빈 컨테이너를 생성하는 어노테이션
@ContextConfiguration(locations= {"file:src/main/webapp/WEB-INF/spring/root-context.xml"})//설정파일의 위치
public class ReplyDaoTest {
	
	Logger logger = LoggerFactory.getLogger(ReplyDaoTest.class);
	
	@Inject
	private ReplyDao replyDao;
	
	@After
	public void after() {
		logger.info("테스트 정상 완료");
	}
	
//	@Test
	public void createTest() {
		Reply reply = new Reply("user00", 1, "댓글 등록 테스트");
		try {
			replyDao.create(reply);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
//	@Test
	public void updateTest() {
		Reply reply = new Reply("user00", 1, "댓글 수정 테스트");
		reply.setReplyId(37);
		try {
			replyDao.update(reply);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
//	@Test
	public void deleteTest() {
		Reply reply = new Reply("user00", 1, "댓글 삭제 테스트");
		reply.setReplyId(37);
		try {
			replyDao.delete(reply);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
//	@Test
	public void listPageTeset() {
		SearchCriteria searchCriteria = new SearchCriteria();
		searchCriteria.setPage(20);
		try {
			List<Reply> list = replyDao.listPage(searchCriteria);
			for (Reply reply : list) {
				logger.info(reply.toString());
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
//	@Test
	public void testCount() {
		try {
			logger.info(Integer.toString(replyDao.count(1)));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
}
