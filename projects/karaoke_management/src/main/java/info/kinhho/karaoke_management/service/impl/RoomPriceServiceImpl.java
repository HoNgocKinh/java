package info.kinhho.karaoke_management.service.impl;

import org.springframework.stereotype.Service;

import info.kinhho.karaoke_management.dtos.RoomPriceDTO;
import info.kinhho.karaoke_management.entities.RoomPrice;
import info.kinhho.karaoke_management.repository.RoomPriceRepository;
import info.kinhho.karaoke_management.service.RoomPriceService;

@Service
public class RoomPriceServiceImpl 
		extends BaseServiceImpl<RoomPrice, RoomPriceDTO, RoomPriceRepository> 
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

	}

	@Override
	public RoomPriceDTO toDto(RoomPrice e) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public RoomPrice toEntity(RoomPriceDTO d) {
		// TODO Auto-generated method stub
		return null;
	}
}
