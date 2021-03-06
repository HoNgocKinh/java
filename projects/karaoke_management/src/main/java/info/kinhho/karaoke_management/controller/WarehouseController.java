package info.kinhho.karaoke_management.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import info.kinhho.karaoke_management.dtos.WarehouseDTO;
import info.kinhho.karaoke_management.lightweight.WarehouseCentral;

@Controller
@RequestMapping("/warehouse")
public class WarehouseController {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(WarehouseController.class);

	private WarehouseCentral warehouseCentral;
	
	public WarehouseController(WarehouseCentral warehouseCentral) {
		this.warehouseCentral = warehouseCentral;
	}
	
	@RequestMapping(value = {"", "/"}, method = RequestMethod.GET)
	public String index(Model model, Authentication authentication) {
		
		String userLoggedIn = authentication.getName();
		LOGGER.info("Inventory Index method - path: /warehouse/");
		
		WarehouseDTO warehouse = warehouseCentral.getDTORendering();
				
		model.addAttribute("warehouse", warehouse);
		model.addAttribute("active", "warehouse");
		model.addAttribute("userLoggedIn", userLoggedIn);
		return "warehouse/index";
	}
	
	@RequestMapping(value = "/add", method = RequestMethod.POST)
	public ResponseEntity<String> add(@RequestBody String requestBody) {
		
		LOGGER.info("Inventory Add method - path: /warehouse/add");
				
		return ResponseEntity.ok(warehouseCentral.save(requestBody));
	}
	
	@RequestMapping(value = "/delete/{id}", method = RequestMethod.POST)
	public ResponseEntity<Boolean> delete(@PathVariable("id") Long id) {
		
		LOGGER.info("Inventory Delete method - path: /warehouse/delete");
		warehouseCentral.delete(id);
		return ResponseEntity.ok(true);
	}
	
	@RequestMapping(value = "/unactive/{id}", method = RequestMethod.POST)
	public ResponseEntity<Boolean> unactive(@PathVariable("id") Long id) {
		
		warehouseCentral.unactive(id);
		return ResponseEntity.ok(true);
	}
}
