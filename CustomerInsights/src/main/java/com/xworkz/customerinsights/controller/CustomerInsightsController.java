package com.xworkz.customerinsights.controller;

import static com.xworkz.customerinsights.configuration.Loggers.getLogger;

import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.xworkz.customerinsights.dto.CustomerInsightsDto;
import com.xworkz.customerinsights.entity.CustomerInsightsEntity;
import com.xworkz.customerinsights.service.CustomerInsightsService;

@Component
@RequestMapping("/")
public class CustomerInsightsController {
	
	@Autowired
	CustomerInsightsService service;
	private Logger logger=getLogger();

	public CustomerInsightsController() {
	logger.info("Started "+this.getClass().getSimpleName());
	}

	@RequestMapping("/onSave")
	public String save(CustomerInsightsDto dto,Model model) {
		System.out.println(dto);
		
		System.out.println(dto.getPassword().length());
		System.out.println(dto.getConfirmPassword().length());
		logger.info("Data is in customer controller");
//		model.addAttribute("", model)
		return service.save(dto, model);
		
		
		
	}
	
	@RequestMapping("/logIn")
	public String logIn(String email,String password,Model model) {
		return service.login(email,password, model);
		
	}
	
	@RequestMapping("/forgotPassword")
	public String forgotPassword(String email,Model model) {
	String	res= service.forgotPassword(email,model);
	
		if(res!=null) {
			model.addAttribute("getEmail",res);
		return "EnterOtp";
		}
		return "ForgotPassword";
	}
	
	@RequestMapping("/validateOtp")
	public String validateOtpByEmail(String email,int otp,Model model) {
		logger.info("iam in otp validation controller");
	boolean	res=service.validateOtpByEmail(email,otp,model);
	
	if(res){
		logger.info("Successfully validated");
		return "ResetPassword";
	}
	else {
		logger.info("Validation failed");
		return "EnterOtp";
	}
	}
	
	@RequestMapping("/resetPassword")
	public String resetPasswordByEmail(String email,String password,String confirmPassword,Model model,CustomerInsightsEntity entity) {
		boolean	res=service.resetPasswordByEmail(email,password,confirmPassword,model, entity);	
		logger.info(password);
		logger.info(confirmPassword);
		if(res) {
			System.out.println("password reset Successfull");
			return "ResetPassword";
		}
		else {
			logger.info("Password reset failed");
			return "ResetPassword";
		}
	}
	
}
