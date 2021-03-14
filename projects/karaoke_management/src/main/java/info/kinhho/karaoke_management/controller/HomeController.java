package info.kinhho.karaoke_management.controller;

import java.util.List;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import info.kinhho.karaoke_management.entities.Supplier;
import info.kinhho.karaoke_management.service.SupplierService;

@RestController
public class HomeController {
	
	private SupplierService supplierService;
	
	public HomeController() {
		
	}
	
	public HomeController(SupplierService supplierService) {
		this.supplierService = supplierService;
	}
	
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public List<Supplier> findAll() {
		
		return this.supplierService.findAll();
	}
}
