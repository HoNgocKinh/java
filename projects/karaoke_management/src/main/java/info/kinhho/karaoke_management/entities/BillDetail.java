package info.kinhho.karaoke_management.entities;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;


@Entity
@Table(name = "bill_detail")
public class BillDetail extends BaseEntity {	
	
	private static final long serialVersionUID = 1l;
	
	@ManyToOne
	private Bill bill;

	@OneToOne
	@JoinColumn(name = "room_id", referencedColumnName = "id")
	private Room room;
	
	@OneToMany(mappedBy = "billDetail", cascade = CascadeType.ALL, orphanRemoval = true)
	private List<DetailProduct> detail_foods = new ArrayList<DetailProduct>();
	
	@Column(name = "status")
	private String status;
	
	@Column(name = "check_in")
	private Date checkIn;
	
	@Column(name = "check_out")
	private Date checkOut;
	
	@Column(name = "price")
	private double price;
	

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public BillDetail() { }
	
	public BillDetail(Room room, Bill bill) {
		this.room = room;
		this.bill = bill;
		this.status = "NOT";
	}
	
	public BillDetail(Room room) {
		this.room = room;
	}
	public BillDetail(Long id, Bill bill, Room room) {
		this.id = id;
		this.bill = bill;
		this.room = room;
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

	public List<DetailProduct> getDetail_foods() {
		return detail_foods;
	}

	public void setDetail_foods(List<DetailProduct> detail_foods) {
		this.detail_foods = detail_foods;
	}
	
	public void add(DetailProduct detailFood) {

		this.detail_foods.add(detailFood);
	}
	@Override
	public String toString() {
		return "BillDetail [id=" + id + ", billId=" + bill.getId() + ", roomId=" + room.getId() + ", detail_foods=" + detail_foods
				+ ", status=" + status + ", checkIn=" + checkIn + ", checkOut=" + checkOut + ", price=" + price + "]";
	}	
}
