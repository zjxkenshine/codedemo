package com.kenshine.joddproxetta;

import jodd.proxetta.ProxyAdvice;
import jodd.proxetta.ProxyTarget;

/**
 * advice建议
 * @author kenshine
 */
public class LogProxyAdvice implements ProxyAdvice {

    @Override
    public Object execute() {
        int totalArgs = ProxyTarget.argumentsCount();
        Class target = ProxyTarget.targetClass();
        String methodName = ProxyTarget.targetMethodName();
        System.out.println(">>>" + target.getSimpleName()
                + '#' + methodName + ':' + totalArgs);
        Object result = ProxyTarget.invoke();
        System.out.println("<<<" + result);
        return result;
    }
}