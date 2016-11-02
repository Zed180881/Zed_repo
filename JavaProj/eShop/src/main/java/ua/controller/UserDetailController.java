package ua.controller;

import java.security.Principal;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import ua.entity.User;
import ua.service.UserService;
import ua.service.implementation.validators.UserValidator;

@Controller
public class UserDetailController {

    @Autowired
    private UserService userService;    
   
    @InitBinder("user")
    protected void initBinder(WebDataBinder binder) {
	binder.setValidator(new UserValidator(userService));
    }

    @RequestMapping("/userDetails")
    public String showUser(Model model, Principal principal) {
	if (principal==null){
	    return "redirect:/";
	}
	model.addAttribute("user", userService.findOne(Integer.parseInt(principal.getName())));	
	return "userDetails";
    }
    
    @RequestMapping(value = "/updateUserDetails", method = RequestMethod.POST)
    public String saveUser(@ModelAttribute("user") @Valid User user,
	    BindingResult br, Model model, Principal principal) {
	if (principal==null){
	    return "redirect:/";
	}
	if (br.hasErrors()) {
	    model.addAttribute("user", userService.findOne(Integer.parseInt(principal.getName())));
	    return "updateUserDetails";
	}
	userService.save(user);
	return "redirect:/userDetails";
    }

    @RequestMapping("/updateUserDetails")
    public String updateUser(Model model, Principal principal) {
	if (principal==null){
	    return "redirect:/";
	}
	model.addAttribute("user", userService.findOne(Integer.parseInt(principal.getName())));
	return "updateUserDetails";
    }
}
