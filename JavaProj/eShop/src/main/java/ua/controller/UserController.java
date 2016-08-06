package ua.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import ua.service.UserService;

@Controller
public class UserController {

    @Autowired
    private UserService userService;

    @RequestMapping("/admin/user")
    public String showUser(Model model) {
	model.addAttribute("users", userService.findAll());
	return "adminUser";
    }

    @RequestMapping(value = "/admin/user", method = RequestMethod.POST)
    public String showUser(@RequestParam String fullName, String login,
	    String password, String mail, String phone, String address) {
	userService.save(fullName, login, password, mail, phone, address);
	return "redirect:/admin/user";
    }
}
