package com.learn.config;

import java.util.Collection;
import java.util.List;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.learn.model.User;
//login using spring security 
//1 step=provide the implementation of userDetails ie. CustomeUserdetail implements UserDetails 
//2 step=provide the implimentation of uderDetailService ie.Userdetailserice implement userdetailsserviceimpl 
//3 step= write security confi class with all configuration ie, a simple class the extends websecurityConfiguadapter
 
public class CustomeUserdetail implements UserDetails{
 
	private  User user;
	 
	
	
	
	
	
	
	public CustomeUserdetail(User user) {
		super();
		this.user = user;
	}

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
	 SimpleGrantedAuthority simplegranteda=new SimpleGrantedAuthority(user.getRole());
		return List.of(simplegranteda) ;
	}

	@Override
	public String getPassword() {
		return user.getPassword();
	}

	@Override
	public String getUsername() {
		return user.getEmail();
	}

	@Override
	public boolean isAccountNonExpired() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isEnabled() {
		// TODO Auto-generated method stub
		return true;
	}

}
