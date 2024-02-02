
package com.ict.teamProject.security.config.auth;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.ict.teamProject.member.service.MemberDetailService;
import com.ict.teamProject.member.service.MemberDto;

// 시큐리티 설정에서 loginProcessingUrl("login")
//login 요청이 오면 자동으로 UserDetailsService 타입으로 loC 되어 있는 loadUserByUsername 함수가 실행

@Service
public class PrincipalDetailsService implements UserDetailsService{

	@Autowired
	private MemberDetailService service;

	@Override 
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		System.out.println("Username: " + username);
		MemberDto userEntity = service.findByUsername(username);
		if(userEntity != null) {
			return new PrincipalDetails(userEntity);
		}
		
		
		throw new UsernameNotFoundException("사용자를 찾을 수 없습니다: " + username);
	}

	
}
