package info.kinhho.karaoke_management.dtos;

import java.time.ZonedDateTime;
import java.util.List;

import info.kinhho.karaoke_management.assistants.DateFormatter;
import info.kinhho.karaoke_management.entities.Product;
import info.kinhho.karaoke_management.entities.Room;

public class HomeDTO {
	
	private List<List<Room>> hierarchyRooms;
	private List<String> hoursBooking;
	private ZonedDateTime today = ZonedDateTime.now();
	private List<Product> products;
	
	public List<List<Room>> getHierarchyRooms() {	
		return hierarchyRooms;
	}

	public void setHierarchyRooms(List<List<Room>> hierarchyRooms) {
		this.hierarchyRooms = hierarchyRooms;
	}

	public List<String> getHoursBooking() {
		return hoursBooking;
	}

	public void setHoursBooking(List<String> hoursBooking) {
		this.hoursBooking = hoursBooking;
	}

	public String getToday() {
		return DateFormatter.format(today, "YYYY/MM/dd HH:mm");
	}

	public List<Product> getProducts() {
		return products;
	}

	public void setProducts(List<Product> products) {
		this.products = products;
	}
}
