package aop.account;

import java.util.List;
import java.util.ArrayList;

public class AccountServiceImpl implements AccountService {
	
	private List<Account> accounts = new ArrayList<>();
	
	@Override
	public void addAccount(Account account) {
		// TODO Auto-generated method stub
		System.out.println("Add Account Method!");
		accounts.add(account);
	}

	@Override
	public void removeAccount(Account account) {
		// TODO Auto-generated method stub
		System.out.println("Remove Account Method!");
		accounts.remove(account);
	}

	@Override
	public int getSize() {
		System.out.println("getSize: " + accounts.size());
		return accounts.size();
	}
}
