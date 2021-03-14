package info.kinhho.karaoke_management.service.impl;

import org.springframework.stereotype.Service;

import info.kinhho.karaoke_management.entities.RoomPrice;
import info.kinhho.karaoke_management.repository.RoomPriceRepository;
import info.kinhho.karaoke_management.service.RoomPriceService;

@Service
public class RoomPriceServiceImpl 
		extends BaseServiceImpl<RoomPrice, RoomPriceRepository> 
		implements RoomPriceService {

	public RoomPriceServiceImpl(RoomPriceRepository repository) {
		super(repository);
	}

	public Iterable<RoomPrice> get() {

		return this.repository.findAll();
	}

	public RoomPrice get(String id) {

		return repository.findById(Long.parseLong(id)).get();
	}

	public void createSeedData() {

		RoomPrice roomPrice01 = new RoomPrice("NORMAL", 100000, 0, 6, "DAILY", 10);
		RoomPrice roomPrice02 = new RoomPrice("NORMAL", 70000, 6, 18, "DAILY", 10);
		RoomPrice roomPrice03 = new RoomPrice("NORMAL", 80000, 18, 24, "DAILY", 10);

		RoomPrice roomPrice04 = new RoomPrice("NORMAL", 130000, 0, 6, "DAILY", 15);
		RoomPrice roomPrice05 = new RoomPrice("NORMAL", 80000, 6, 18, "DAILY", 15);
		RoomPrice roomPrice06 = new RoomPrice("NORMAL", 90000, 18, 24, "DAILY", 15);
		
		RoomPrice roomPrice07 = new RoomPrice("NORMAL", 150000, 0, 6, "DAILY", 20);
		RoomPrice roomPrice08 = new RoomPrice("NORMAL", 90000, 6, 18, "DAILY", 20);
		RoomPrice roomPrice09 = new RoomPrice("NORMAL", 100000, 18, 24, "DAILY", 20);
		
		//==========================================================================//
		
		RoomPrice roomPrice10 = new RoomPrice("NORMAL", 200000, 0, 6, "WEEKEND", 10);
		RoomPrice roomPrice11 = new RoomPrice("NORMAL", 110000, 6, 18, "WEEKEND", 10);
		RoomPrice roomPrice12 = new RoomPrice("NORMAL", 130000, 18, 24, "WEEKEND", 10);
		
		RoomPrice roomPrice13 = new RoomPrice("NORMAL", 230000, 0, 6, "WEEKEND", 15);
		RoomPrice roomPrice14 = new RoomPrice("NORMAL", 120000, 6, 18, "WEEKEND", 15);
		RoomPrice roomPrice15 = new RoomPrice("NORMAL", 130000, 18, 24, "WEEKEND", 15);
		
		RoomPrice roomPrice16 =  new RoomPrice("NORMAL", 250000, 0, 6, "WEEKEND", 20);
		RoomPrice roomPrice17 = new RoomPrice("NORMAL", 130000, 6, 18, "WEEKEND", 20);
		RoomPrice roomPrice18 = new RoomPrice("NORMAL", 140000, 18, 24, "WEEKEND", 20);
		
		// ============================================================================//
		
		RoomPrice roomPrice19 = new RoomPrice("NORMAL", 220000, 0, 6, "HOLIDAY", 10);
		RoomPrice roomPrice20 = new RoomPrice("NORMAL", 130000, 6, 18, "HOLIDAY", 10);
		RoomPrice roomPrice21 = new RoomPrice("NORMAL", 170000, 18, 24, "HOLIDAY", 10);
		
		RoomPrice roomPrice22 = new RoomPrice("NORMAL", 260000, 0, 6, "HOLIDAY", 15);
		RoomPrice roomPrice23 = new RoomPrice("NORMAL", 150000, 6, 18, "HOLIDAY", 15);
		RoomPrice roomPrice24 = new RoomPrice("NORMAL", 180000, 18, 24, "HOLIDAY", 15);
		
		RoomPrice roomPrice25 = new RoomPrice("NORMAL", 280000, 0, 6, "HOLIDAY", 20);
		RoomPrice roomPrice26 = new RoomPrice("NORMAL", 180000, 6, 18, "HOLIDAY", 20);
		RoomPrice roomPrice27 = new RoomPrice("NORMAL", 200000, 18, 24, "HOLIDAY", 20);

		//============================================================================//
		
		RoomPrice roomPrice28 = new RoomPrice("VIP", 350000, 0, 6, "DAILY", 15);
		RoomPrice roomPrice29 = new RoomPrice("VIP", 150000, 6, 18, "DAILY", 15);
		RoomPrice roomPrice30 = new RoomPrice("VIP", 160000, 18, 24, "DAILY", 15);

		RoomPrice roomPrice31 = new RoomPrice("VIP", 380000, 0, 6, "DAILY", 20);
		RoomPrice roomPrice32 = new RoomPrice("VIP", 200000, 6, 18, "DAILY", 20);
		RoomPrice roomPrice33 = new RoomPrice("VIP", 230000, 18, 24, "DAILY", 20);

		//============================================================================//
		
		RoomPrice roomPrice34 = new RoomPrice("VIP", 400000, 0, 6, "WEEKEND", 15);
		RoomPrice roomPrice35 = new RoomPrice("VIP", 250000, 6, 18, "WEEKEND", 15);
		RoomPrice roomPrice36 = new RoomPrice("VIP", 300000, 18, 24, "WEEKEND", 15);
		
		RoomPrice roomPrice37 = new RoomPrice("VIP", 420000, 0, 6, "WEEKEND", 20);
		RoomPrice roomPrice38 = new RoomPrice("VIP", 270000, 6, 18, "WEEKEND", 20);
		RoomPrice roomPrice39 = new RoomPrice("VIP", 320000, 18, 24, "WEEKEND", 20);		

		//============================================================================//
		
		RoomPrice roomPrice40 = new RoomPrice("VIP", 430000, 0, 6, "HOLIDAY", 15);
		RoomPrice roomPrice41 = new RoomPrice("VIP", 280000, 6, 18, "HOLIDAY", 15);
		RoomPrice roomPrice42 = new RoomPrice("VIP", 340000, 18, 24, "HOLIDAY", 15);
		
		RoomPrice roomPrice43 = new RoomPrice("VIP", 450000, 0, 6, "HOLIDAY", 20);
		RoomPrice roomPrice44 = new RoomPrice("VIP", 300000, 6, 18, "HOLIDAY", 20);
		RoomPrice roomPrice45 = new RoomPrice("VIP", 350000, 18, 24, "HOLIDAY", 20);
		
		
		repository.save(roomPrice01);
		repository.save(roomPrice02);
		repository.save(roomPrice03);
		repository.save(roomPrice04);
		repository.save(roomPrice05);
		repository.save(roomPrice06);
		repository.save(roomPrice07);
		repository.save(roomPrice08);
		repository.save(roomPrice09);
		repository.save(roomPrice10);
		repository.save(roomPrice11);
		repository.save(roomPrice12);
		repository.save(roomPrice13);
		repository.save(roomPrice14);
		repository.save(roomPrice15);
		repository.save(roomPrice16);
		repository.save(roomPrice17);
		repository.save(roomPrice18);
		repository.save(roomPrice19);
		repository.save(roomPrice20);
		repository.save(roomPrice21);
		repository.save(roomPrice22);
		repository.save(roomPrice23);
		repository.save(roomPrice24);
		repository.save(roomPrice25);
		repository.save(roomPrice26);
		repository.save(roomPrice27);
		repository.save(roomPrice28);
		repository.save(roomPrice29);
		repository.save(roomPrice30);
		repository.save(roomPrice31);
		repository.save(roomPrice32);
		repository.save(roomPrice33);
		repository.save(roomPrice34);
		repository.save(roomPrice35);
		repository.save(roomPrice36);
		repository.save(roomPrice37);
		repository.save(roomPrice38);
		repository.save(roomPrice39);
		repository.save(roomPrice40);
		repository.save(roomPrice41);
		repository.save(roomPrice42);
		repository.save(roomPrice43);
		repository.save(roomPrice44);
		repository.save(roomPrice45);
	}
}
