package info.kinhho.karaoke_management.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import info.kinhho.karaoke_management.dtos.SupplierDTO;
import info.kinhho.karaoke_management.lightweight.SupplierCentral;

@Controller
@RequestMapping(value = "/suppliers")
public class SupplierController {
	
	private SupplierCentral supplierCentral;
	
	public SupplierController(SupplierCentral supplierCentral) {
		this.supplierCentral = supplierCentral;
	}
	
	@RequestMapping(value = {"/", ""}, method = RequestMethod.GET)
	public String index(Model model) {
		
		SupplierDTO supplier = supplierCentral.getDTORendering();
		
		model.addAttribute("supplierDTO", supplier);
		model.addAttribute("active", "supplier");
		
		return "supplier/index";
	}
	
	@RequestMapping(value = "/add", method = RequestMethod.POST)
	public ResponseEntity<Boolean> save(@RequestBody String requestBody) {
		
		supplierCentral.save(requestBody);
		return ResponseEntity.ok(true);
	}
	
	@RequestMapping(value = "/delete/{id}", method = RequestMethod.POST)
	public ResponseEntity<Boolean> delete(@PathVariable("id") Long id) {
		supplierCentral.delete(id);
		return ResponseEntity.ok(true);
	}
	
	@RequestMapping(value = "/unactive/{id}", method = RequestMethod.POST)
	public ResponseEntity<Boolean> unactive(@PathVariable("id") Long id) {
		supplierCentral.unactive(id);
		return ResponseEntity.ok(true);
	}
}
