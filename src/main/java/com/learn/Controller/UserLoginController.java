package com.learn.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller 
@RequestMapping("/user")
public class UserLoginController {
  
	@RequestMapping("/index")
	public String dashbord() {
		return "udash";
 
	
	
	}
} 

