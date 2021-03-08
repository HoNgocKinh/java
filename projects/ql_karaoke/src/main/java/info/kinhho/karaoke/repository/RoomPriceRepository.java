package info.kinhho.karaoke.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;

import info.kinhho.karaoke.entity.RoomPrice;


public interface RoomPriceRepository extends BaseRepository<RoomPrice>{
	
	
	@Query("SELECT r FROM RoomPrice r")
	public List<RoomPrice> get();
}
