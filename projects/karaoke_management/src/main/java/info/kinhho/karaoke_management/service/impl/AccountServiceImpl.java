package info.kinhho.karaoke_management.service.impl;

import java.util.Objects;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import info.kinhho.karaoke_management.entities.Account;
import info.kinhho.karaoke_management.repository.AccountRepository;
import info.kinhho.karaoke_management.service.AccountService;

@Service
public class AccountServiceImpl extends BaseServiceImpl<Account, AccountRepository> 
								implements AccountService, UserDetailsService {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(AccountServiceImpl.class);
	
	@Autowired
	private PasswordEncoder passwordEncoder;
	
	public AccountServiceImpl() { }
	
	public AccountServiceImpl(AccountRepository repository) {
		super(repository);
	}
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
	
		Account account = repository.findByUsername(username);
		if (Objects.isNull(account)) {
			LOGGER.info("Username not found in database");
            throw new UsernameNotFoundException("User " + username + " was not found in the database");
		}
		
		LOGGER.info("Username {} logged in!", account.getJsonObject());
		return account;
	}

	public void createSeedData() {
		
		Account account1 = new Account(1L, "admin", passwordEncoder.encode("123456"), "ADMIN", "INSERT, READ, UPDATE,DELETE", "ADMIN");
		Account account2 = new Account(2L, "staff", passwordEncoder.encode("123456"), "STAFF", "INSERT, READ", "ADMIN");
		Account account3 = new Account(3L, "account", passwordEncoder.encode("123456"), "ACCOUNTING", "READ, STATISTIC", "ACCOUNTING");
		
		repository.save(account1);
		repository.save(account2);
		repository.save(account3);
	}

	public void deleteAll() {
		repository.deleteAll();
	}
	
	@Override
	public void unactive(Long id) {
		
	}
}
