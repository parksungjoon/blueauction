package kr.co.blueauction;

import java.sql.Connection;
import java.sql.DriverManager;

import org.junit.Test;

public class MySQLConnectionTest {
	
	private static final String DRIVER="com.mysql.cj.jdbc.Driver";
	private static final String URL="jdbc:mysql://localhost:3306/blueauction?useSSL=false&serverTimezone=Asia/Seoul";
	private static final String USER="blueauction";
	private static final String PW="blueauction";
	
	@Test
	public void testConnection()throws Exception{
		Class.forName(DRIVER);
		
		Connection con=DriverManager.getConnection(URL,USER,PW);
		System.out.println(con);
	}
}
