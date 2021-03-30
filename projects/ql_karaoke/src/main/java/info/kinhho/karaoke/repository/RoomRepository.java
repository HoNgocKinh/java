package info.kinhho.karaoke.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import info.kinhho.karaoke.entity.Room;

public interface RoomRepository extends CrudRepository<Room, Integer> {
	
	@Query("SELECT r FROM Room r where r.state = 'USED'")
	public Iterable<Room> getUsed();
	
	@Query("SELECT r FROM Room r where r.state = 'EMPTY'")
	public Iterable<Room> getUnused();
	
	public Room findByName(String name);
}
