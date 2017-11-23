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
import kr.co.blueauction.reply.service.ReplyService;

@RunWith(SpringJUnit4ClassRunner.class)	//스프링 빈 컨테이너를 생성하는 어노테이션
@ContextConfiguration(locations= {"file:src/main/webapp/WEB-INF/spring/root-context.xml"})//설정파일의 위치
public class ReplyServiceTest {
	
	Logger logger = LoggerFactory.getLogger(ReplyServiceTest.class);
	
	@Inject
	private ReplyService replyService;
	
	@After
	public void after() {
		logger.info("테스트 정상 완료");
	}
	
//	@Test
	public void createTest() {
		Reply reply = new Reply("user00", 1, "서비스 댓글 등록 테스트");
		try {
			replyService.create(reply);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
//	@Test
	public void updateTest() {
		Reply reply = new Reply("user00", 1, "서비스 댓글 수정 테스트");
		reply.setReplyId(37);
		try {
			replyService.update(reply);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
//	@Test
	public void deleteTest() {
		try {
			replyService.delete(38);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
//	@Test
	/*public void listPageTeset() {
		SearchCriteria searchCriteria = new SearchCriteria();
		searchCriteria.setPage(30);
		try {
			List<Reply> list = replyService.listPage(searchCriteria, 69);
			for (Reply reply : list) {
				logger.info("리스트 출력  :  " + reply.toString());
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}*/
	
//	@Test
	public void testCount() {
		try {
			logger.info(Integer.toString(replyService.count(1)));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
//	@Test
	public void testRead() {
		try {
			logger.info(replyService.read(38).toString());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
//	@Test
	public void testLiftOrderNo() {
		try {
			Reply reply = replyService.read(34);
			replyService.liftOrderNo(reply);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
}
