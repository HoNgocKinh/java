package info.kinhho.karaoke.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import info.kinhho.karaoke.entity.Room;

@Repository
public interface RoomRepository extends JpaRepository<Room, Long>  {
	
	@Query("SELECT r FROM Room r where r.status = 'USED'")
	public Iterable<Room> getUsed();
	
	@Query("SELECT r FROM Room r where r.status = 'EMPTY'")
	public Iterable<Room> getUnused();
	
	public Room findByName(String name);
}
