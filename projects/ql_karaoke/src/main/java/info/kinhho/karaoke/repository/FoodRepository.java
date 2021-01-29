package info.kinhho.karaoke.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import info.kinhho.karaoke.entity.Food;

public interface FoodRepository extends CrudRepository<Food, Integer> {
	
	@Query("SELECT f FROM Food f")
	public Iterable<Food> get();
}
