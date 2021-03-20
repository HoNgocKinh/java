package info.kinhho.karaoke_management.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import info.kinhho.karaoke_management.service.SupplierService;

@Controller
@RequestMapping(value = "/")
public class HomeController {
	
	private SupplierService supplierService;
	
	public HomeController(SupplierService supplierService) {
		this.supplierService = supplierService;
	}
	
	@RequestMapping(value = {"", "/"}, method = RequestMethod.GET)
	public String index() {
		
		return "index";
	}
}
