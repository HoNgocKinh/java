package info.kinhho.karaoke_management.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.NoRepositoryBean;

import info.kinhho.karaoke_management.entities.BaseEntity;

@NoRepositoryBean
public interface BaseRepository<E extends BaseEntity> extends JpaRepository<E, Long>{
	
	@Query("SELECT e FROM #{#entityName} e WHERE e.active = :active")
	public List<E> findAllByActive(boolean active);
}
