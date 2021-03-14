package info.kinhho.karaoke_management.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import info.kinhho.karaoke_management.entities.BillDetail;


@Repository
public interface BillDetailRepository extends BaseRepository<BillDetail> {
	
	@Query("SELECT b FROM BillDetail b where room_id= :id and status = :status")
	public BillDetail getByRoomId(@Param("id") Long id, @Param("status") String status);
}
