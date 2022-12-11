package com.learn.Controller;

import java.util.Date;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.learn.Dao.UserRepository;
import com.learn.helper.Message;
import com.learn.model.User;


@Controller
public class UserController {
	 
	
	
	@Autowired
	private UserRepository userepo;
	 @Autowired
	private BCryptPasswordEncoder passwordencoder; 
	 
	
	@RequestMapping("/")
	public String home(Model model) {
		model.addAttribute("title", "home:Smart Contact Manager");
		return "home";
	}

	@RequestMapping("/about")
	public String about(Model model) {
		model.addAttribute("title", "about-Smart Contact Manager");
		return "about";
	}

	@RequestMapping("/signin")
	public String login(Model model) {
		model.addAttribute("title", "signin");
		model.addAttribute("currentdate", new Date());
		return "login";
	}

	@RequestMapping("/signup")
	public String signup(Model model) {
		model.addAttribute("title", "register-Smart Contact Manager");
		model.addAttribute("user", new User());
		return "signup";
	}

	
	//handle method for register 
	@PostMapping("/do_register")
	public String registeruser(@Valid @ModelAttribute("user") User user,
			@RequestParam(value = "agreement", defaultValue = "false") boolean agreement, Model model,BindingResult result1,HttpSession session) {
		try {
			 if(!agreement) {
			 System.out.println("you are not agree term and condition");
		 throw new Exception("you are not agree term and condition");
			 }
			 if(result1.hasErrors()) {
			 System.out.println("ERROR"+result1.toString()); 
			 return "signup"; 
			 }
			  
			 user.setRole("ROLE_USER");
			user.setEnable(true);
			 user.setPassword(passwordencoder.encode(user.getPassword()));
			System.out.println("Agreement"+agreement);
			System.out.println("user"+user);

			User result =this.userepo.save(user);
			model.addAttribute("user",new User());
			session.setAttribute("message",new Message("successfuly register","alert-success"));
			return "signup";
			
		} catch (Exception e) {
		e.printStackTrace();
		model.addAttribute("user",user); 
		session.setAttribute("message",new Message("something went wrong!!"+e.getMessage(),"alert-danger"));
		return "signup";

		}

	}

}