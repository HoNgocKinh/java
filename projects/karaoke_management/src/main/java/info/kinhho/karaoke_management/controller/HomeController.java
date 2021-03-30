package info.kinhho.karaoke_management.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import info.kinhho.karaoke_management.lightweight.HomeCentral;
import info.kinhho.karaoke_management.service.SupplierService;

@Controller
@RequestMapping(value = "/")
public class HomeController {
	
	private HomeCentral homeCentral;
	
	public HomeController(HomeCentral homeCentral) {
		this.homeCentral = homeCentral;
	}
	
	@RequestMapping(value = {"", "/"}, method = RequestMethod.GET)
	public String index() {
		
		return "index";
	}
}
