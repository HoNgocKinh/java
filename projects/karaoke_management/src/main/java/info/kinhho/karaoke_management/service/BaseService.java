package info.kinhho.karaoke_management.service;

import java.util.List;

import org.springframework.stereotype.Service;

import info.kinhho.karaoke_management.entities.BaseEntity;

@Service
public interface BaseService <E extends BaseEntity>{

	public List<E> findAll();
	public List<E> findAllByActive(boolean active);
	public E findById(Long id);
	public List<E> findAllByIds(List<Long> ids);
	public void save(E e);
	public void update(E e);
	public void delete(Long id);
	public void deleteAll();
	public void unactive(Long id);
	public void unactiveAll();
	
	public void createSeedData();
}
