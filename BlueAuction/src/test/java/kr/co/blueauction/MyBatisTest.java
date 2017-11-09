package kr.co.blueauction;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.log4j.Logger;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)	//스프링 빈 컨테이너를 생성하는 어노테이션
@ContextConfiguration(locations= {"file:src/main/webapp/WEB-INF/spring/root-context.xml"})//설정파일의 위치
public class MyBatisTest {
	Logger logger=Logger.getLogger(MyBatisTest.class);
	
	@Inject
	private SqlSessionFactory sqlFactory;
	
	@Test
	public void testFactory() {
		System.out.println(sqlFactory);
	}
	
	@Test
	public void testSession() {
		SqlSession session=sqlFactory.openSession();
		System.out.println(session);
	}

}
