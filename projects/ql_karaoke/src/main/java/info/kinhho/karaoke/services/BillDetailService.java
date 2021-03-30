package info.kinhho.karaoke.services;

import org.springframework.stereotype.Service;

import info.kinhho.karaoke.entity.BillDetail;
import info.kinhho.karaoke.repository.BillDetailRepository;


@Service
public class BillDetailService {
	
	private BillDetailRepository billDetailRepository;
	
	public BillDetailService(BillDetailRepository billDetailRepository) {
		
		this.billDetailRepository = billDetailRepository;
	}
	
	public Iterable<BillDetail> get() {
		
		return this.billDetailRepository.findAll();
	}
	
	public BillDetail get(Integer id) {
		return this.billDetailRepository.findById(id).get();
	}
	
	public void save(BillDetail billDetail) {
		this.billDetailRepository.save(billDetail);
	} 
}
