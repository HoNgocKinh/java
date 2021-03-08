package info.kinhho.karaoke.repository;

import org.springframework.data.jpa.repository.Query;

import info.kinhho.karaoke.entity.Room;

public interface RoomRepository extends BaseRepository<Room> {
	
	@Query("SELECT r FROM Room r where r.status = 'USED'")
	public Iterable<Room> getUsed();
	
	@Query("SELECT r FROM Room r where r.status = 'EMPTY'")
	public Iterable<Room> getUnused();
	
	public Room findByName(String name);
}
