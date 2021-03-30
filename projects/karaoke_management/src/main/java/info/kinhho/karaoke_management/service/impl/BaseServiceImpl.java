package info.kinhho.karaoke_management.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import info.kinhho.karaoke_management.entities.BaseEntity;
import info.kinhho.karaoke_management.repository.BaseRepository;
import info.kinhho.karaoke_management.service.BaseService;

public abstract class BaseServiceImpl <E extends BaseEntity, R extends BaseRepository<E>> implements BaseService<E> {

	@Autowired
	protected R repository;
	
	public BaseServiceImpl() { } 
	
	public BaseServiceImpl(R repository) {
		this.repository = repository;
	}

	@Override
	public List<E> findAll() {
		
		return repository.findAll();
	}
	
	public List<E> findAllByActive(boolean active) {
		return repository.findAllByActive(active);
	}
	
	public E findById(Long id) {
		return repository.findById(id).get();
	}
	
	public List<E> findAllByIds(List<Long> ids) {
		return repository.findAllById(ids);
	}
	
	public void update(E e) {
		repository.save(e);
	}
	
	public void save(E e) {
		repository.save(e);
	}
	public void delete(Long id) {
		repository.deleteById(id);
	}	
}
