package info.kinhho.karaoke_management.service.impl;

import info.kinhho.karaoke_management.entities.DetailProduct;
import info.kinhho.karaoke_management.repository.DetailProductRepository;

public class DetailProductServiceImpl extends BaseServiceImpl<DetailProduct, DetailProductRepository> {

	public DetailProductServiceImpl(DetailProductRepository repository) {
		super(repository);
	}

	public void createSeedData() {

	}

	@Override
	public void unactive(Long id) {
		// TODO Auto-generated method stub
		
	}
}
