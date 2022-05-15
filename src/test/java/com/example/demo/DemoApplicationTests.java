package com.example.demo;

import io.jsonwebtoken.Jwt;
import lombok.extern.log4j.Log4j;
import lombok.extern.slf4j.Slf4j;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;

@SpringBootTest
@Slf4j
class DemoApplicationTests {

	@Autowired
	DataSource dataSource;

	@Test
	public void connection_test(){
		try(Connection con = dataSource.getConnection()){
			log.info("커넥션 성공");
		}catch(Exception e){
			e.printStackTrace();
		}
	}


}
