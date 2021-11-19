package br.com.global.donatefoodv2.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import br.com.global.donatefoodv2.model.Company;
import br.com.global.donatefoodv2.repository.CompanyRepository;

@Controller
public class DonateFoodController {

	@Autowired
	private CompanyRepository repository;

	@GetMapping("/product")
	public ModelAndView index() {
		ModelAndView modelAndView = new ModelAndView("products");
		List<Company> companies = repository.findAll();
		modelAndView.addObject("companies", companies);
		return modelAndView;
	}

	@PostMapping("/donate")
	public String save(@Valid Company company, BindingResult result, RedirectAttributes redirect) {
		if(result.hasErrors()) 
			return "companies-new";
		repository.save(company);		
		return "redirect:/";
	}

	@RequestMapping("/companies/register")
	public String create(Company company) {
		return "companies-new";
	}

}
