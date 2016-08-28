package ua.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import ua.entity.Producer;
import ua.form.filter.ProducerFilter;
import ua.service.ProducerService;
import ua.service.implementation.validators.ProducerValidator;

@Controller
public class ProducerController {

    @Autowired
    private ProducerService producerService;

    @ModelAttribute("producer")
    public Producer getProducer() {
	return new Producer();
    }

    @InitBinder("producer")
    protected void initBinder(WebDataBinder binder) {
	binder.setValidator(new ProducerValidator(producerService));
    }

    @RequestMapping("/admin/producer")
    public String showProducer(Model model,
	    @PageableDefault(size = 10) Pageable pageable,
	    @ModelAttribute("filter") ProducerFilter filter) {
	model.addAttribute("producers",
		producerService.findAll(pageable, filter));
	model.addAttribute("filter", filter);
	return "adminProducer";
    }

    @RequestMapping(value = "/admin/producer", method = RequestMethod.POST)
    public String saveProducer(
	    @ModelAttribute("producer") @Valid Producer producer,
	    BindingResult br, Model model,
	    @PageableDefault(size = 10) Pageable pageable) {
	if (br.hasErrors()) {
	    model.addAttribute("producers", producerService.findAll(pageable));
	    return "adminProducer";
	}
	producerService.save(producer);
	return "redirect:/admin/producer";
    }

    @RequestMapping(value = "/admin/producer/delete/{id}")
    public String deleteProducer(@PathVariable int id) {
	producerService.deleteById(id);
	return "redirect:/admin/producer";
    }

    @RequestMapping("/admin/producer/update/{id}")
    public String updateProducer(@PathVariable int id, Model model,
	    @PageableDefault(size = 10) Pageable pageable) {
	model.addAttribute("producer", producerService.findOne(id));
	model.addAttribute("producers", producerService.findAll(pageable));
	return "adminProducer";
    }
}
