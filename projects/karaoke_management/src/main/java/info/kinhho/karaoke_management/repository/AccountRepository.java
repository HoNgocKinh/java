package info.kinhho.karaoke_management.repository;

import org.springframework.stereotype.Repository;

import info.kinhho.karaoke_management.entities.Account;


@Repository
public interface AccountRepository extends BaseRepository<Account> {
	
	Account findByUsername(String username);
}
