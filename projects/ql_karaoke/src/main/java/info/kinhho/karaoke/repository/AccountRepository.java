package info.kinhho.karaoke.repository;

import org.springframework.data.repository.CrudRepository;

import info.kinhho.karaoke.entity.Account;

public interface AccountRepository extends CrudRepository<Account, Integer> {
	
	Account findByUsername(String username);
	
}
