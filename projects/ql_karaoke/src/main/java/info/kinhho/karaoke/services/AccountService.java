package info.kinhho.karaoke.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import info.kinhho.karaoke.entity.Account;
import info.kinhho.karaoke.repository.AccountRepository;

@Service
public class AccountService extends BaseService<Account, AccountRepository>{
	
	@Autowired
	private PasswordEncoder passwordEncoder;
	
	public AccountService() { }

	public void createSeedData() {
				
		//adding infomation into account table
		Account account1 = new Account(1l, "admin", passwordEncoder.encode("123456"), "ADMIN", "INSERT, READ, UPDATE,DELETE", "ADMIN");
		Account account2 = new Account(2l, "staff", passwordEncoder.encode("123456"), "STAFF", "INSERT,READ", "STAFF");
		Account account3 = new Account(3l, "accounting", passwordEncoder.encode("123456"), "ACCOUNTING", "READ,STATISTIC", "ACCOUNTING");		
		
		repository.save(account1);    
		repository.save(account2);	
		repository.save(account3);	
	}	
}
