package info.kinhho.karaoke.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import info.kinhho.karaoke.entity.Supplier;

@Repository
public interface SupplierRepository extends JpaRepository<Supplier, Long>  {
	
	Supplier findByName(String name);
}
