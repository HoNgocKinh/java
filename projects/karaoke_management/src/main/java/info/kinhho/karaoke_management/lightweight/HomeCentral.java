package info.kinhho.karaoke_management.lightweight;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.google.gson.Gson;
import com.google.gson.internal.LinkedTreeMap;

import info.kinhho.karaoke_management.dtos.HomeDTO;
import info.kinhho.karaoke_management.entities.Product;
import info.kinhho.karaoke_management.entities.Room;
import info.kinhho.karaoke_management.service.ProductService;
import info.kinhho.karaoke_management.service.RoomService;

@Component
public class HomeCentral {
	
	@Autowired
	private RoomService roomService;
	
	@Autowired
	private ProductService productService;
	
	public HomeDTO getDTORendering() {
		
		HomeDTO home = new HomeDTO();
		List<Room> rooms = roomService.findAllByActive(true);
		List<Product> products = productService.findAllByActive(true);
		List<String> hoursBooking = getHoursBooking();
		
		home.setHierarchyRooms(toHierarchyRooms(rooms));
		home.setHoursBooking(hoursBooking);
		home.setProducts(products);
		return home;
	}
	
	@SuppressWarnings("unchecked")
	public void bookRoom(String requestBody) {
		
		Gson gson = new Gson();
		HashMap<String, Object> obj = gson.fromJson(requestBody, HashMap.class);
		
		LinkedTreeMap<String, String> bookRoomForm = (LinkedTreeMap<String, String>)  obj.get("bookroom");
		System.out.println("123");
		
	}
	private List<String> getHoursBooking() {
		List<String> hoursBooking = new ArrayList<String>();
		
		int START_HOUR_OF_DAY = 0, END_HOUR_OF_DAY = 23;
		
		for (int i = START_HOUR_OF_DAY; i <= END_HOUR_OF_DAY; i++) {
			hoursBooking.add(String.format("%02d:00", i));
			hoursBooking.add(String.format("%02d:30", i));
		}
		return hoursBooking;
	}
	
	private List<List<Room>> toHierarchyRooms(List<Room> rooms) {
		final int ROW_SEPARATE = 3;
		List<List<Room>> hierarchyRooms = new ArrayList<List<Room>>();
		List<Room> newRow = new ArrayList<Room>();
		
		for (int i = 1; i <= rooms.size(); i++) {
			
			newRow.add(rooms.get(i-1));
			if (i % ROW_SEPARATE == 0) {
				hierarchyRooms.add(newRow);
				newRow = new ArrayList<Room>();
			}
		}
		return hierarchyRooms;
	}
}
