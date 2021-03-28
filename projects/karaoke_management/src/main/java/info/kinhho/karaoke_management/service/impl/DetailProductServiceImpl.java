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
}
