package info.kinhho.karaoke.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import info.kinhho.karaoke.entity.Supplier;
import info.kinhho.karaoke.services.SupplierService;

@Controller
@RequestMapping("suppliers")
public class SupplierController {
	
	private SupplierService service;
	
	public SupplierController(SupplierService service) {
		this.service = service;
	}
	
	@GetMapping(value= {"", "index"})
	public String getIndex(Model model) {
			
		List<Supplier> suppliers = service.findAll();
				
		model.addAttribute("suppliers", suppliers);
		model.addAttribute("active", "supplier");
		
		return "producer/index";
	}
	
//	
//	@GetMapping("add")
//	public String getAdd(Model model) {
//			
//		String actionLink = "producer/add";
//		String actionName = "Thêm";
//		
//		model.addAttribute("actionLink", actionLink);
//		model.addAttribute("actionName", actionName);
//		model.addAttribute("producer", new Producer());
//		model.addAttribute("active", "producer");
//		
//		return "producer/edit-add";
//	}
//	
//	@PostMapping("add")
//	public String postAdd(Producer producer) {
//		
//		producerService.save(producer);
//		
//		return "redirect:index";	
//	}
//	
//	@GetMapping("edit/{id}")
//	public String getEdit(@PathVariable("id") String id, Model model) {
//		
//		
//		Producer producer = producerService.get(id);
//		String actionLink = "producer/edit";
//		String actionName = "Cập nhật";
//		
//		model.addAttribute("actionLink", actionLink);
//		model.addAttribute("actionName", actionName);
//		model.addAttribute("producer", producer);
//		
//		return "producer/edit-add";
//	}
//	
//	@PostMapping("edit")
//	public String postEdit(Producer producer) {
//		
//		producerService.update(producer);
//				
//		return "redirect:index";
//	}
//	
//	@GetMapping("delete/{id}")
//	public String getDelete(@PathVariable("id") String id, Model model) {
//		
//		this.producerService.delete(id);
//		
//		return "redirect:/producer/index";
//	}
}