package info.kinhho.karaoke_management.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import info.kinhho.karaoke_management.service.ProductService;

@Controller
@RequestMapping(value = "/products")
public class ProductController {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(ProductController.class);
	
	@Autowired
	private ProductService productService;
	
	public ProductController() {}
	
	public ProductController(ProductService productService) {
		this.productService = productService;
	}
	
	@RequestMapping(value = {"/", ""}, method = RequestMethod.GET)
	public String index(Model model) {
		
//		LOGGER.info("Start Index method");
//		List<ProductDTO> products = productService.findAllByActive(true);
//		LOGGER.info("products", products);
//		model.addAttribute("products", products);
//		model.addAttribute("active", "product");
//		LOGGER.info("End Index method");
		return "product/index";
	}
	
	@RequestMapping(value = "/add", method = RequestMethod.POST)
	public String save(@RequestBody String requestBody) {
		//ProductDTO dtoForm
//		if (Objects.isNull(dtoForm.getId())) {
//			dtoForm.setCreatedAt(ZonedDateTime.now());
//			dtoForm.setUpdateAt(ZonedDateTime.now());
//			dtoForm.setActive(true);
//			productService.save(dtoForm);
//		}
//		else {
//			ProductDTO productDTO = productService.findById(dtoForm.getId());
////			productDTO.setName(dtoForm);
////			supplierDTO.setPhone(dtoForm.getPhone());
////			supplierDTO.setAddress(dtoForm.getAddress());
////			supplierDTO.setUpdateAt(ZonedDateTime.now());
//			productService.save(productDTO);
//		}
		return "redirect:/suppliers";
	}
	
	@RequestMapping(value = "/delete/{id}", method = RequestMethod.POST)
	public boolean delete(@PathVariable("id") Long id) {
		productService.delete(id);
		return true;
	}
	
	@RequestMapping(value = "/unactive/{id}", method = RequestMethod.POST)
	public boolean unactive(@PathVariable("id") Long id) {
		productService.unactive(id);
		return true;
	}
}
