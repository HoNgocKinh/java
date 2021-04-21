package info.kinhho.karaoke_management.controller;

import java.util.Arrays;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import info.kinhho.karaoke_management.assistants.ServiceResponse;
import info.kinhho.karaoke_management.dtos.HomeDTO;
import info.kinhho.karaoke_management.lightweight.HomeCentral;

@Controller
@RequestMapping(value = "/")
public class HomeController {
	
	private static Logger LOGGER = LoggerFactory.getLogger(HomeController.class);
	private HomeCentral homeCentral;
	
	public HomeController(HomeCentral homeCentral) {
		this.homeCentral = homeCentral;
	}
	
	@RequestMapping(value = {"", "/"}, method = RequestMethod.GET)
	public String index(Model model, Authentication authentication) {
		
		String usernameLoggedIn = authentication.getName();
		SimpleGrantedAuthority[] authorities = authentication.getAuthorities().toArray(new SimpleGrantedAuthority[0]);
		
		LOGGER.info("User Logged In: {}", usernameLoggedIn);
		LOGGER.info("User Authorities: {}", Arrays.toString(authorities));
		
		HomeDTO home = homeCentral.getDTORendering();
		
		model.addAttribute("homeDTO", home);
		model.addAttribute("active", "home");
		model.addAttribute("userLoggedIn", usernameLoggedIn);
		return "index";
	}
	
	@RequestMapping(value = "/api/bookroom", method = RequestMethod.POST)
	public ResponseEntity<String> bookRoom(@RequestBody String requestBody, Authentication authentication) 
			throws Exception {
		
		LOGGER.info("POST /bookroom with params: {}", requestBody);
		
		String username = authentication.getName();
		LOGGER.info("Username: {}", username);
		
		ServiceResponse serviceResponse = homeCentral.bookRoom(requestBody, username);
		return ResponseEntity.ok(serviceResponse.toString());
	}
	
	@RequestMapping(value = "/api/scheduleRoom/{roomid}", method = RequestMethod.POST)
	public ResponseEntity<String> scheduleRoom(@PathVariable("roomid") Long roomId) {
		
		LOGGER.info("POST /scheduleRoom with params: {}", roomId);
		
		ServiceResponse serviceResponse = homeCentral.scheduleRoom(roomId);
		return ResponseEntity.ok(serviceResponse.toString());
	}
}
 