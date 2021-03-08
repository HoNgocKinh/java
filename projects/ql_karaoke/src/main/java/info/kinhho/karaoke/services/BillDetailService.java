package info.kinhho.karaoke.services;

import org.springframework.stereotype.Service;

import info.kinhho.karaoke.entity.BillDetail;
import info.kinhho.karaoke.repository.BillDetailRepository;


@Service
public class BillDetailService extends BaseService<BillDetail, BillDetailRepository>{
	
	public BillDetailService() {}
}
