package info.kinhho.karaoke.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import info.kinhho.karaoke.entity.DetailProduct;
import info.kinhho.karaoke.entity.Package;

@Repository
public interface PackageRepository extends JpaRepository<Package, Long>  {
	
}
