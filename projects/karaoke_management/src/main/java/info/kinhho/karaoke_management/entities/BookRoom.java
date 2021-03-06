package info.kinhho.karaoke_management.entities;

import java.time.ZonedDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "book_room")
public class BookRoom extends BaseEntity {

	private static final long serialVersionUID = 1L;
	
	@ManyToOne
	private Room room;
	
	@ManyToOne
	private Account account;
	
	@Column(name = "book_time")
	private ZonedDateTime bookTime;
	
	@Column(name = "start_time")
	private ZonedDateTime startTime;
	
	@Column(name = "end_time")
	private ZonedDateTime endTime;
	
	@Column(name = "customer_phone")
	private String customerPhone;

	@Column(name = "customer_name")
	private String customerName;
	
	@Column(name = "notes", length = 2048)
	private String notes;
	
	public Room getRoom() {
		return room;
	}

	public void setRoom(Room room) {
		this.room = room;
	}

	public Account getAccount() {
		return account;
	}

	public void setAccount(Account account) {
		this.account = account;
	}

	public ZonedDateTime getStartTime() {
		return startTime;
	}

	public void setStartTime(ZonedDateTime startTime) {
		this.startTime = startTime;
	}

	public ZonedDateTime getEndTime() {
		return endTime;
	}

	public void setEndTime(ZonedDateTime endTime) {
		this.endTime = endTime;
	}

	public String getCustomerPhone() {
		return customerPhone;
	}

	public void setCustomerPhone(String customerPhone) {
		this.customerPhone = customerPhone;
	}
	
	public String getCustomerName() {
		return customerName;
	}

	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}

	public String getNotes() {
		return notes;
	}

	public void setNotes(String notes) {
		this.notes = notes;
	}

	public ZonedDateTime getBookTime() {
		return bookTime;
	}

	public void setBookTime(ZonedDateTime bookTime) {
		this.bookTime = bookTime;
	}

	@Override
	public String getJsonObject() {
		// TODO Auto-generated method stub
		return "";
	}

	@Override
	public String toString() {
		return "BookRoom [room=" + room + ", account=" + account + ", startTime=" + startTime + ", endTime=" + endTime
				+ ", customerPhone=" + customerPhone + "]";
	}
}
