package com.security.config;

import java.util.Arrays;
import java.util.Collection;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.security.model.UserDtls;

public class MyUserDetails implements UserDetails {

	private UserDtls userdtls;
	public MyUserDetails(UserDtls userdtls) {
		this.userdtls=userdtls;
	}

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		SimpleGrantedAuthority authority= new SimpleGrantedAuthority("USER");
		return Arrays.asList(authority);
	}

	@Override
	public String getPassword() {
		// TODO Auto-generated method stub
		return userdtls.getPassword();
	}

	@Override
	public String getUsername() {
		// TODO Auto-generated method stub
		return userdtls.getUsername();
	}

}
