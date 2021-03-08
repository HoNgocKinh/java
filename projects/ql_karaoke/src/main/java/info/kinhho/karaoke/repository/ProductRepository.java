package info.kinhho.karaoke.repository;

import org.springframework.data.jpa.repository.Query;

import info.kinhho.karaoke.entity.Product;

public interface ProductRepository extends BaseRepository<Product> {
	
	@Query("SELECT p FROM Product p")
	public Iterable<Product> get();
}
