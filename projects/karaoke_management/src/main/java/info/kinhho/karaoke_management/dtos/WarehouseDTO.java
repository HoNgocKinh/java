package info.kinhho.karaoke_management.dtos;

import java.util.List;

import info.kinhho.karaoke_management.entities.Package;
import info.kinhho.karaoke_management.entities.Product;
import info.kinhho.karaoke_management.entities.Supplier;

public class WarehouseDTO {
	
	private List<Package> packages;
	private List<Supplier> suppliers;
	private List<Product> products;
	
	public List<Package> getPackages() {
		return packages;
	}

	public void setPackages(List<Package> packages) {
		this.packages = packages;
	}

	public List<Supplier> getSuppliers() {
		return suppliers;
	}

	public void setSuppliers(List<Supplier> suppliers) {
		this.suppliers = suppliers;
	}

	public List<Product> getProducts() {
		return products;
	}

	public void setProducts(List<Product> products) {
		this.products = products;
	}
}
