package info.kinhho.karaoke_management.entities;

import java.time.ZonedDateTime;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "product")
public class Product extends BaseEntity {
	
	private static final long serialVersionUID = 1L;
	
	@Column(name = "name")
	private String name;
	
	@Column(name = "unit")
	private String unit;
	
	@Column(name = "bought_price")
	private double boughtPrice;
	
	@Column(name = "sell_price")
	private double sellPrice;
	
	@Column(name = "type")
	private String type;
	
	@Column(name = "expired_at")
	private ZonedDateTime expiredAt;
	
	@Column(name = "quantity")
	private int quantity;
	
	@Column(name = "image")
	private String image;
	
	@ManyToOne(fetch = FetchType.LAZY)
	private Package packagez;
	
	@OneToMany(mappedBy = "product")
	private List<DetailProduct> detail_products = new ArrayList<DetailProduct>();
	
	public Product() { }

	public Product(String name, String type, String unit) {

		this.name = name;
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

	public List<DetailProduct> getDetail_products() {
		return detail_products;
	}

	public void setDetail_products(List<DetailProduct> detail_products) {
		this.detail_products = detail_products;
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
	
	public String getExpiredAt() {
		return expiredAt.format(formatter);
	}

	public void setExpiredAt(ZonedDateTime expiredAt) {
		this.expiredAt = expiredAt;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public Package getPackagez() {
		return packagez;
	}

	public void setPackagez(Package packagez) {
		this.packagez = packagez;
	}

	public String displayTypeFood() {
		if (type.equals("Food")) {
			return "Thức ăn";
		}
		return "Nước uống";
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	@Override
	public String getJsonObject() {

		return String.format("{\"id\": %d, \"name\": \"%s\", \"unit\": \"%s\", \"boughtPrice\": %f, \"sellPrice\": %f, \"type\": \"%s\", \"expiredAt\": \"%s\", \"quantity\": %d, \"image\": \"%s\"}",
				id, name, unit, boughtPrice, sellPrice, type, expiredAt, quantity, image);
	}
}
