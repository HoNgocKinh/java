package info.kinhho.karaoke_management.dtos;

import java.util.List;

import info.kinhho.karaoke_management.entities.Supplier;

public class SupplierDTO {
	
	private List<Supplier> suppliers;
	
	public SupplierDTO() {}

	public List<Supplier> getSuppliers() {
		return suppliers;
	}

	public void setSuppliers(List<Supplier> suppliers) {
		this.suppliers = suppliers;
	}
}
