package info.kinhho.karaoke_management.entities;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "package")
public class Package extends BaseEntity {
	
	private static final long serialVersionUID = 1L;
	
	@Column(name = "status")
	private String status;

	@Column(name = "package_code")
	private String packageCode;
	
	@Column(name = "bought_price")
	private double boughtPrice;
	
	@Column(name = "sell_price")
	private double sellPrice;
	
	@OneToMany(mappedBy = "packagez", fetch = FetchType.LAZY)
	private List<PackageProduct> packageProducts = new ArrayList<PackageProduct>();
	
	@ManyToOne
	private Supplier supplier;
	
	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getPackageCode() {
		return packageCode;
	}

	public void setPackageCode(String packageCode) {
		this.packageCode = packageCode;
	}

	public double getBoughtPrice() {
		return boughtPrice;
	}

	public void setBoughtPrice(double boughtPrice) {
		this.boughtPrice = boughtPrice;
	}

	public double getSellPrice() {
		return sellPrice;
	}

	public void setSellPrice(double sellPrice) {
		this.sellPrice = sellPrice;
	}

	public Supplier getSupplier() {
		return supplier;
	}

	public void setSupplier(Supplier supplier) {
		this.supplier = supplier;
	}
}
