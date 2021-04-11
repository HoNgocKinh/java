package info.kinhho.karaoke_management.controller;

import java.util.Arrays;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping(value = "/roomprice")
public class RoomPriceController {

	private static Logger LOGGER = LoggerFactory.getLogger(RoomPriceController.class);
	
	@RequestMapping(value = {"/", ""}, method = RequestMethod.GET)
	public String index(Model model, Authentication authentication) {
		String userLoggedIn = authentication.getName();
		
		SimpleGrantedAuthority[] authorities = authentication.getAuthorities().toArray(new SimpleGrantedAuthority[0]);
		LOGGER.info("User Authorities at RoomPrice: {}", Arrays.toString(authorities));
		
		model.addAttribute("userLoggedIn", userLoggedIn);
		model.addAttribute("active", "roomprice");
		return "roomprice/index";
	}
}
