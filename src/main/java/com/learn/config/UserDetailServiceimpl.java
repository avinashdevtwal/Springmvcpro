package com.learn.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import com.learn.Dao.UserRepository;
import com.learn.model.User;

public class UserDetailServiceimpl implements UserDetailsService {
 
	
	@Autowired
	private UserRepository userrepo;
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
 
	User user=userrepo.getusername(username);
		 if(user==null) {
	throw new UsernameNotFoundException("user not found") ;
		 } 
		 CustomeUserdetail customeuserdetail=new CustomeUserdetail(user);

		 return customeuserdetail;
	}

}
