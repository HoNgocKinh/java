package info.kinhho.karaoke_management.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Transient;

@Entity
@Table(name = "detail_product")
public class DetailProduct extends BaseEntity {
	
	private static final long serialVersionUID = 1L;

    @ManyToOne
    @JoinColumn(name="detail_id")
    private BillDetail billDetail;
	
	@ManyToOne
	@JoinColumn(name="product_id")
	private Product product;
	
	@Column(name = "quantity")
	private int quantity;
		
	/**
	 * for food form!
	 */
	@Transient
	private String listFood;
	@Transient
	private String roomName;
	
	public DetailProduct(BillDetail detail, Product product, int quantity) {
		this.billDetail = detail;
		this.product = product;
		this.quantity = quantity;
	}
	
	public DetailProduct(String roomName) {
		this.roomName = roomName;
	}
	
	public DetailProduct() { }

	public DetailProduct(Product product, int quantity) {
		this.product = product;
		this.quantity = quantity;
	}

	public BillDetail getBillDetail() {
		return billDetail;
	}

	public void setBillDetail(BillDetail billDetail) {
		this.billDetail = billDetail;
	}

	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quanlity) {
		this.quantity = quanlity;
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
	public String getJsonObject() {
		// TODO Auto-generated method stub
		return "";
	}

	@Override
	public String toString() {
		return "DetailFood [billDetailId=" + billDetail.getId() + ", productId=" + product.getId() + ", quantity=" + quantity + "]";
	}
	
}
