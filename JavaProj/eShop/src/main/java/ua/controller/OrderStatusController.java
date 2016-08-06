package ua.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import ua.service.OrderStatusService;

@Controller
public class OrderStatusController {

    @Autowired
    private OrderStatusService orderStatusService;

    @RequestMapping("/admin/ordstatus")
    public String showOrderStatus(Model model) {
	model.addAttribute("orderStatuses",
		orderStatusService.findAll());
	return "adminOrderStatus";
    }

    @RequestMapping(value = "/admin/ordstatus", method = RequestMethod.POST)
    public String showOrderStatus(@RequestParam String name) {
	orderStatusService.save(name);
	return "redirect:/admin/ordstatus";
    }
}
