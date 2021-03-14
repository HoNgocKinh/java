package info.kinhho.karaoke_management.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import info.kinhho.karaoke_management.entities.Product;
import info.kinhho.karaoke_management.repository.ProductRepository;
import info.kinhho.karaoke_management.repository.SupplierRepository;

@Service
public class ProductServiceImpl extends BaseServiceImpl<Product, ProductRepository> {

//	private SupplierRepository supplierRepository;

	public ProductServiceImpl(ProductRepository productRepository, SupplierRepository supplierRepository) {
		super(productRepository);
//		this.supplierRepository = supplierRepository;
	}

	public List<Product> get() {
		System.out.println("access!");
		return repository.findAll();
	}

	public Product get(String id) {

		return repository.findById(Long.parseLong(id)).get();
	}

	public void createSeedData() {

	}
}
