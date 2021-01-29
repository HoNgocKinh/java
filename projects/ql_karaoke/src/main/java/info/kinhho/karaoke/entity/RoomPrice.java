package info.kinhho.karaoke.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class RoomPrice {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private String typeRoom;
	private float price;
	private int checkIn; // hour check-in
	private int checkOut; //hour check-out
	private String typeDay;
	
	public RoomPrice() {
				
	}
	
	public RoomPrice(String typeRoom, float price, int checkIn, int checkOut, String typeDay) {

		this.typeRoom = typeRoom;
		this.price = price;
		this.checkIn = checkIn;
		this.checkOut = checkOut;
		this.typeDay = typeDay;
	}
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
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
	
	@Override
	public String toString() {
		return "Room_Price [id=" + id + ", typeRoom=" + typeRoom + ", price=" + price + ", checkIn=" + checkIn
				+ ", checkOut=" + checkOut + ", typeDay=" + typeDay + "]";
	}
}
