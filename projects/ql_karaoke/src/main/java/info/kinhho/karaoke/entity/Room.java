package info.kinhho.karaoke.entity;

import java.text.SimpleDateFormat;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Transient;

@Entity
public class Room {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id; 
	
	private String name;
	private int floor;
	
	private String type;
	private String state;
	private Date timeStart;
		
	private String customPhone;
	
	public Room() {
		super();
	}
	
	public Room(String name, String type, String state, int floor) {
		this.name = name;
		this.type = type;
		this.floor = floor;
		this.state = state;
		
		this.customPhone = "EMPTY";
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
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
	
	public String getCustomPhone() {
		return customPhone;
	}

	public void setCustomPhone(String customPhone) {
		this.customPhone = customPhone;
	}

	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String isState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public Date getTimeStart() {
		return timeStart;
	}
	public void setTimeStart(Date timeStart) {
		this.timeStart = timeStart;
	}

	public String getState() {
		return state;
	}

	
	
	@Override
	public String toString() {
		return "Room [id=" + id + ", name=" + name + ", floor=" + floor + ", type=" + type + ", state=" + state
				+ ", timeStart=" + timeStart + "]";
	}

	@Transient
	SimpleDateFormat sdf = new SimpleDateFormat("HH:mm:ss - dd/MM/yy") ;
	
	public String displayTimeCheckIn() {
		if (timeStart == null) return "";
		
		return sdf.format(timeStart);
	}
	
	public String displayTypeRoom() {
		if (type.equals("NORMAL")) {
			return "Thường";
		}
		return "VIP";
	}
	
	public String displayStateRoom() {
		if (state.equals("EMPTY"))
			return "Trống";
		else if (state.equals("ORDERED")) {
			return "Đã đặt";
		}
		return "Đang sử dụng";
	}
		
}
