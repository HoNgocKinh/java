package info.kinhho.karaoke.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("products")
public class ProductController {
	
//	private ProductService productService; // by type!
//	
//	public ProductController(ProductService productService) {
//		
//		this.productService = productService;
//	}
//	
//	@GetMapping(value= {"", "index"})
//	public String index(Model model) {
//			
//		List<Product> products = productService.get();
//		
//		model.addAttribute("products", products);
//		model.addAttribute("active", "food");
//		
//		return "food/index";
//	}
//	
//	@GetMapping("add")
//	public String getAdd(Model model) {
//			
//		String actionLink = "food/add";
//		String actionName = "Thêm";
//		Iterable<Producer> producers = this.producerService.get();
//		
//		model.addAttribute("actionLink", actionLink);
//		model.addAttribute("actionName", actionName);
//		model.addAttribute("active", "food");
//		model.addAttribute("food", new Food());
//		model.addAttribute("producers", producers);
//		
//		return "food/edit-add";
//	}
//	
//	@PostMapping("add")
//	public String postAdd(Food food) {
//		
//		System.out.println(food);
//
//		foodService.save(food);
//		
//		return "redirect:index";	
//	}
//	
//	@GetMapping("edit/{id}")
//	public String getEdit(@PathVariable("id") String id, Model model) {
//		
//
//		Food food = foodService.get(id);
//		Iterable<Producer> producers = this.producerService.get();
//		
//		String actionLink = "food/edit";
//		String actionName = "Cập nhật";
//		
//		model.addAttribute("actionLink", actionLink);
//		model.addAttribute("actionName", actionName);
//		model.addAttribute("active", "food");
//		model.addAttribute("food", food);
//		model.addAttribute("producers", producers);
////		
//		return "food/edit-add";
//	}
//	
//	@PostMapping("edit")
//	public String postEdit(Food food) {
//		
//		System.out.println(food);   
//		foodService.update(food); 		 	
//		return "redirect:index";   
//	}
//	
//	@GetMapping("delete/{id}")
//	public String getDelete(@PathVariable("id") String id) {
//		
//		this.foodService.delete(id);
//		return "redirect:/food/index";
//	}
	
}
