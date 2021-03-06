package com.example.basic_authen.securiry;

import org.springframework.data.jpa.repository.JpaRepository;

public interface AccountRepository extends JpaRepository<Account, Long> {
	
	public Account findByUsername(String username);
}
