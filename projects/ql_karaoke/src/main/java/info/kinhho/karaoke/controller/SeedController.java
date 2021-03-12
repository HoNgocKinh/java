package info.kinhho.karaoke.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import info.kinhho.karaoke.services.AccountService;
import info.kinhho.karaoke.services.RoomService;
import info.kinhho.karaoke.services.SupplierService;

@Controller
public class SeedController {

	private RoomService roomService;
	private AccountService accountService;
	private SupplierService supplierService;
	
	public SeedController(
			RoomService roomService, 
			AccountService accountService,
			SupplierService supplierService) {
		
		this.roomService = roomService;
		this.accountService = accountService;
		this.supplierService = supplierService;
	}
	
	@GetMapping("/seed")
	public String seed() {
		
//		roomService.createSeedPriceData();
//		roomService.createSeedRoomData();
//		accountService.createSeedData();
//		supplierService.createSeedData();
		
		return "/room/home";
	}
}
