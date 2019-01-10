package com.example.spring01;

import static org.junit.Assert.*;

import java.sql.Connection;
import java.sql.DriverManager;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class MysqlConnectionTest {

	private static final Logger logger = LoggerFactory.getLogger(MysqlConnectionTest.class);
	private static final String DRIVER = "com.mysql.cj.jdbc.Driver";//"net.sf.log4jdbc.sql.jdbcapi.DriverSpy";
	private static final String URL = "jdbc:mysql://127.0.0.1:3306/spring?characterEncoding=UTF-8&serverTimezone=UTC&useSSL=false&allowPublicKeyRetrieval=true";
	private static final String USER = "root";
	private static final String PASSWORD = "root";
	
	@Test
	public void test() throws Exception {
		Class.forName(DRIVER);
		Connection conn=null;
		try{
			conn = DriverManager.getConnection(URL, USER, PASSWORD);
			if(conn!=null) {
				logger.info("Connection Success");
				//conn.close();
			}
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			if(conn!=null)conn.close();
		}
		//fail("Not yet implemented");
	}

}
