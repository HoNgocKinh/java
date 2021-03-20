package info.kinhho.karaoke_management.service.impl;

import info.kinhho.karaoke_management.dtos.DetailProductDTO;
import info.kinhho.karaoke_management.entities.DetailProduct;
import info.kinhho.karaoke_management.repository.DetailProductRepository;

public class DetailProductServiceImpl extends BaseServiceImpl<DetailProduct, DetailProductDTO, DetailProductRepository> {

	public DetailProductServiceImpl(DetailProductRepository repository) {
		super(repository);
	}

	public void createSeedData() {

	}

	@Override
	public DetailProductDTO toDto(DetailProduct e) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public DetailProduct toEntity(DetailProductDTO d) {
		// TODO Auto-generated method stub
		return null;
	}
	
}
