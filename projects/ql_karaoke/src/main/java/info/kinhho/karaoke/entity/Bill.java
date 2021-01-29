package info.kinhho.karaoke.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity
public class Bill {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private float total;
	private String customerPhone;
	
	@OneToMany(cascade = CascadeType.ALL)
	@JoinColumn(name="bill_id")
	private List<BillDetail> billDetails;
	
	@ManyToOne
	private Account account;
	
	
	
	public Bill() {
		super();
	}

	public List<BillDetail> getBillDetails() {
		return billDetails;
	}

	public void setBillDetails(List<BillDetail> billDetails) {
		this.billDetails = billDetails;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}
	
	public String getCustomerPhone() {
		return customerPhone;
	}

	public void setCustomerPhone(String customerPhone) {
		this.customerPhone = customerPhone;
	}
	
	public float getTotal() {
		return total;
	}

	public void setTotal(float total) {
		this.total = total;
	}

	public Account getAccount() {
		return account;
	}

	public void setAccount(Account account) {
		this.account = account;
	}
	
	public BillDetail createBillDetail(Room room) {
		
		BillDetail billDetail = new BillDetail(room, this);
		
		if (billDetails == null) {
			billDetails = new ArrayList<>();
			billDetails.add(billDetail);
		}
		else {
			billDetails.add(billDetail);
		}
		
		return billDetail;
	}

	@Override
	public String toString() {
		return "Bill [id=" + id + ", total=" + total + ", customerPhone=" + customerPhone + ", billDetails="
				+ billDetails + ", account=" + account + "]";
	}

}
