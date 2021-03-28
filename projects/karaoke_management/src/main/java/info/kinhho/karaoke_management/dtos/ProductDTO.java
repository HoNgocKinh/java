package info.kinhho.karaoke_management.dtos;

import java.util.ArrayList;
import java.util.List;

import info.kinhho.karaoke_management.entities.DetailProduct;
import info.kinhho.karaoke_management.entities.PackageProduct;

public class ProductDTO extends BaseDTO {
	
	private String name;
	private int quantity;
	private String unit;
	private int price;
	private String type;
	
	private List<PackageProduct> packageProducts = new ArrayList<PackageProduct>();
	private List<DetailProduct> detail_products = new ArrayList<DetailProduct>();
	
	public ProductDTO() {
		
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getQuantity() {
		return quantity;
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
}
