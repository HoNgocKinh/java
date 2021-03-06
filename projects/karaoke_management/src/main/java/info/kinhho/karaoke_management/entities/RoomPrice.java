package info.kinhho.karaoke_management.entities;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name = "room_price")
public class RoomPrice extends BaseEntity {
	
	private static final long serialVersionUID = 1l;
	
	@Column(name = "typeRoom")
	private String typeRoom;
	
	@Column(name = "price")
	private float price;
	
	@Column(name = "check_in")
	private int checkIn; // hour check-in
	
	@Column(name = "check_out")
	private int checkOut; //hour check-out
	
	@Column(name = "type_day")
	private String typeDay;
	
	@Column(name = "capacity")
	private int capacity;
	
	@ManyToMany(mappedBy = "roomPrices")
	private List<Room> rooms = new ArrayList<Room>();
	
	public RoomPrice() {
				
	}
	
	public RoomPrice(String typeRoom, float price, int checkIn, int checkOut, String typeDay, int capacity) {

		this.typeRoom = typeRoom;
		this.price = price;
		this.checkIn = checkIn;
		this.checkOut = checkOut;
		this.typeDay = typeDay;
		this.capacity = capacity;
	}
	
	public String getTypeRoom() {
		return typeRoom;
	}
	public void setTypeRoom(String typeRoom) {
		this.typeRoom = typeRoom;
	}
	public float getPrice() {
		return price;
	}
	public void setPrice(float price) {
		this.price = price;
	}
	
	public int getCheckIn() {
		return checkIn;
	}

	public void setCheckIn(int checkIn) {
		this.checkIn = checkIn;
	}

	public int getCheckOut() {
		return checkOut;
	}

	public void setCheckOut(int checkOut) {
		this.checkOut = checkOut;
	}

	public String getTypeDay() {
		return typeDay;
	}
	public void setTypeDay(String typeDay) {
		this.typeDay = typeDay;
	}

	public String displayTypeRoom() {
		if (typeRoom.equals("NORMAL")) {
			return "Thường";
		}
		return "VIP";
	}
	
	public String displayTypeDay() {
		if (typeDay.equals("NORMAL")) {
			return "Ngày thường";
		}
		else if (typeDay.equals("WEEKEND")) {
			return "Cuối tuần";
		}
		return "Ngày lễ";
	}
	
	public List<Room> getRooms() {
		return rooms;
	}

	public void setRooms(List<Room> rooms) {
		this.rooms = rooms;
	}

	public int getCapacity() {
		return capacity;
	}

	public void setCapacity(int capacity) {
		this.capacity = capacity;
	}

	@Override
	public String getJsonObject() {
		// TODO Auto-generated method stub
		return "";
	}

	@Override
	public String toString() {
		return "Room_Price [id=" + id + ", typeRoom=" + typeRoom + ", price=" + price + ", checkIn=" + checkIn
				+ ", checkOut=" + checkOut + ", typeDay=" + typeDay + "]";
	}
}
