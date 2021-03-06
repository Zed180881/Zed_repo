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

import ua.entity.CommodityStatus;
import ua.service.CommodityStatusService;
import ua.service.implementation.validators.CommodityStatusValidator;

@Controller
public class CommodityStatusController {

    @Autowired
    private CommodityStatusService commodityStatusService;

    @ModelAttribute("commodityStatus")
    public CommodityStatus getCommodityStatus() {
	return new CommodityStatus();
    }

    @InitBinder("commodityStatus")
    protected void initBinder(WebDataBinder binder) {
	binder.setValidator(new CommodityStatusValidator(commodityStatusService));
    }

    @RequestMapping("/admin/comstatus")
    public String showCommodityStatus(Model model) {
	model.addAttribute("commodityStatuses",
		commodityStatusService.findAll());
	return "adminCommodityStatus";
    }

    @RequestMapping(value = "/admin/comstatus", method = RequestMethod.POST)
    public String saveCommodityStatus(
	    @ModelAttribute("commodityStatus") @Valid CommodityStatus commodityStatus,
	    BindingResult br, Model model) {
	if (br.hasErrors()) {
	    model.addAttribute("commodityStatuses",
		    commodityStatusService.findAll());
	    return "adminCommodityStatus";
	}
	commodityStatusService.save(commodityStatus);
	return "redirect:/admin/comstatus";
    }

    @RequestMapping(value = "/admin/comstatus/delete/{id}")
    public String deleteCommodityStatus(@PathVariable int id) {
	try {
	    commodityStatusService.deleteById(id);
	    return "redirect:/admin/comstatus";
	} catch (DataIntegrityViolationException e) {
	    return "redirect:/admin/comstatus?die=true";
	}
    }

    @RequestMapping("/admin/comstatus/update/{id}")
    public String updateCommodityStatus(@PathVariable int id, Model model) {
	model.addAttribute("commodityStatus",
		commodityStatusService.findOne(id));
	model.addAttribute("commodityStatuses",
		commodityStatusService.findAll());
	return "adminCommodityStatus";
    }
}
