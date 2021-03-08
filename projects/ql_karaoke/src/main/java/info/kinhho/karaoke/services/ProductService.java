package info.kinhho.karaoke.services;

import java.util.List;

import org.springframework.stereotype.Service;

import info.kinhho.karaoke.entity.Product;
import info.kinhho.karaoke.repository.ProductRepository;
import info.kinhho.karaoke.repository.SupplierRepository;


@Service
public class ProductService {
	
	private ProductRepository productRepository;
	private SupplierRepository supplierRepository;
	
	public ProductService(ProductRepository productRepository, SupplierRepository supplierRepository) {
		this.productRepository = productRepository;
		this.supplierRepository = supplierRepository;
	}

	public List<Product> get() {
		System.out.println("access!");
		return productRepository.findAll();
	}
	
	public Product get(String id) {
		
		return productRepository.findById(Long.parseLong(id)).get();
	}
}
