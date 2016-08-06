package ua.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import ua.service.CommodityService;

@Controller
public class CommodityController {

    @Autowired
    private CommodityService commodityService;

    @RequestMapping("/admin/commodity")
    public String showCommodity(Model model) {
	model.addAttribute("commodities", commodityService.findAll());
	return "adminCommodity";
    }

    @RequestMapping(value = "/admin/commodity", method = RequestMethod.POST)
    public String showCommodity(@RequestParam String categoryName,
	    String model, String producerName, int quantity, double price,
	    String statusName, int warranty) {
	commodityService.save(categoryName, model, producerName, quantity,
		price, statusName, warranty);
	return "redirect:/admin/commodity";
    }
}