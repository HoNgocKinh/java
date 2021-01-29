package info.kinhho.karaoke.repository;

import org.springframework.data.repository.CrudRepository;

import info.kinhho.karaoke.entity.Producer;

public interface ProducerRepository extends CrudRepository<Producer, Integer> {
	
	Producer findByName(String name);
}
