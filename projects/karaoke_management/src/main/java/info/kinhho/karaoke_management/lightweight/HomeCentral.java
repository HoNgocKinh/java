package info.kinhho.karaoke_management.lightweight;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.google.gson.Gson;
import com.google.gson.internal.LinkedTreeMap;

import info.kinhho.karaoke_management.dtos.HomeDTO;
import info.kinhho.karaoke_management.entities.Account;
import info.kinhho.karaoke_management.entities.BookRoom;
import info.kinhho.karaoke_management.entities.Product;
import info.kinhho.karaoke_management.entities.Room;
import info.kinhho.karaoke_management.errors.Errors;
import info.kinhho.karaoke_management.service.AccountService;
import info.kinhho.karaoke_management.service.BookRoomService;
import info.kinhho.karaoke_management.service.ProductService;
import info.kinhho.karaoke_management.service.RoomService;

@Component
public class HomeCentral {
	
	@Autowired
	private RoomService roomService;
	
	@Autowired
	private ProductService productService;
	
	@Autowired
	private BookRoomService bookRoomService;
	
	@Autowired
	private AccountService accountService;
	
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
	public void bookRoom(String requestBody, String accountUsername) throws Exception {
		
		Account account = accountService.findByUsername(accountUsername);
		
		Gson gson = new Gson();
		HashMap<String, Object> obj = gson.fromJson(requestBody, HashMap.class);
		
		LinkedTreeMap<String, String> bookRoomForm = (LinkedTreeMap<String, String>)  obj.get("bookroom");
		String customerName = bookRoomForm.get("customerName");
		String customerPhone = bookRoomForm.get("customerPhone");
		String notes = bookRoomForm.get("notes");
		String hourBooking = bookRoomForm.get("hourBooking");
		String dateBooking = bookRoomForm.get("dateBooking");
		
		LocalDateTime bookingTime = LocalDateTime.parse(String.format("%sT%s", dateBooking, hourBooking));
		ZonedDateTime bookingTimeWithTimeZone = bookingTime.atZone(ZoneId.systemDefault());
		
		BookRoom bookRoom = new BookRoom();
		bookRoom.setCustomerName(customerName);
		bookRoom.setCustomerPhone(customerPhone);
		bookRoom.setNotes(notes);
		bookRoom.setBookTime(bookingTimeWithTimeZone);
		bookRoom.setAccount(account);
		
		// find rooms has time free at this time.
		List<Room> rooms = roomService.findAllByActive(true);
		
		List<Room> bookedRooms = bookRoomService.findAllByActive(true)
				.stream()
				.parallel()
				.filter(br -> br.getBookTime().isEqual(bookingTimeWithTimeZone))
				.map(br -> br.getRoom())
				.collect(Collectors.toList());
		
		// remove all bookedRooms in set rooms
		rooms.removeAll(bookedRooms);
		// if not have any room already
		if (rooms.isEmpty()) {
			throw new Errors.BOOK_ROOM_ERROR();
		}
		bookRoom.setRoom(rooms.get(0));
		bookRoomService.save(bookRoom);
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
