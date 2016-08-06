package ua.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import ua.service.ProducerService;

@Controller
public class ProducerController {

    @Autowired
    private ProducerService producerService;

    @RequestMapping("/admin/producer")
    public String showProducer(Model model) {
	model.addAttribute("producers", producerService.findAll());
	return "adminProducer";
    }

    @RequestMapping(value = "/admin/producer", method = RequestMethod.POST)
    public String showProducer(@RequestParam String name) {
	producerService.save(name);
	return "redirect:/admin/producer";
    }
}