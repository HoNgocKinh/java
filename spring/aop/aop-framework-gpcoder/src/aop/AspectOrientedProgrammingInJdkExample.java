package aop;

import java.util.ArrayList;
import java.util.List;

import aop.account.Account;
import aop.account.AccountService;
import aop.account.AccountServiceImpl;
import aop.handler.AbstractHandler;
import aop.handler.ProxyFactory;
import aop.handler.impl.AfterHandlerImpl;
import aop.handler.impl.BeforeHandlerImpl;

public class AspectOrientedProgrammingInJdkExample {
	
	public static void main(String[] args) {
		 
        List<AbstractHandler> handlers = new ArrayList<>();
        handlers.add(new BeforeHandlerImpl());
        handlers.add(new AfterHandlerImpl());
 
        AccountService proxy = (AccountService) ProxyFactory.getProxy(new AccountServiceImpl(), handlers);
        Account account = new Account("gpcoder", "USD", 100);
        proxy.addAccount(account);
        proxy.getSize();
        proxy.removeAccount(account);
        proxy.getSize();
    }
}
