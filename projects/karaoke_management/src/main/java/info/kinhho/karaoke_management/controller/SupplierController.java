package info.kinhho.karaoke_management.controller;

import java.time.ZonedDateTime;
import java.util.List;
import java.util.Objects;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import info.kinhho.karaoke_management.dtos.SupplierDTO;
import info.kinhho.karaoke_management.service.SupplierService;

@Controller
@RequestMapping(value = "/suppliers")
public class SupplierController {
	
	private SupplierService supplierService;
	
	public SupplierController(SupplierService supplierService) {
		this.supplierService = supplierService;
	}
	
	@RequestMapping(value = {"/", ""}, method = RequestMethod.GET)
	public String index(Model model) {
		
		List<SupplierDTO> suppliers = supplierService.findAllByActive(true);
		
		model.addAttribute("suppliers", suppliers);
		model.addAttribute("active", "supplier");
		
		return "supplier/index";
	}
	
	@RequestMapping(value = "/add", method = RequestMethod.POST)
	public String save(SupplierDTO dtoForm) {
		
		if (Objects.isNull(dtoForm.getId())) {
			dtoForm.setCreatedAt(ZonedDateTime.now());
			dtoForm.setUpdateAt(ZonedDateTime.now());
			dtoForm.setActive(true);
			supplierService.save(dtoForm);
		}
		else {
			SupplierDTO supplierDTO = supplierService.findById(dtoForm.getId());
			supplierDTO.setName(dtoForm.getName());
			supplierDTO.setPhone(dtoForm.getPhone());
			supplierDTO.setAddress(dtoForm.getAddress());
			supplierDTO.setUpdateAt(ZonedDateTime.now());
			supplierService.save(supplierDTO);
		}
		return "redirect:/suppliers";
	}
	
	@RequestMapping(value = "/delete/{id}", method = RequestMethod.POST)
	public boolean delete(@PathVariable("id") Long id) {
		supplierService.delete(id);
		return true;
	}
	
	@RequestMapping(value = "/unactive/{id}", method = RequestMethod.POST)
	public boolean unactive(@PathVariable("id") Long id) {
		supplierService.unactive(id);
		return true;
	}
}
