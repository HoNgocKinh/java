package info.kinhho.karaoke_management.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import info.kinhho.karaoke_management.entities.Room;

@Repository
public interface RoomRepository extends BaseRepository<Room>  {
	
	@Query("SELECT r FROM Room r where r.status = 'USED'")
	public Iterable<Room> getUsed();
	
	@Query("SELECT r FROM Room r where r.status = 'EMPTY'")
	public Iterable<Room> getUnused();
	
	public Room findByName(String name);
}
