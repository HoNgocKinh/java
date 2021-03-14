package info.kinhho.karaoke_management.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import info.kinhho.karaoke_management.entities.RoomPrice;

@Repository
public interface RoomPriceRepository extends BaseRepository<RoomPrice>  {
	
	
	@Query("SELECT r FROM RoomPrice r")
	public List<RoomPrice> get();
}
