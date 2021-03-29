package info.kinhho.karaoke_management.service.impl;

import org.springframework.stereotype.Service;

import info.kinhho.karaoke_management.entities.Product;
import info.kinhho.karaoke_management.repository.ProductRepository;
import info.kinhho.karaoke_management.service.ProductService;

@Service
public class ProductServiceImpl 
		extends BaseServiceImpl<Product, ProductRepository> 
		implements ProductService
{

	public ProductServiceImpl() {}
	
	public ProductServiceImpl(ProductRepository repository) {
		super(repository);
	}

	public void createSeedData() { }
}
