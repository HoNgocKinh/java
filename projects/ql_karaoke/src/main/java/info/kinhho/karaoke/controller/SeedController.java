package info.kinhho.karaoke.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import info.kinhho.karaoke.services.AccountService;
import info.kinhho.karaoke.services.RoomService;

@Controller
public class SeedController {

	private RoomService roomService;
	private AccountService accountService;
	
	public SeedController(RoomService roomService, AccountService accountService) {
		
//		this.producerService = producerService;
		this.roomService = roomService;
		this.accountService = accountService;
	}
	
	@GetMapping("/seed")
	public String seed() {
		
		roomService.createSeedPriceData();
		roomService.createSeedRoomData();
		accountService.createSeedData();
		
		return "/room/home";
	}
}
