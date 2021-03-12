package info.kinhho.karaoke.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import info.kinhho.karaoke.entity.PackageProduct;

@Repository
public interface PackageProductRepository extends JpaRepository<PackageProduct, Long> {
	
}
