package info.kinhho.karaoke_management.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/warehouse")
public class WarehouseController {
	
	@RequestMapping(value = {"", "/"}, method = RequestMethod.GET)
	public String index() {
		
		return "warehouse/index";
	}
}
