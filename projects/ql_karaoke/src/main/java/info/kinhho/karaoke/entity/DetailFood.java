package info.kinhho.karaoke.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Transient;

@Entity
public class DetailFood implements Serializable {
	
	private static final long serialVersionUID = 1L;

	@Id
    @ManyToOne
    @JoinColumn(name="detail_id")
    private BillDetail billDetail;
	
	@Id
	@ManyToOne
	@JoinColumn(name="food_id")
	private Food food;
	
	@Column(name = "quanlity")
	private int quanlity;
		
	/**
	 * for food form!
	 */
	@Transient
	private String listFood;
	@Transient
	private String roomName;
	
	public DetailFood(BillDetail detail, Food food, int quanlity) {
		this.billDetail = detail;
		this.food = food;
		this.quanlity = quanlity;
	}
	
	public DetailFood(String roomName) {
		this.roomName = roomName;
	}
	
	public DetailFood() {
		super();
	}

	public DetailFood(Food food, int quanlity) {
		super();
		this.food = food;
		this.quanlity = quanlity;
	}

	public BillDetail getBillDetail() {
		return billDetail;
	}

	public void setBillDetail(BillDetail billDetail) {
		this.billDetail = billDetail;
	}

	public Food getFood() {
		return food;
	}

	public void setFood(Food food) {
		this.food = food;
	}

	public int getQuanlity() {
		return quanlity;
	}

	public void setQuanlity(int quanlity) {
		this.quanlity = quanlity;
	}

	public String getListFood() {
		return listFood;
	}

	public void setListFood(String listFood) {
		this.listFood = listFood;
	}

	public String getRoomName() {
		return roomName;
	}

	public void setRoomName(String roomName) {
		this.roomName = roomName;
	}

	@Override
	public String toString() {
		return "DetailFood [billDetailId=" + billDetail.getId() + ", foodId=" + food.getId() + ", quanlity=" + quanlity + "]";
	}
	
}
