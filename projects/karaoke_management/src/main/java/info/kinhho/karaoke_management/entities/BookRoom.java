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
	
	@Column(name = "start_time")
	private ZonedDateTime startTime;
	
	@Column(name = "end_time")
	private ZonedDateTime endTime;
	
	@Column(name = "customer_phone")
	private String customerPhone;

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

	@Override
	public String toString() {
		return "BookRoom [room=" + room + ", account=" + account + ", startTime=" + startTime + ", endTime=" + endTime
				+ ", customerPhone=" + customerPhone + "]";
	}
}
