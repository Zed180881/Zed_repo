package ua.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import ua.entity.Role;
import ua.entity.User;
import ua.form.filter.UserFilter;
import ua.service.UserService;
import ua.service.implementation.validators.UserValidator;

@Controller
public class UserController {

    @Autowired
    private UserService userService;

    @ModelAttribute("user")
    public User getUser() {
	return new User();
    }

    @InitBinder("user")
    protected void initBinder(WebDataBinder binder) {
	binder.setValidator(new UserValidator(userService));
    }

    @RequestMapping("/admin/user")
    public String showUser(Model model,
	    @PageableDefault(size = 10) Pageable pageable,
	    @ModelAttribute("filter") UserFilter filter) {
	model.addAttribute("users", userService.findAll(pageable, filter));
	model.addAttribute("roles", Role.values());
	model.addAttribute("filter", filter);
	return "adminUser";
    }

    @RequestMapping(value = "/admin/user", method = RequestMethod.POST)
    public String saveUser(@ModelAttribute("user") @Valid User user,
	    BindingResult br, Model model,
	    @PageableDefault(size = 10) Pageable pageable) {
	if (br.hasErrors()) {
	    model.addAttribute("users", userService.findAll(pageable));
	    model.addAttribute("roles", Role.values());
	    return "adminUser";
	}
	userService.save(user);
	return "redirect:/admin/user";
    }

    @RequestMapping(value = "/admin/user/delete/{id}")
    public String deleteUser(@PathVariable int id) {
	try {
	    userService.deleteById(id);
	    return "redirect:/admin/user";
	} catch (DataIntegrityViolationException e) {
	    return "redirect:/admin/user?die=true";
	}
    }

    @RequestMapping("/admin/user/update/{id}")
    public String updateUser(@PathVariable int id, Model model,
	    @PageableDefault(size = 10) Pageable pageable) {
	model.addAttribute("user", userService.findOne(id));
	model.addAttribute("users", userService.findAll(pageable));
	model.addAttribute("roles", Role.values());
	return "adminUser";
    }
}
