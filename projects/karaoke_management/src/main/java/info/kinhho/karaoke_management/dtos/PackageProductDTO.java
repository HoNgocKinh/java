package info.kinhho.karaoke_management.dtos;

import java.time.ZonedDateTime;

import info.kinhho.karaoke_management.entities.Package;
import info.kinhho.karaoke_management.entities.Product;

public class PackageProductDTO extends BaseDTO {
	
	private Product product;
	private Package packagez;
	private int quantity;
	private ZonedDateTime expAt;
	
	public PackageProductDTO() {
		
	}
	
	public PackageProductDTO(Product product, Package packagez, int quantity, ZonedDateTime expAt) {
		this.product = product;
		this.packagez = packagez;
		this.quantity = quantity;
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
}
