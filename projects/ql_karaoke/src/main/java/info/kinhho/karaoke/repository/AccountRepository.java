package info.kinhho.karaoke.repository;

import info.kinhho.karaoke.entity.Account;

public interface AccountRepository extends BaseRepository<Account> {
	
	Account findByUsername(String username);
}
