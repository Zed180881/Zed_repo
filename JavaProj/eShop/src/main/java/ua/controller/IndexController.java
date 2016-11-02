package ua.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import ua.entity.User;
import ua.form.filter.CategoryFilter;
import ua.service.CategoryService;

@Controller
public class IndexController {

    @Autowired
    private CategoryService categoryService;

    @RequestMapping("/")
    public String showIndex(User user, Model model,
	    @PageableDefault(size = 12) Pageable pageable,
	    @ModelAttribute("filter") CategoryFilter filter) {
	model.addAttribute("user", user);
	model.addAttribute("categories",
		categoryService.findAll(pageable, filter));
	model.addAttribute("filter", filter);
	return "index";
    }

    @RequestMapping("/admin")
    public String showAdmin() {
	return "adminPanel";
    }

    @RequestMapping("/login")
    public String login() {
	return "login";
    }

}
