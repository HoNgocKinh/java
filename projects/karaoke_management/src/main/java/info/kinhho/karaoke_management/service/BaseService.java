package info.kinhho.karaoke_management.service;

import java.util.List;

import org.springframework.stereotype.Service;

import info.kinhho.karaoke_management.entities.BaseEntity;

@Service
public interface BaseService <E extends BaseEntity>{

	public List<E> findAll();
	public void createSeedData();
}
