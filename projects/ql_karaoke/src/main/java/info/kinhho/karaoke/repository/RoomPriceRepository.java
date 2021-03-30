package info.kinhho.karaoke.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import info.kinhho.karaoke.entity.RoomPrice;


public interface RoomPriceRepository extends CrudRepository<RoomPrice, Integer>{
	
	
	@Query("SELECT r FROM RoomPrice r")
	public List<RoomPrice> get();
}
