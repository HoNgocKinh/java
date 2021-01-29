package aop.handler;

import java.lang.reflect.Method;

public abstract class BeforeHandler extends AbstractHandler {

	/**
     * Handles before execution of actual method.
     */
    public abstract void handleBefore(Object proxy, Method method, Object[] args);
 
   
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        handleBefore(proxy, method, args);
        return method.invoke(getTargetObject(), args);
    }
}
