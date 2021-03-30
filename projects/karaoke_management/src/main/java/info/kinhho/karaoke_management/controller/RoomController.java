package info.kinhho.karaoke_management.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import info.kinhho.karaoke_management.dtos.RoomDTO;
import info.kinhho.karaoke_management.lightweight.RoomCentral;
import info.kinhho.karaoke_management.service.RoomPriceService;
import info.kinhho.karaoke_management.service.RoomService;

@Controller
@RequestMapping(value = {"/rooms"})
public class RoomController {
	
	private RoomCentral roomCentral;
	
	public RoomController(RoomCentral roomCentral) {
		this.roomCentral = roomCentral;
	}
	
	@RequestMapping(value = {"", "/"}, method = RequestMethod.GET)
	public String index(Model model) {
		
		RoomDTO room = roomCentral.getDTORendering();
		
		model.addAttribute("roomDTO", room);
		model.addAttribute("active", "rooms");
		
		
		return "room/index";
	}
}
