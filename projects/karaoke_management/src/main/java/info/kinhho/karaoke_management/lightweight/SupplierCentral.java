package info.kinhho.karaoke_management.lightweight;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.google.gson.Gson;
import com.google.gson.internal.LinkedTreeMap;

import info.kinhho.karaoke_management.dtos.SupplierDTO;
import info.kinhho.karaoke_management.entities.Supplier;
import info.kinhho.karaoke_management.service.SupplierService;

@Component
public class SupplierCentral {

	@Autowired
	private SupplierService supplierService;
	
	public SupplierCentral() { }
	
	public SupplierCentral(SupplierService supplierService) {
		this.supplierService = supplierService;
	}
	
	public SupplierDTO getDTORendering() {
		
		SupplierDTO supplier = new SupplierDTO();
		List<Supplier> suppliers = supplierService.findAllByActive(true);
				
		supplier.setSuppliers(suppliers);
		return supplier;
	}
	
	@SuppressWarnings("unchecked")
	public void save(String requestBody) {
		
		Gson gson = new Gson();
		HashMap<String, Object> obj = gson.fromJson(requestBody, HashMap.class);
		
		LinkedTreeMap<String, String> supplierForm = (LinkedTreeMap<String, String>) obj.get("supplier");
		Supplier supplier = new Supplier();
		if (!supplierForm.get("id").isEmpty()) {
			supplier.setId(Long.parseLong(supplierForm.get("id")));
		}
		supplier.setName(supplierForm.get("name"));
		supplier.setAddress(supplierForm.get("address"));
		supplier.setPhone(supplierForm.get("phone"));

		supplierService.save(supplier);
	}
	
	public void unactive(Long id) {
		
		supplierService.unactive(id);
	}
	
	public void delete(Long id) {
		supplierService.delete(id);
	}
}
