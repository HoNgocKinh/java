package aop.handler.impl;

import java.lang.reflect.Method;

import aop.handler.AfterHandler;

public class AfterHandlerImpl extends AfterHandler {

	@Override
	public void handleAfter(Object proxy, Method method, Object[] args) {
		// Provide your own cross cutting concern
        System.out.println("Handling after actual method execution");
        System.out.println("---");
	}
}
