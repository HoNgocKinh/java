package info.kinhho.karaoke.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import info.kinhho.karaoke.entity.BookRoom;

@Repository
public interface BookRoomRepository extends JpaRepository<BookRoom, Long>  {
	
}
