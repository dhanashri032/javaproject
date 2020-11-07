package com.cdac.cntr;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.MailSender;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.cdac.Service.AdminService;
import com.cdac.dto.Admin;
import com.cdac.valid.AdminValidator;

@Controller
public class AdminController {

	@Autowired
	private MailSender mailSender;

	@Autowired
	private AdminService adminService;

	@Autowired
	private AdminValidator adminValidator;
	
	@RequestMapping(value = "/prep_reg_form.htm",method = RequestMethod.GET)
	public String prepRegForm(ModelMap map) {
		map.put("admin", new Admin());
		return "reg_form";
		
	}
	
	@RequestMapping(value = "/reg.htm",method = RequestMethod.POST)
	public String register(Admin admin,ModelMap map) {
		adminService.addAdmin(admin);
		return "index";
		
	}
	
	@RequestMapping(value = "/prep_log_form.htm",method = RequestMethod.GET)
	public String prepLogForm(ModelMap map) {
		map.put("admin", new Admin());
		return "login_form";
		
	} 
	
	@RequestMapping(value = "/login.htm",method = RequestMethod.POST)
	public String login(Admin admin,BindingResult result,ModelMap map,HttpSession session) {
		
		adminValidator.validate(admin, result);
		if(result.hasErrors()) {
			return "login_form";
		}
		
		boolean b = adminService.findAdmin(admin);
		if(b) {
			session.setAttribute("admin", admin);
			return "home";
		}else {
			map.put("admin", new Admin());
			return "login_form";
		}
	}
	
	
	@RequestMapping(value = "/forgot_password.htm",method = RequestMethod.POST)
	public String forgotPassword(@RequestParam String userName,ModelMap map) {		
		String pass = adminService.forgotPassword(userName);
		String msg = "you are not registered";
		if(pass!=null) {	
			
			SimpleMailMessage message = new SimpleMailMessage();  
	        message.setFrom("dhanashripatil8017@gmail.com");  
	        message.setTo(userName);  
	        message.setSubject("Your password");  
	        message.setText(pass);  
	        //sending message   
	       mailSender.send(message);
			msg = "check the mail for password";
		}
		map.put("msg", msg);
		return "info";
	}
	
	@RequestMapping(value = "/logout.htm",method = RequestMethod.GET)
	public String logout() {
		return "logout";
		
	}
	
}
