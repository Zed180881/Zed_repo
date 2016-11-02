package ua.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import ua.form.filter.CommodityFilter;
import ua.service.CategoryService;
import ua.service.CommodityService;
import ua.service.CommodityStatusService;
import ua.service.ProducerService;

@Controller
public class CategoryViewController {

    @Autowired
    private CommodityService commodityService;
    
    @Autowired
    private CategoryService categoryService;

    @Autowired
    private ProducerService producerService;

    @Autowired
    private CommodityStatusService commodityStatusService;

    @RequestMapping("/categoryView/{categoryId}")
    public String showCategoryView(@PathVariable int categoryId, Model model,
	    @PageableDefault(size = 12) Pageable pageable,
	    @ModelAttribute("filter") CommodityFilter filter) {
	filter.setCommodityStatusId(1);
	filter.setCategoryId(categoryId);
	model.addAttribute("commodities",
		commodityService.findAll(pageable, filter));
	model.addAttribute("categories", categoryService.findAll());
	model.addAttribute("producers", producerService.findAll());
	model.addAttribute("commodityStatuses",
		commodityStatusService.findAll());
	model.addAttribute("filter", filter);
	return "categoryView";
    }
    
    @RequestMapping("/categoryView")
    public String showCategoryViewWithFilter(Model model,
	    @PageableDefault(size = 12) Pageable pageable,
	    @ModelAttribute("filter") CommodityFilter filter) {
	filter.setCommodityStatusId(1);
	model.addAttribute("commodities",
		commodityService.findAll(pageable, filter));
	model.addAttribute("categories", categoryService.findAll());
	model.addAttribute("producers", producerService.findAll());
	model.addAttribute("commodityStatuses",
		commodityStatusService.findAll());
	model.addAttribute("filter", filter);
	return "categoryView";
    }
}
