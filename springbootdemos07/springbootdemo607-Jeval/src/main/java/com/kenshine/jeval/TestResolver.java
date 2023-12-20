package com.kenshine.jeval;

import net.sourceforge.jeval.VariableResolver;
import net.sourceforge.jeval.function.FunctionException;

/**
 * 自定义参数解析器
 * @author kenshine
 */
public class TestResolver implements VariableResolver {

	/**
	 * 解析参数
	 */
	@Override
	public String resolveVariable(String variableName) throws FunctionException {
		String returnValue = null;
		if (variableName.equals("v1")) {
			returnValue = "1";
		} else if (variableName.equals("v2")) {
			returnValue = "2";
		} else if (variableName.equals("null")) {
			throw new FunctionException("自定义异常!");
		}
		return returnValue;
	}
}