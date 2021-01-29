package info.kinhho.karaoke.services;

import org.springframework.stereotype.Service;

import info.kinhho.karaoke.entity.RoomPrice;
import info.kinhho.karaoke.repository.RoomPriceRepository;


@Service
public class RoomPriceService {
	
	private RoomPriceRepository roomPriceRepository;
	
	public RoomPriceService(RoomPriceRepository roomPriceRepository) {
		this.roomPriceRepository = roomPriceRepository;
	}

	public void createSeedData() {
		
		
		
	}

	public Iterable<RoomPrice> get() {
		
		return this.roomPriceRepository.findAll();
	}
	
	public RoomPrice get(String id) {
		
		return roomPriceRepository.findById(Integer.parseInt(id)).get();
	}
	
	
}
