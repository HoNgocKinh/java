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
	
	@Column(name = "quanlity")
	private int quanlity;
	
	@Column(name = "unit")
	private String unit;
	
	@Column(name = "price")
	private int price;
	
	@Column(name = "type")
	private String type;
	
	@OneToMany(mappedBy = "product")
	private List<PackageProduct> packageProducts = new ArrayList<PackageProduct>();
	
	@OneToMany(mappedBy = "product")
	private List<DetailProduct> detail_products = new ArrayList<DetailProduct>();
	
	public Product() { }

	public Product(String name, String type, int quanlity, String unit, int price) {

		this.name = name;
		this.price = price;
		this.quanlity = quanlity;
		this.unit = unit;
		this.type = type;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}
	
	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public int getQuanlity() {
		return quanlity;
	}

	public void setQuanlity(int quanlity) {
		this.quanlity = quanlity;
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
	
	public String displayTypeFood() {
		if (type.equals("Food")) {
			return "Thức ăn";
		}
		return "Nước uống";
	}

	@Override
	public String toString() {
		return "Product [name=" + name + ", quanlity=" + quanlity + ", unit=" + unit + ", price=" + price + ", type="
				+ type + ", packageProducts=" + packageProducts + ", detail_products=" + detail_products + "]";
	}
}
