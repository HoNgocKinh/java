package info.kinhho.karaoke.services;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import info.kinhho.karaoke.entity.Account;
import info.kinhho.karaoke.repository.AccountRepository;


@Service
public class AccountService {

	private AccountRepository accountRepository;	
	private PasswordEncoder passwordEncoder;
	
	public AccountService(AccountRepository accountRepository, PasswordEncoder passwordEncoder) {
		this.passwordEncoder = passwordEncoder;
		this.accountRepository = accountRepository;
	}
	
	public void createSeedData() {
				
		//adding infomation into account table
		Account account1 = new Account(1, "admin", passwordEncoder.encode("123456"), "Admin", "INSERT, READ, UPDATE,DELETE", "ADMIN");
		Account account2 = new Account(2, "staff", passwordEncoder.encode("123456"), "Staff", "INSERT,READ", "STAFF");
		Account account3 = new Account(3, "accounting", passwordEncoder.encode("123456"), "Accounting", "READ,STATISTIC", "ACCOUNTING");		
		
		accountRepository.save(account1);    
		accountRepository.save(account2);	
		accountRepository.save(account3);	
	}
}
