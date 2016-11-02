package ua.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import ua.entity.OrderStatus;
import ua.service.OrderStatusService;
import ua.service.implementation.validators.OrderStatusValidator;

@Controller
public class OrderStatusController {

    @Autowired
    private OrderStatusService orderStatusService;

    @ModelAttribute("orderStatus")
    public OrderStatus getOrderStatus() {
	return new OrderStatus();
    }

    @InitBinder("orderStatus")
    protected void initBinder(WebDataBinder binder) {
	binder.setValidator(new OrderStatusValidator(orderStatusService));
    }

    @RequestMapping("/admin/ordstatus")
    public String showOrderStatus(Model model) {
	model.addAttribute("orderStatuses", orderStatusService.findAll());
	return "adminOrderStatus";
    }

    @RequestMapping(value = "/admin/ordstatus", method = RequestMethod.POST)
    public String saveOrderStatus(
	    @ModelAttribute("orderStatus") @Valid OrderStatus orderStatus,
	    BindingResult br, Model model) {
	if (br.hasErrors()) {
	    model.addAttribute("orderStatuses", orderStatusService.findAll());
	    return "adminOrderStatus";
	}
	orderStatusService.save(orderStatus);
	return "redirect:/admin/ordstatus";
    }

    @RequestMapping(value = "/admin/ordstatus/delete/{id}")
    public String deleteOrderStatus(@PathVariable int id) {
	try {
	    orderStatusService.deleteById(id);
	    return "redirect:/admin/ordstatus";
	} catch (DataIntegrityViolationException e) {
	    return "redirect:/admin/ordstatus?die=true";
	}
    }

    @RequestMapping("/admin/ordstatus/update/{id}")
    public String updateOrderStatus(@PathVariable int id, Model model) {
	model.addAttribute("orderStatus", orderStatusService.findOne(id));
	model.addAttribute("orderStatuses", orderStatusService.findAll());
	return "adminOrderStatus";
    }
}
