package info.kinhho.karaoke_management.service;

import java.util.List;

import org.springframework.stereotype.Service;

import info.kinhho.karaoke_management.dtos.BaseDTO;

@Service
public interface BaseService <D extends BaseDTO>{

	public List<D> findAll();
	public List<D> findAllByActive(boolean active);
	public D findById(Long id);
	public List<D> findAllByIds(List<Long> ids);
	public void save(D e);
	public void update(D e);
	public void delete(Long id);
	public void deleteAll();
	public void unactive(Long id);
	public void unactiveAll();
	
	public void createSeedData();
}
