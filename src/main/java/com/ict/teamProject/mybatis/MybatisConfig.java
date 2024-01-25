package com.ict.teamProject.mybatis;

import java.io.IOException;

import javax.sql.DataSource;


import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.type.Alias;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.SqlSessionTemplate;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@MapperScan(value = {"com.ict.teamProject.bbs.service.impl,com.ict.teamProject.member.service.impl"},sqlSessionFactoryRef ="sqlSessionFactory" )
@MapperScan(value = {"com.ict.teamProject.bbs.service.impl", "com.ict.teamProject.comm"},sqlSessionFactoryRef ="sqlSessionFactory" )
public class MybatisConfig {
	
	//생성자 인젝션을 통해 ApplicationContext를 컨테이너로 부터 받는다
	private final ApplicationContext applicationContext;
	public MybatisConfig(ApplicationContext applicationContext) {
		this.applicationContext=applicationContext;
	}
	
	@Bean
	SqlSessionFactory sqlSessionFactory(DataSource dataSource) {
		SqlSessionFactory factory=null;
		try {
			SqlSessionFactoryBean factoryBean = new SqlSessionFactoryBean();
			//데이타 소스 설정
			factoryBean.setDataSource(dataSource);
			//타입 별칭을 적용할 최상위 패키지 경로 설정
			//마이바티스 프레임워크는 최상위 패키지부터 하위패키지까지 @Alias붙은 컴포넌트를 찾는다
			factoryBean.setTypeAliasesPackage("com.ict.teamProject");
			//매퍼파일의 경로 설정
			factoryBean.setMapperLocations(applicationContext.getResources("classpath:mapper/**/*.xml"));
			//SqlSessionFactoryBean의 getObject()로 SqlSessionFactory객체 얻기
			factory=factoryBean.getObject();
		
		}
		catch(Exception e) {e.printStackTrace();}
		return factory;
	}/////////////////
	@Bean
	SqlSessionTemplate sqlSessionTemplate(SqlSessionFactory sqlSessionFactory) {
		return new SqlSessionTemplate(sqlSessionFactory);
	}
	
}
