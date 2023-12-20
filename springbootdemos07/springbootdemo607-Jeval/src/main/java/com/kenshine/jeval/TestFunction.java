package com.kenshine.jeval;

import net.sourceforge.jeval.EvaluationException;
import net.sourceforge.jeval.Evaluator;
import net.sourceforge.jeval.function.*;

/**
 * 自定义方法 反转
 * @author kenshine
 */
public class TestFunction implements Function {
	/**
	 * 方法名称
	 */
	@Override
	public String getName() {
		return "stringReverse";
	}

	/**
	 * 执行指定参数的函数
	 */
	@Override
	public FunctionResult execute(Evaluator evaluator, String arguments) throws FunctionException {
		String result = "";
		try {
			String stringValue = new Evaluator().evaluate(arguments, true, false);
			// 参数1
			String argumentOne = FunctionHelper.trimAndRemoveQuoteChars(stringValue, evaluator.getQuoteCharacter());
			int size = argumentOne.length();
			for (int index = size - 1; index >= 0; index--) {
				result = result + argumentOne.charAt(index);
			}
		} catch (FunctionException fe) {
			throw new FunctionException(fe.getMessage(), fe);
		} catch (EvaluationException ee) {
			throw new FunctionException("Invalid expression in arguments.", ee);
		} catch (Exception e) {
			throw new FunctionException("One string argument is required.", e);
		}
		return new FunctionResult(result, FunctionConstants.FUNCTION_RESULT_TYPE_STRING);
	}
}