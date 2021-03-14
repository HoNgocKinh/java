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
}
