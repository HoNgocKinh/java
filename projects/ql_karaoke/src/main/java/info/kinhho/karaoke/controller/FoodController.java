package info.kinhho.karaoke.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import info.kinhho.karaoke.entity.Food;
import info.kinhho.karaoke.entity.Producer;
import info.kinhho.karaoke.services.FoodService;
import info.kinhho.karaoke.services.ProducerService;

@Controller
@RequestMapping("food")
public class FoodController {
	
	private FoodService foodService; // by type!
	private ProducerService producerService;	
	
	public FoodController(FoodService foodService, ProducerService producerService) {
		
		this.foodService = foodService;
		this.producerService = producerService;
	}
	
	@GetMapping(value= {"", "index"})
	public String index(Model model) {
			
		Iterable<Food> foods = foodService.get();
		
		model.addAttribute("foods", foods);
		model.addAttribute("active", "food");
		
		return "food/index";
	}
	
	@GetMapping("add")
	public String getAdd(Model model) {
			
		String actionLink = "food/add";
		String actionName = "Thêm";
		Iterable<Producer> producers = this.producerService.get();
		
		model.addAttribute("actionLink", actionLink);
		model.addAttribute("actionName", actionName);
		model.addAttribute("active", "food");
		model.addAttribute("food", new Food());
		model.addAttribute("producers", producers);
		
		return "food/edit-add";
	}
	
	@PostMapping("add")
	public String postAdd(Food food) {
		
		System.out.println(food);

		foodService.save(food);
		
		return "redirect:index";	
	}
	
	@GetMapping("edit/{id}")
	public String getEdit(@PathVariable("id") String id, Model model) {
		

		Food food = foodService.get(id);
		Iterable<Producer> producers = this.producerService.get();
		
		String actionLink = "food/edit";
		String actionName = "Cập nhật";
		
		model.addAttribute("actionLink", actionLink);
		model.addAttribute("actionName", actionName);
		model.addAttribute("active", "food");
		model.addAttribute("food", food);
		model.addAttribute("producers", producers);
//		
		return "food/edit-add";
	}
	
	@PostMapping("edit")
	public String postEdit(Food food) {
		
		System.out.println(food);   
		foodService.update(food); 		 	
		return "redirect:index";   
	}
	
	@GetMapping("delete/{id}")
	public String getDelete(@PathVariable("id") String id) {
		
		this.foodService.delete(id);
		return "redirect:/food/index";
	}
	
}
