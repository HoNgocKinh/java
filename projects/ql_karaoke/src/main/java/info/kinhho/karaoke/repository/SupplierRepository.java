package info.kinhho.karaoke.repository;

import info.kinhho.karaoke.entity.Supplier;

public interface SupplierRepository extends BaseRepository<Supplier> {
	
	Supplier findByName(String name);
}
