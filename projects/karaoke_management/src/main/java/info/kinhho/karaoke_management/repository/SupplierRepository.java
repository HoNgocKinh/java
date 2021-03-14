package info.kinhho.karaoke_management.repository;

import org.springframework.stereotype.Repository;

import info.kinhho.karaoke_management.entities.Supplier;

@Repository
public interface SupplierRepository extends BaseRepository<Supplier>  {
	
	Supplier findByName(String name);
}
