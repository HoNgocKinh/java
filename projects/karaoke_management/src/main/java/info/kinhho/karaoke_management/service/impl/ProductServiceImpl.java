package info.kinhho.karaoke_management.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import info.kinhho.karaoke_management.dtos.ProductDTO;
import info.kinhho.karaoke_management.entities.Product;
import info.kinhho.karaoke_management.repository.ProductRepository;
import info.kinhho.karaoke_management.repository.SupplierRepository;

@Service
public class ProductServiceImpl extends BaseServiceImpl<Product, ProductDTO, ProductRepository> {

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

	@Override
	public ProductDTO toDto(Product e) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Product toEntity(ProductDTO d) {
		// TODO Auto-generated method stub
		return null;
	}
}
