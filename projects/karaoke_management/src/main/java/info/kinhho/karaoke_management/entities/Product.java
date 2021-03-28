package info.kinhho.karaoke_management.entities;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "product")
public class Product extends BaseEntity {
	
	private static final long serialVersionUID = 1L;
	
	@Column(name = "name")
	private String name;
	
	@Column(name = "quantity")
	private int quantity;
	
	@Column(name = "unit")
	private String unit;
	
	@Column(name = "bought_price")
	private double boughtPrice;
	
	@Column(name = "sell_price")
	private double sellPrice;
	
	@Column(name = "type")
	private String type;
	
	@OneToMany(mappedBy = "product")
	private List<PackageProduct> packageProducts = new ArrayList<PackageProduct>();
	
	@OneToMany(mappedBy = "product")
	private List<DetailProduct> detail_products = new ArrayList<DetailProduct>();
	
	public Product() { }

	public Product(String name, String type, int quantity, String unit) {

		this.name = name;
		this.quantity = quantity;
		this.unit = unit;
		this.type = type;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public int getQuantity() {
		return quantity;
	}

	public List<PackageProduct> getPackageProducts() {
		return packageProducts;
	}

	public void setPackageProducts(List<PackageProduct> packageProducts) {
		this.packageProducts = packageProducts;
	}

	public List<DetailProduct> getDetail_products() {
		return detail_products;
	}

	public void setDetail_products(List<DetailProduct> detail_products) {
		this.detail_products = detail_products;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	
	public String getUnit() {
		return unit;
	}

	public void setUnit(String unit) {
		this.unit = unit;
	}

	public List<DetailProduct> getDetails() {
		return detail_products;
	}

	public void setDetails(List<DetailProduct> details) {
		this.detail_products = details;
	}

	public void add(DetailProduct detail_product) {
		if (this.detail_products == null) {
			this.detail_products = new ArrayList<>();
		}
		this.detail_products.add(detail_product);
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

	public String displayTypeFood() {
		if (type.equals("Food")) {
			return "Thức ăn";
		}
		return "Nước uống";
	}

	@Override
	public String toString() {
		return "Product [name=" + name + ", quantity=" + quantity + ", unit=" + unit + ", type="
				+ type + ", packageProducts=" + packageProducts + ", detail_products=" + detail_products + "]";
	}
}
