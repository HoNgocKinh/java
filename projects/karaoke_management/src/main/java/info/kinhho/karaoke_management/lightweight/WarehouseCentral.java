package info.kinhho.karaoke_management.lightweight;

import java.time.LocalDate;
import java.time.ZoneId;
import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.google.gson.Gson;
import com.google.gson.internal.LinkedTreeMap;

import info.kinhho.karaoke_management.dtos.WarehouseDTO;
import info.kinhho.karaoke_management.entities.Package;
import info.kinhho.karaoke_management.entities.Product;
import info.kinhho.karaoke_management.entities.Supplier;
import info.kinhho.karaoke_management.service.PackageService;
import info.kinhho.karaoke_management.service.ProductService;
import info.kinhho.karaoke_management.service.SupplierService;

@Component
public class WarehouseCentral {
	
	@Autowired
	private ProductService productService;
	@Autowired
	private SupplierService supplierService;
	@Autowired
	private PackageService packageService;
	
	public WarehouseCentral() {
		
	}
	
	public WarehouseCentral(ProductService productService, SupplierService supplierService,
			PackageService packageService) {
		super();
		this.productService = productService;
		this.supplierService = supplierService;
		this.packageService = packageService;
	}

	public WarehouseDTO getDTORendering() {
		
		WarehouseDTO warehouse = new WarehouseDTO();
		
		List<Package> packages = packageService.findAllByActive(true);
		List<Supplier> suppliers = supplierService.findAllByActive(true);
		List<Product> products = productService.findAllByActive(true);
		
		warehouse.setPackages(packages);
		warehouse.setSuppliers(suppliers);
		warehouse.setProducts(products);
		
		return warehouse;
	}
	
	@SuppressWarnings("unchecked")
	public String save(String requestBody) {
		
		Gson gson = new Gson();
		HashMap<String, Object> obj = gson.fromJson(requestBody, HashMap.class);
		
		// package at 0
		// packageProducts at 1
		Package packagez = new Package();
		LinkedTreeMap<String, String> packageForm = (LinkedTreeMap<String, String>) obj.get("package");
		if (!packageForm.get("packageId").isEmpty()) {
			packagez.setId(Long.parseLong(packageForm.get("packageId")));
		}
		
		packagez.setCode(packageForm.get("packageCode"));
		packagez.setStatus(packageForm.get("status"));
		packagez.setBoughtPrice(Double.parseDouble(packageForm.get("boughtPrice")));
		packagez.setSellPrice(Double.parseDouble(packageForm.get("sellPrice")));
		
		Supplier supplier = supplierService.findById(Long.parseLong(packageForm.get("supplierId")));
		packagez.setSupplier(supplier);
		packageService.save(packagez);
		
		List<LinkedTreeMap<String, String>> productsForm = (List<LinkedTreeMap<String, String>>) obj.get("products");
		productsForm.forEach(productForm -> {
			
			Product product = new Product();
			if (!productForm.get("productId").isEmpty()) {
				product.setId(Long.parseLong(productForm.get("productId")));
			}
			product.setName(productForm.get("productName"));
			product.setUnit(productForm.get("unit"));
			product.setBoughtPrice(Double.parseDouble(productForm.get("boughtPrice")));
			product.setSellPrice(Double.parseDouble(productForm.get("sellPrice")));
			product.setType(productForm.get("type"));
			product.setExpiredAt(LocalDate.parse(productForm.get("expiredAt")).atStartOfDay(ZoneId.systemDefault()));
			product.setQuantity(Integer.parseInt(productForm.get("quantity")));
			product.setPackagez(packagez);
			product.setImage(productForm.get("image"));
			if (productForm.get("image").isEmpty()) {
				product.setImage("/images/default.png");
			}
			
			productService.save(product);
		});
		return "Save!";
	}
	
	public void delete(Long id) {
		packageService.delete(id);
	}
	
	public void unactive(Long id) {
		packageService.unactive(id);
	}
	
	/** ------------- Getter/Setter ------------------**/
	
	public ProductService getProductService() {
		return productService;
	}
	public void setProductService(ProductService productService) {
		this.productService = productService;
	}
	public SupplierService getSupplierService() {
		return supplierService;
	}
	public void setSupplierService(SupplierService supplierService) {
		this.supplierService = supplierService;
	}
	public PackageService getPackageService() {
		return packageService;
	}
	public void setPackageService(PackageService packageService) {
		this.packageService = packageService;
	}
}
