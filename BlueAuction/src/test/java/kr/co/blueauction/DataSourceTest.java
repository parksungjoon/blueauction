package kr.co.blueauction;

import java.sql.Connection;
import java.sql.SQLException;

import javax.inject.Inject;
import javax.sql.DataSource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**스프링 빈컨테이너에 DataSource가 잘 등록되었는지 테스트*/
@RunWith(SpringJUnit4ClassRunner.class)	//스프링 빈 컨테이너를 생성하는 어노테이션
@ContextConfiguration(locations= {"file:src/main/webapp/WEB-INF/spring/root-context.xml"})//설정파일의 위치
public class DataSourceTest {
	@Inject//@Autowired
	private DataSource ds;
	
	@Test
	public void testConection() throws SQLException {
		System.out.println(ds.getConnection());
		/*try(Connection con=ds.getConnection()){
			System.out.println(con);
		}catch(Exception e) {
			e.printStackTrace();
		}*/
	}
	
}
