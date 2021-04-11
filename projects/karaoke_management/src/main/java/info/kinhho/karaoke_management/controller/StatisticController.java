package info.kinhho.karaoke_management.controller;

import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping(value = "/statistic")
public class StatisticController {
	
	@RequestMapping(value = {"/", ""}, method = RequestMethod.GET)
	public String index(Model model, Authentication authentication) {
		
		String userLoggedIn = authentication.getName();
		
		model.addAttribute("userLoggedIn", userLoggedIn);
		model.addAttribute("active", "roomprice");
		return "statistic/index";
	}
}
