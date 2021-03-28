package info.kinhho.karaoke_management.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import info.kinhho.karaoke_management.dtos.BaseDTO;
import info.kinhho.karaoke_management.entities.BaseEntity;
import info.kinhho.karaoke_management.repository.BaseRepository;
import info.kinhho.karaoke_management.service.BaseService;

public abstract class BaseServiceImpl <E extends BaseEntity, D extends BaseDTO, R extends BaseRepository<E>> implements BaseService<E> {

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
	
	public void deleteAll() {
		repository.deleteAll(); 
	}
	
	public void unactive(Long id) {
		E entity = repository.findById(id).get();
		entity.setActive(false);
		update(entity);
	}
	
	public void unactiveAll() {
		
		List<E> entities = repository.findAll();
		entities.stream().parallel().forEach(e -> {
			e.setActive(false);
			update(e);
		});
	}
	
//	private List<D> convertListDto(List<E> entities) {
//		if (Objects.isNull(entities)) return null;
//		return entities.stream().parallel().map(this::toDto).collect(Collectors.toList());
//	}
}
