package info.kinhho.karaoke_management.service;

import org.springframework.stereotype.Service;

import info.kinhho.karaoke_management.entities.Account;

@Service
public interface AccountService extends BaseService<Account> {
	
	Account findByUsername(String username);
	void deleteAll();
}
