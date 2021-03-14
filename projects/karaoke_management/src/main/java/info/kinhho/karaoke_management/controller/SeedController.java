package info.kinhho.karaoke_management.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import info.kinhho.karaoke_management.service.AccountService;
import info.kinhho.karaoke_management.service.RoomPriceService;
import info.kinhho.karaoke_management.service.RoomService;
import info.kinhho.karaoke_management.service.SupplierService;

@RestController
public class SeedController {
	
	private AccountService accountService;
	private SupplierService supplierService;
	private RoomService roomService;
	private RoomPriceService roomPriceService;
	
	public SeedController(AccountService accountService,
	SupplierService supplierService,
	RoomService roomService,
	RoomPriceService roomPriceService) {
		
		this.accountService = accountService;
		this.supplierService = supplierService;
		this.roomPriceService = roomPriceService;
		this.roomService = roomService;
	}
	
	@RequestMapping(value = "/seed", method = RequestMethod.GET)
	public String seedData() {
		
		this.accountService.createSeedData();
		this.supplierService.createSeedData();
		this.roomPriceService.createSeedData();
		this.roomService.createSeedData();
		return "abc";
	}
}
