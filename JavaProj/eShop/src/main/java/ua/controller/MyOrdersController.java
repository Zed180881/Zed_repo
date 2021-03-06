package ua.controller;

import java.security.Principal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import ua.service.CommodityOrderService;
import ua.service.CommodityService;
import ua.service.OrderStatusService;
import ua.service.UserService;

@Controller
public class MyOrdersController {

    @Autowired
    private CommodityOrderService commodityOrderService;

    @Autowired
    private UserService userService;

    @Autowired
    private CommodityService commodityService;

    @Autowired
    private OrderStatusService orderStatusService;    
    
    
    @RequestMapping("/myOrders")
    public String showCommodityOrdersByUser(Model model, Principal principal) {
	if (principal==null){
	    return "redirect:/";
	}
	model.addAttribute("commodityOrders", commodityOrderService.findAllByUser(Integer.parseInt(principal.getName())));	
	return "myOrders";
    }    
}
