package info.kinhho.karaoke.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import info.kinhho.karaoke.entity.RoomPrice;

@Repository
public interface RoomPriceRepository extends JpaRepository<RoomPrice, Long>  {
	
	
	@Query("SELECT r FROM RoomPrice r")
	public List<RoomPrice> get();
}
