package info.kinhho.karaoke_management.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import info.kinhho.karaoke_management.dtos.RoomDTO;
import info.kinhho.karaoke_management.dtos.RoomPriceDTO;
import info.kinhho.karaoke_management.service.RoomPriceService;
import info.kinhho.karaoke_management.service.RoomService;

@Controller
@RequestMapping(value = {"/rooms"})
public class RoomController {
	
	private RoomService roomService;
	private RoomPriceService roomPriceService;
	
	public RoomController(RoomService roomService, RoomPriceService roomPriceService) {
		this.roomPriceService = roomPriceService;
		this.roomService = roomService;
	}
	
	@RequestMapping(value = {"", "/"}, method = RequestMethod.GET)
	public String index(Model model) {
		
		List<RoomDTO> rooms = roomService.findAll();
		List<RoomPriceDTO> roomPrices = roomPriceService.findAll();
		
		model.addAttribute("rooms", rooms);
		model.addAttribute("roomPrices", roomPrices);
		model.addAttribute("active", "rooms");
		return "room/index";
	}
}
