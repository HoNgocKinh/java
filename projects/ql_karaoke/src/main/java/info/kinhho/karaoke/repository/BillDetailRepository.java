package info.kinhho.karaoke.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import info.kinhho.karaoke.entity.BillDetail;

@Repository
public interface BillDetailRepository extends JpaRepository<BillDetail, Long> {
	
	@Query("SELECT b FROM BillDetail b where room_id= :id and status = :status")
	public BillDetail getByRoomId(@Param("id") Long id, @Param("status") String status);
}
