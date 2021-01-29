package info.kinhho.karaoke.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import info.kinhho.karaoke.entity.BillDetail;

public interface BillDetailRepository extends CrudRepository<BillDetail, Integer> {

	
	@Query("SELECT b FROM BillDetail b where room_id= :id and state = :state")
	public BillDetail getByRoomId(@Param("id") Integer id, @Param("state") String state);
}
