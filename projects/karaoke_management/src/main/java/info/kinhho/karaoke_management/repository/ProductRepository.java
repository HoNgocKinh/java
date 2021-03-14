package info.kinhho.karaoke_management.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import info.kinhho.karaoke_management.entities.Product;


@Repository
public interface ProductRepository extends BaseRepository<Product> {
	
	@Query("SELECT p FROM Product p")
	public Iterable<Product> get();
}
