package info.kinhho.karaoke.repository;

import org.springframework.data.repository.CrudRepository;

import info.kinhho.karaoke.entity.Bill;

public interface BillRepository extends CrudRepository<Bill, Integer> {

}
