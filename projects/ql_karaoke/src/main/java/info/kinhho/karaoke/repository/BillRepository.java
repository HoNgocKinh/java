package info.kinhho.karaoke.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import info.kinhho.karaoke.entity.Bill;

@Repository
public interface BillRepository extends JpaRepository<Bill, Long>  {

}
