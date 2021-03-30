package info.kinhho.karaoke_management.lightweight;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import info.kinhho.karaoke_management.dtos.RoomDTO;
import info.kinhho.karaoke_management.entities.Room;
import info.kinhho.karaoke_management.service.RoomService;

@Component
public class RoomCentral {
	
	@Autowired
	private RoomService roomService;
	
	public RoomCentral() { }
	
	public RoomCentral(RoomService roomService) {
		this.roomService = roomService;
	}
	
	public RoomDTO getDTORendering() {
		
		RoomDTO room = new RoomDTO();
		
		List<Room> rooms = roomService.findAllByActive(true);
		room.setRooms(rooms);
		
		return room;
	}
}
