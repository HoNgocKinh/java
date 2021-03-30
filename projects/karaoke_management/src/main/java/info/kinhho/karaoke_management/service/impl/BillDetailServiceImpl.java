package info.kinhho.karaoke_management.service.impl;

import org.springframework.stereotype.Service;

import info.kinhho.karaoke_management.entities.BillDetail;
import info.kinhho.karaoke_management.repository.BillDetailRepository;

@Service
public class BillDetailServiceImpl extends BaseServiceImpl<BillDetail, BillDetailRepository> {

	public BillDetailServiceImpl(BillDetailRepository repository) {
		super(repository);
	}
	
	public void createSeedData() {
		
	}

	@Override
	public void unactive(Long id) {
		// TODO Auto-generated method stub
		
	}
	
}
