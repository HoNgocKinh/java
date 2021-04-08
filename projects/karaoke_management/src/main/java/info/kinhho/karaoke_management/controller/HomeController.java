package info.kinhho.karaoke_management.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import info.kinhho.karaoke_management.dtos.HomeDTO;
import info.kinhho.karaoke_management.lightweight.HomeCentral;

@Controller
@RequestMapping(value = "/")
public class HomeController {
	
	private HomeCentral homeCentral;
	
	public HomeController(HomeCentral homeCentral) {
		this.homeCentral = homeCentral;
	}
	
	@RequestMapping(value = {"", "/"}, method = RequestMethod.GET)
	public String index(Model model) {
		
		HomeDTO home = homeCentral.getDTORendering();
		
		model.addAttribute("homeDTO", home);
		model.addAttribute("active", "home");
		return "index";
	}
	
	@RequestMapping(value = "/bookroom", method = RequestMethod.POST)
	public ResponseEntity<Boolean> bookRoom(@RequestBody String requestBody) {
		
		homeCentral.bookRoom(requestBody);
		return ResponseEntity.ok(true);
	}
}
