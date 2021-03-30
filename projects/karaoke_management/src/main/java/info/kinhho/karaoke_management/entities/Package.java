package info.kinhho.karaoke_management.entities;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
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

	@Column(name = "code")
	private String code;
	
	@Column(name = "bought_price")
	private double boughtPrice;
	
	@Column(name = "sell_price")
	private double sellPrice;
	
	@OneToMany(mappedBy = "packagez", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	private List<Product> products = new ArrayList<Product>();
	
	@ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	private Supplier supplier;
	
	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
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

	public List<Product> getProducts() {
		return products;
	}

	public void setProducts(List<Product> products) {
		this.products = products;
	}

	@Override
	public String getJsonObject() {

		StringBuilder productsJsonStr = new StringBuilder("[");
		products.forEach(product -> {
			productsJsonStr.append(product.getJsonObject()).append(",");
		});
		productsJsonStr.deleteCharAt(productsJsonStr.length() - 1);
		productsJsonStr.append("]");
		
		return String.format("{\"id\": %d, \"code\": \"%s\", \"status\": \"%s\", \"boughtPrice\": %f, \"sellPrice\": %f, \"products\": %s, \"supplier\": %s}", 
				id, code, status, boughtPrice, sellPrice, productsJsonStr.toString(), supplier.getJsonObject());
	}
}
