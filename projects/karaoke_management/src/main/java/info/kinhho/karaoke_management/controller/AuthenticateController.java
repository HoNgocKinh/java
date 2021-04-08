package info.kinhho.karaoke_management.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import info.kinhho.karaoke_management.service.AccountService;

@Controller
public class AuthenticateController {
	
	@Autowired
	private AccountService accountService;
	
	public AuthenticateController(AccountService accountService) {
		this.accountService = accountService;
	}
	
	public AuthenticateController() { } 
	
	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public String renderLogingPage() {
		
		return "login";
	}
	
	
	@RequestMapping(value = "/reload-accounts", method = RequestMethod.GET)
	@ResponseBody
	public String reloadAccounts() {
		
		this.accountService.deleteAll();
		this.accountService.createSeedData();
		return "Reloaded!";
	}
}
