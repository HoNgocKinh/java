package info.kinhho.karaoke_management.dtos;

import java.util.List;

import info.kinhho.karaoke_management.entities.Room;

public class RoomDTO {
	
	private List<Room> rooms;

	public List<Room> getRooms() {
		return rooms;
	}

	public void setRooms(List<Room> rooms) {
		this.rooms = rooms;
	}
}
