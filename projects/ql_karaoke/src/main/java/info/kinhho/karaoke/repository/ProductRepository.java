package info.kinhho.karaoke.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import info.kinhho.karaoke.entity.DetailProduct;
import info.kinhho.karaoke.entity.Product;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {
	
	@Query("SELECT p FROM Product p")
	public Iterable<Product> get();
}
