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
import ua.entity.Producer;
import ua.entity.CommodityStatus;
import ua.form.CommodityForm;
import ua.service.CategoryService;
import ua.service.CommodityService;
import ua.service.CommodityStatusService;
import ua.service.ProducerService;
import ua.service.implementation.editor.CategoryEditor;
import ua.service.implementation.editor.CommodityStatusEditor;
import ua.service.implementation.editor.ProducerEditor;
import ua.service.implementation.validators.CommodityValidator;

@Controller
public class CommodityController {

    @Autowired
    private CommodityService commodityService;

    @Autowired
    private CategoryService categoryService;

    @Autowired
    private ProducerService producerService;

    @Autowired
    private CommodityStatusService commodityStatusService;

    @InitBinder("commodity")
    protected void initBinder(WebDataBinder binder) {
	binder.setValidator(new CommodityValidator(commodityService));
	binder.registerCustomEditor(Category.class, new CategoryEditor(
		categoryService));
	binder.registerCustomEditor(Producer.class, new ProducerEditor(
		producerService));
	binder.registerCustomEditor(CommodityStatus.class,
		new CommodityStatusEditor(commodityStatusService));
    }

    @ModelAttribute("commodity")
    public CommodityForm getCommodity() {
	return new CommodityForm();
    }

    @RequestMapping("/admin/commodity")
    public String showCommodity(Model model) {
	model.addAttribute("commodities", commodityService.findAll());
	model.addAttribute("categories", categoryService.findAll());
	model.addAttribute("producers", producerService.findAll());
	model.addAttribute("commodityStatuses",
		commodityStatusService.findAll());
	return "adminCommodity";
    }

    @RequestMapping(value = "/admin/commodity", method = RequestMethod.POST)
    public String saveCommodity(
	    @ModelAttribute("commodity") @Valid CommodityForm commodityForm,
	    BindingResult br, Model model) {
	if (br.hasErrors()) {
	    model.addAttribute("commodities", commodityService.findAll());
	    model.addAttribute("categories", categoryService.findAll());
	    model.addAttribute("producers", producerService.findAll());
	    model.addAttribute("commodityStatuses",
		    commodityStatusService.findAll());
	    return "adminCommodity";
	}
	commodityService.save(commodityForm);
	return "redirect:/admin/commodity";
    }

    @RequestMapping(value = "/admin/commodity/delete/{id}")
    public String deleteCommodity(@PathVariable int id) {
	commodityService.deleteById(id);
	return "redirect:/admin/commodity";
    }

    @RequestMapping("/admin/commodity/update/{id}")
    public String updateCommodity(@PathVariable int id, Model model) {
	model.addAttribute("categories", categoryService.findAll());
	model.addAttribute("producers", producerService.findAll());
	model.addAttribute("commodityStatuses",
		commodityStatusService.findAll());
	model.addAttribute("commodities", commodityService.findAll());
	model.addAttribute("commodity", commodityService.findOneForm(id));
	return "adminCommodity";
    }
}
