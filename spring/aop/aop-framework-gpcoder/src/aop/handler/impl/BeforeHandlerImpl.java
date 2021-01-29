package aop.handler.impl;

import java.lang.reflect.Method;

import aop.handler.BeforeHandler;

public class BeforeHandlerImpl extends BeforeHandler {

	@Override
	public void handleBefore(Object proxy, Method method, Object[] args) {
		// Provide your own cross cutting concern
        System.out.println("Handling before actual method execution");
	}
}
