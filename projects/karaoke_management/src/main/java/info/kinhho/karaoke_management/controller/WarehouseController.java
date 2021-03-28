package info.kinhho.karaoke_management.controller;

import java.time.LocalDate;
import java.time.ZoneId;
import java.util.HashMap;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.google.gson.Gson;
import com.google.gson.internal.LinkedTreeMap;

import info.kinhho.karaoke_management.dtos.PackageDTO;
import info.kinhho.karaoke_management.dtos.PackageProductDTO;
import info.kinhho.karaoke_management.dtos.SupplierDTO;
import info.kinhho.karaoke_management.entities.Package;
import info.kinhho.karaoke_management.entities.PackageProduct;
import info.kinhho.karaoke_management.entities.Product;
import info.kinhho.karaoke_management.entities.Supplier;
import info.kinhho.karaoke_management.service.PackageProductService;
import info.kinhho.karaoke_management.service.PackageService;
import info.kinhho.karaoke_management.service.ProductService;
import info.kinhho.karaoke_management.service.SupplierService;

@Controller
@RequestMapping("/warehouse")
public class WarehouseController {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(WarehouseController.class);
	
	@Autowired
	private PackageService packageService;
	
	@Autowired
	private PackageProductService packageProductService;
	
	@Autowired
	private ProductService productService;
	
	@Autowired
	private SupplierService supplierService;
	
	public WarehouseController(PackageService packageService, PackageProductService packageProductService) {
		this.packageProductService = packageProductService;
		this.packageService = packageService;
	}
	
	@RequestMapping(value = {"", "/"}, method = RequestMethod.GET)
	public String index(Model model) {
		
		List<PackageDTO> packages = packageService.findAllByActive_DTO(true);
		List<PackageProductDTO> packageProducts = packageProductService.findAllByActive_DTO(true);
		List<SupplierDTO> suppliers = supplierService.findAllByActive_DTO(true);
		 
		LOGGER.info("suppliers", suppliers);
		
		model.addAttribute("packages", packages);
		model.addAttribute("packageProducts", packageProducts);
		model.addAttribute("suppliers", suppliers);
		return "warehouse/index";
	}
	
	@RequestMapping(value = "/add", method = RequestMethod.POST)
	public String add(@RequestBody String data) {
		
		LOGGER.info("Data", data);
		Gson gson = new Gson();
		HashMap<String, Object> obj = gson.fromJson(data, HashMap.class);
		
		// package at 0
		// packageProducts at 1
		Package packagez = new Package();
		LinkedTreeMap<String, String> packageForm = (LinkedTreeMap<String, String>) obj.get("package");
		packagez.setPackageCode(packageForm.get("packageCode"));
		packagez.setStatus(packageForm.get("status"));
		packagez.setBoughtPrice(Double.parseDouble(packageForm.get("boughtPrice")));
		packagez.setSellPrice(Double.parseDouble(packageForm.get("sellPrice")));
		
		Supplier supplier = supplierService.findById(Long.parseLong(packageForm.get("supplierId")));
		packagez.setSupplier(supplier);
		packageService.save(packagez);
		
		List<LinkedTreeMap<String, String>> packageProductsForm = (List<LinkedTreeMap<String, String>>) obj.get("packageProducts");
		packageProductsForm.forEach(packageProductForm -> {
			
			PackageProduct packageProduct = new PackageProduct();
			packageProduct.setExpAt(LocalDate.parse(packageProductForm.get("expiredAt")).atStartOfDay(ZoneId.systemDefault()));
			packageProduct.setQuantity(Integer.parseInt(packageProductForm.get("quantity")));
			
			Product product = new Product();
			product.setName(packageProductForm.get("productName"));
			product.setUnit(packageProductForm.get("unit"));
			product.setBoughtPrice(Double.parseDouble(packageProductForm.get("boughtPrice")));
			product.setSellPrice(Double.parseDouble(packageProductForm.get("sellPrice")));
			product.setType(packageProductForm.get("type"));
			product.setQuantity(Integer.parseInt(packageProductForm.get("quantity")));
			
			productService.save(product);
			
			packageProduct.setProduct(product);
			packageProduct.setPackagez(packagez);
			
			packageProductService.save(packageProduct);
		});
		return "";
	}
}
