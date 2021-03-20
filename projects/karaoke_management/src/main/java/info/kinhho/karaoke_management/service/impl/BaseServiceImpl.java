package info.kinhho.karaoke_management.service.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;

import info.kinhho.karaoke_management.dtos.BaseDTO;
import info.kinhho.karaoke_management.entities.BaseEntity;
import info.kinhho.karaoke_management.repository.BaseRepository;
import info.kinhho.karaoke_management.service.BaseService;

public abstract class BaseServiceImpl <E extends BaseEntity, D extends BaseDTO, R extends BaseRepository<E>> implements BaseService<D> {

	@Autowired
	protected R repository;
	
	public BaseServiceImpl() { } 
	
	public BaseServiceImpl(R repository) {
		this.repository = repository;
	}
	
	public abstract D toDto(E e);
	public abstract E toEntity(D d);
	
	@Override
	public List<D> findAll() {
		
		return convertListDto(repository.findAll());
	}
	
	public List<D> findAllByActive(boolean active) {
		return convertListDto(repository.findAllByActive(active));
	}
	
	public D findById(Long id) {
		return toDto(repository.findById(id).get());
	}
	
	public List<D> findAllByIds(List<Long> ids) {
		return convertListDto(repository.findAllById(ids));
	}
	
	public void save(D d) {
		E e = toEntity(d);
		repository.save(e);
	}
	
	public void update(D d) {
		E e = toEntity(d);
		repository.save(e);
	}
	
	public void update(E e) {
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
	
	private List<D> convertListDto(List<E> entities) {
		return entities.stream().parallel().map(this::toDto).collect(Collectors.toList());
	}
}
