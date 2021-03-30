package info.kinhho.karaoke_management.lightweight;

import org.springframework.stereotype.Component;

import info.kinhho.karaoke_management.dtos.HomeDTO;
import info.kinhho.karaoke_management.service.RoomService;

@Component
public class HomeCentral {
	
	private RoomService roomService;
	
	public HomeDTO getDTORendering() {
		
		
		return null;
	}
}
