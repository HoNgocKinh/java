package info.kinhho.karaoke_management.service.impl;

import org.springframework.stereotype.Service;

import info.kinhho.karaoke_management.dtos.AccountDTO;
import info.kinhho.karaoke_management.entities.Account;
import info.kinhho.karaoke_management.repository.AccountRepository;
import info.kinhho.karaoke_management.service.AccountService;

@Service
public class AccountServiceImpl extends BaseServiceImpl<Account, AccountDTO, AccountRepository> implements AccountService {

	public AccountServiceImpl() {
		
	}
	
	public AccountServiceImpl(AccountRepository repository) {
		super(repository);
	}
	
	public void createSeedData() {
		
		Account account1 = new Account(1L, "admin", "$2a$10$jIAMNrggaPRbdHljuK2lz.Apfvf.gGrGrelz5ZjOlJqaN9FHTnLbe", "ADMIN", "INSERT, READ, UPDATE,DELETE", "ADMIN");
		Account account2 = new Account(2L, "staff", "$2a$10$jIAMNrggaPRbdHljuK2lz.Apfvf.gGrGrelz5ZjOlJqaN9FHTnLbe", "STAFF", "INSERT, READ", "ADMIN");
		Account account3 = new Account(3L, "account", "$2a$10$jIAMNrggaPRbdHljuK2lz.Apfvf.gGrGrelz5ZjOlJqaN9FHTnLbe", "ACCOUNTING", "READ, STATISTIC", "ACCOUNTING");
		
		repository.save(account1);
		repository.save(account2);
		repository.save(account3);
	}

	@Override
	public AccountDTO toDto(Account e) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Account toEntity(AccountDTO d) {
		// TODO Auto-generated method stub
		return null;
	}
}
