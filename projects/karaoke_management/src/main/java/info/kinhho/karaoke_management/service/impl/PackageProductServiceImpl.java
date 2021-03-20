package info.kinhho.karaoke_management.service.impl;

import org.springframework.stereotype.Service;

import info.kinhho.karaoke_management.dtos.PackageProductDTO;
import info.kinhho.karaoke_management.entities.PackageProduct;
import info.kinhho.karaoke_management.repository.PackageProductRepository;

@Service
public class PackageProductServiceImpl extends BaseServiceImpl<PackageProduct, PackageProductDTO, PackageProductRepository> {

	public PackageProductServiceImpl(PackageProductRepository repository) {
		super(repository);
	}

	public void createSeedData() {

	}

	@Override
	public PackageProductDTO toDto(PackageProduct e) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public PackageProduct toEntity(PackageProductDTO d) {
		// TODO Auto-generated method stub
		return null;
	}
}
