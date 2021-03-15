package info.kinhho.karaoke_management.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import info.kinhho.karaoke_management.service.SupplierService;

@Controller
public class RoomController {
	
	private SupplierService supplierService;
	
	public RoomController() {
		
	}
	
	@RequestMapping(value = {"/", "/rooms"}, method = RequestMethod.GET)
	public String index() {
		
		return "room/index";
	}
}
