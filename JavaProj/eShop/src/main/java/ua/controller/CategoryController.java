package ua.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import ua.entity.Category;
import ua.service.CategoryService;
import ua.service.implementation.validators.CategoryValidator;

@Controller
public class CategoryController {

    @Autowired
    private CategoryService categoryService;

    @ModelAttribute("category")
    public Category getCategory() {
	return new Category();
    }

    @InitBinder("category")
    protected void initBinder(WebDataBinder binder) {
	binder.setValidator(new CategoryValidator(categoryService));
    }

    @RequestMapping("/admin/category")
    public String showCategory(Model model) {
	model.addAttribute("categories", categoryService.findAll());
	return "adminCategory";
    }

    @RequestMapping(value = "/admin/category", method = RequestMethod.POST)
    public String saveCategory(
	    @ModelAttribute("category") @Valid Category category,
	    BindingResult br, Model model) {
	if (br.hasErrors()) {
	    model.addAttribute("categories", categoryService.findAll());
	    return "adminCategory";
	}
	categoryService.save(category);
	return "redirect:/admin/category";
    }

    @RequestMapping(value = "/admin/category/delete/{id}")
    public String deleteCategory(@PathVariable int id) {
	categoryService.deleteById(id);
	return "redirect:/admin/category";
    }

    @RequestMapping("/admin/category/update/{id}")
    public String updateCategory(@PathVariable int id, Model model) {
	model.addAttribute("category", categoryService.findOne(id));
	model.addAttribute("categories", categoryService.findAll());
	return "adminCategory";
    }
}
