package info.kinhho.karaoke.entity;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

@Entity
public class BillDetail {	
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@ManyToOne
	private Bill bill;

	@OneToOne
	@JoinColumn(name = "room_id", referencedColumnName = "id")
	private Room room;
	
	@OneToMany(mappedBy = "billDetail", cascade = CascadeType.ALL, orphanRemoval = true)
	private List<DetailFood> detail_foods;
		
	private String state;
	
	private Date checkIn;
	private Date checkOut;
	private double price;
	
	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public BillDetail() {
		super();
	}
	
	public BillDetail(Room room, Bill bill) {
		super();
		this.room = room;
		this.bill = bill;
		this.state = "NOT";
		this.detail_foods = new ArrayList<>();
	}
	
	public BillDetail(Room room) {
		super();
		this.room = room;
	}
	public BillDetail(Integer id, Bill bill, Room room) {
		super();
		this.id = id;
		this.bill = bill;
		this.room = room;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Bill getBill() {
		return bill;
	}

	public void setBill(Bill bill) {
		this.bill = bill;
	}

	public Room getRoom() {
		return room;
	}

	public void setRoom(Room room) {
		this.room = room;
	}
	
	public Date getCheckIn() {
		return checkIn;
	}

	public void setCheckIn(Date checkIn) {
		this.checkIn = checkIn;
	}

	public Date getCheckOut() {
		return checkOut;
	}

	public void setCheckOut(Date checkOut) {
		this.checkOut = checkOut;
	}

	public List<DetailFood> getDetail_foods() {
		return detail_foods;
	}

	public void setDetail_foods(List<DetailFood> detail_foods) {
		this.detail_foods = detail_foods;
	}
	
	public void add(DetailFood detailFood) {

		this.detail_foods.add(detailFood);
	}
	@Override
	public String toString() {
		return "BillDetail [id=" + id + ", billId=" + bill.getId() + ", roomId=" + room.getId() + ", detail_foods=" + detail_foods
				+ ", state=" + state + ", checkIn=" + checkIn + ", checkOut=" + checkOut + ", price=" + price + "]";
	}	
}
