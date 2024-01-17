/*package com.ict.teamProject.security;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.DisabledException;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.authentication.configuration.GlobalAuthenticationConfigurerAdapter;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;


@Configuration
@EnableWebSecurity //씨큐리티 쓰기위해서 사용하는 어노테이션
public class SecurityConfig extends GlobalAuthenticationConfigurerAdapter  {
	
	@Bean
	SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
			return http
            // stateless한 rest api를 개발할 것이므로 csrf 공격에 대한 옵션은 꺼둔다.
					.csrf(AbstractHttpConfigurer::disable)
			// 특정 URL에 대한 권한 설정. => 인증설정
					.authorizeHttpRequests((authorizeRequests) -> {
                authorizeRequests.requestMatchers("/user/**").authenticated();
                authorizeRequests.requestMatchers("/manager/**")
                        // ROLE_은 붙이면 안 된다. hasAnyRole()을 사용할 때 자동으로 ROLE_이 붙기 때문이다.
                        .hasAnyRole("ADMIN", "MANAGER");
                authorizeRequests.requestMatchers("/admin/**")
                        // ROLE_은 붙이면 안 된다. hasRole()을 사용할 때 자동으로 ROLE_이 붙기 때문이다.
                        .hasRole("ADMIN");
                authorizeRequests.anyRequest().permitAll(); //=>인증을 하면 모든 권한 허용
            })
			//폼 기반 인증(로그인) 설정		
            .formLogin((formLogin) -> {
             권한이 필요한 요청은 해당 url로 리다이렉트 
			    formLogin.loginPage("/Login.do"); //인증 페이지
			    formLogin.loginProcessingUrl("/LoginProcess.do"); //인증 성공시
			    formLogin.failureUrl("/Login.do"); //인증 실패시
			    formLogin.failureHandler((request,response,exception)->{//폼으로 로그인시에만 실행됨
					System.out.println("폼 로그인 실패");
					System.out.println("에러메시지:"+exception.getMessage());
					System.out.println("예외클래스:"+exception.getClass().getName());
					if(exception instanceof BadCredentialsException)
						request.setAttribute("NOT_MEMBER","아이디/비번 불일치");	
					else if(exception instanceof DisabledException)
						request.setAttribute("NOT_MEMBER","당신은 휴면 처리 됬어요.관리자에게 문의하세요");	
					else
						request.setAttribute("NOT_MEMBER","중복 로그인 발생....");
					request.getRequestDispatcher("/onememo/auth/Login.do").forward(request, response);
				});
			    formLogin.usernameParameter("id"); //아이디 일치여부
			    formLogin.passwordParameter("pwd"); //비밀번호 일치여부
			    formLogin.defaultSuccessUrl("/Login.do"); 
            })
            .sessionManagement((sessionManagement) ->{
            sessionManagement.sessionCreationPolicy(SessionCreationPolicy.STATELESS);
            sessionManagement.invalidSessionUrl("/Login.do");
            sessionManagement.maximumSessions(2);
            })
            .logout(t -> t.logoutUrl("Logout.do"))
            .build();
	}
	

	@Bean
	PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}
	
	@Autowired
	private DataSource dataSource;

	@Override
	public void init(AuthenticationManagerBuilder auth) throws Exception {
		auth
			//JDBC기반 인증 설정
			.jdbcAuthentication()
				.dataSource(dataSource)
				.usersByUsernameQuery("select id as username, pwd as password, enabled from member where id = ?")
				.authoritiesByUsernameQuery("select id as username, authority  from member where id = ?")
				.passwordEncoder(passwordEncoder());
	}
	
	
}
*/