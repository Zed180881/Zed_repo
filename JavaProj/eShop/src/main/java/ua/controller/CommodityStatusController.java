package ua.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import ua.service.CommodityStatusService;

@Controller
public class CommodityStatusController {

    @Autowired
    private CommodityStatusService commodityStatusService;

    @RequestMapping("/admin/comstatus")
    public String showCommodityStatus(Model model) {
	model.addAttribute("commodityStatuses",
		commodityStatusService.findAll());
	return "adminCommodityStatus";
    }

    @RequestMapping(value = "/admin/comstatus", method = RequestMethod.POST)
    public String showCommodityStatus(@RequestParam String name) {
	commodityStatusService.save(name);
	return "redirect:/admin/comstatus";
    }
}
