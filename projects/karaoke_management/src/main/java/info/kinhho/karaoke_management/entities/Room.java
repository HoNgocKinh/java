package info.kinhho.karaoke_management.entities;

import java.text.SimpleDateFormat;
import java.time.ZonedDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Transient;

@Entity
@Table(name = "room")
public class Room extends BaseEntity {

	private static final long serialVersionUID = 1L;
	
	@Column(name = "name")
	private String name;
	
	@Column(name = "floor")
	private int floor;
	
	@Column(name = "type")
	private String type;
	
	@Column(name = "capacity")
	private int capacity;
	
	/**
	 * Check Status of Room when order...
	 */
	@Column(name = "status")
	private String status;
	
	/**
	 * Time actually when customer receive room from staff.
	 */
	@Column(name = "check_in")
	private ZonedDateTime checkIn;
	
	@Column(name = "customer_phone")
	private String customerPhone;
	
	/**
	 * Staff who set status "USING" room for customer
	 * */
	@Column(name = "staff_open_room")
	private Account staffOpenRoom;
	
	@OneToOne(mappedBy = "room")
	private RoomPrice roomPrice;
	
	@OneToMany(cascade = CascadeType.ALL)
	@JoinColumn(name = "room_id", referencedColumnName = "id")
	private List<BookRoom> bookRooms = new ArrayList<BookRoom>();
	
	@Transient
	private SimpleDateFormat sdf = new SimpleDateFormat("HH:mm:ss - dd/MM/yy") ;
	
	public Room() {
		super();
	}
	
	public Room(String name, String type, String status, int floor, int capacity) {
		this.name = name;
		this.type = type;
		this.floor = floor;
		this.status = status;
		this.capacity = capacity;
		
		this.customerPhone = "EMPTY";
	}
	
	public int getFloor() {
		return floor;
	}
	public void setFloor(int floor) {
		this.floor = floor;
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	public String getCustomerPhone() {
		return customerPhone;
	}

	public void setCustomerPhone(String customerPhone) {
		this.customerPhone = customerPhone;
	}

	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	
	public int getCapacity() {
		return capacity;
	}

	public void setCapacity(int capacity) {
		this.capacity = capacity;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public ZonedDateTime getCheckIn() {
		return checkIn;
	}

	public void setCheckIn(ZonedDateTime checkIn) {
		this.checkIn = checkIn;
	}

	public Account getStaffOpenRoom() {
		return staffOpenRoom;
	}

	public void setStaffOpenRoom(Account staffOpenRoom) {
		this.staffOpenRoom = staffOpenRoom;
	}

	public RoomPrice getRoomPrice() {
		return roomPrice;
	}

	public void setRoomPrice(RoomPrice roomPrice) {
		this.roomPrice = roomPrice;
	}
	
	public List<BookRoom> getBookRooms() {
		return bookRooms;
	}

	public void setBookRooms(List<BookRoom> bookRooms) {
		this.bookRooms = bookRooms;
	}

	public String displayTimeCheckIn() {
		if (Objects.isNull(checkIn)) return "";
		
		return sdf.format(checkIn);
	}
	
	public String displayTypeRoom() {
		if (type.equals("NORMAL")) {
			return "Thường";
		}
		return "VIP";
	}
	
	public String displayStatusRoom() {
		if (status.equals("EMPTY"))
			return "Trống";
		else if (status.equals("ORDERED")) {
			return "Đã đặt";
		}
		return "Đang sử dụng";
	}
		
}
