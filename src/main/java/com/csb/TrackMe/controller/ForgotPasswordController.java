package com.csb.TrackMe.controller;

import com.csb.TrackMe.dto.UserDTO;
import com.csb.TrackMe.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;

@Controller
@RequestMapping("forgot-password")
public class ForgotPasswordController {

	@Autowired
	 UserService userService;

	@GetMapping
	private String index(Model model) {
		model.addAttribute("user", new UserDTO());
		return "forgot-password/index";
	}
    
    @PostMapping
    private String update(@Valid @ModelAttribute("user") UserDTO user, BindingResult bindingResult, Model model) {
    	if (bindingResult.hasErrors())
    	{   		
    		 return "forgot-password/index";
    	}
    	
    	if (! user.getPassword().equals(user.getForgotPassword()))
    	{
    		bindingResult.addError(new ObjectError("password", "password and confirm password is not the same")); 
    		
    		 return "forgot-password/index";
    	} 
    	
    	userService.updatePassword(user);
    	
    	return "login/index";
    }
 
}
