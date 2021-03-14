package info.kinhho.karaoke_management.service.impl;

import org.springframework.stereotype.Service;

import info.kinhho.karaoke_management.entities.PackageProduct;
import info.kinhho.karaoke_management.repository.PackageProductRepository;

@Service
public class PackageProductServiceImpl extends BaseServiceImpl<PackageProduct, PackageProductRepository> {

	public PackageProductServiceImpl(PackageProductRepository repository) {
		super(repository);
	}

	public void createSeedData() {

	}
}
