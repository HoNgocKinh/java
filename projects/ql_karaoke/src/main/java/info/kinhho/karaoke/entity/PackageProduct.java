package info.kinhho.karaoke.entity;

import java.time.ZonedDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "package_product")
public class PackageProduct extends BaseEntity {

	private static final long serialVersionUID = 1L;
	
	@ManyToOne
	private Product product;
	
	@ManyToOne
	private Package packagez;
	
	@Column(name = "quantity")
	private int quantity;
	
	@Column(name = "exp_at")
	private ZonedDateTime expAt;

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public ZonedDateTime getExpAt() {
		return expAt;
	}

	public void setExpAt(ZonedDateTime expAt) {
		this.expAt = expAt;
	}

	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

	public Package getPackagez() {
		return packagez;
	}

	public void setPackagez(Package packagez) {
		this.packagez = packagez;
	}

	@Override
	public String toString() {
		return "PackageProduct [id=" + id + ", quantity=" + quantity + ", expAt=" + expAt + ", productName="
				+ product.getName() + ", packageId=" + packagez.getId() + "]";
	}
}
