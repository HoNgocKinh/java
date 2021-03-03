package info.kinhho.karaoke.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "bill")
public class Bill extends BaseEntity {
	
	private static final long serialVersionUID = 1l;
	
	@Column(name = "total")
	private float total;
	
	@Column(name = "customerPhone")
	private String customerPhone;
	
	@Column(name = "tax_rate")
	private float taxRate;
	
	@OneToMany(cascade = CascadeType.ALL)
	@JoinColumn(name="bill_id")
	private List<BillDetail> billDetails = new ArrayList<BillDetail>();
	
	@ManyToOne
	private Account account;
	
	public Bill() { }

	public List<BillDetail> getBillDetails() {
		return billDetails;
	}

	public void setBillDetails(List<BillDetail> billDetails) {
		this.billDetails = billDetails;
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
		billDetails.add(billDetail);
		return billDetail;
	}

	@Override
	public String toString() {
		return "Bill [id=" + id + ", total=" + total + ", customerPhone=" + customerPhone + ", billDetails="
				+ billDetails + ", account=" + account + "]";
	}

}
