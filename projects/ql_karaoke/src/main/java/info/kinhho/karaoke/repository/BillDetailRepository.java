package info.kinhho.karaoke.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import info.kinhho.karaoke.entity.BillDetail;

public interface BillDetailRepository extends BaseRepository<BillDetail> {
	
	@Query("SELECT b FROM BillDetail b where room_id= :id and status = :status")
	public BillDetail getByRoomId(@Param("id") Long id, @Param("status") String status);
}
