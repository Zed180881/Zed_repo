package ua.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import ua.service.CommodityOrderService;

@Controller
public class CommodityOrderController {

    @Autowired
    private CommodityOrderService commodityOrderService;

    @RequestMapping("/admin/order")
    public String showCommodityOrder(Model model) {
	model.addAttribute("commodityOrders", commodityOrderService.findAll());
	return "adminCommodityOrder";
    }

    @RequestMapping(value = "/admin/order", method = RequestMethod.POST)
    public String showCommodityOrder(@RequestParam String userName,
	    String orderStatusName, String orderDate, String payDate,
	    String deliveryDate, String commodityModel1,
	    String commodityModel2, String commodityModel3,
	    String commodityModel4, String commodityModel5) {
	commodityOrderService.save(userName, orderStatusName, orderDate,
		payDate, deliveryDate, commodityModel1, commodityModel2,
		commodityModel3, commodityModel4, commodityModel5);
	return "redirect:/admin/order";
    }
}
