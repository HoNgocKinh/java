package info.kinhho.karaoke.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import info.kinhho.karaoke.entity.BillDetail;
import info.kinhho.karaoke.entity.DetailProduct;

@Repository
public interface DetailProductRepository extends JpaRepository<DetailProduct, Long> {
	
}
