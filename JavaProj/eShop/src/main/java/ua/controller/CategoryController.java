package ua.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import ua.service.CategoryService;

@Controller
public class CategoryController {

    @Autowired
    private CategoryService categoryService;

    @RequestMapping("/admin/category")
    public String showCategory(Model model) {
	model.addAttribute("categories", categoryService.findAll());
	return "adminCategory";
    }

    @RequestMapping(value = "/admin/category", method = RequestMethod.POST)
    public String showCategory(@RequestParam String name) {
	categoryService.save(name);
	return "redirect:/admin/category";
    }
}
