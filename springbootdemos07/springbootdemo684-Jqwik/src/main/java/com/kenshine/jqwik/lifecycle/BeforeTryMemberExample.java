package com.kenshine.jqwik.lifecycle;

import net.jqwik.api.ForAll;
import net.jqwik.api.Property;
import net.jqwik.api.lifecycle.BeforeTry;
import net.jqwik.api.lifecycle.PerProperty;
import net.jqwik.api.lifecycle.PropertyExecutionResult;
import org.assertj.core.api.Assertions;

/**
 * @BeforeTry 修饰变量
 * @author kenshine
 */
public class BeforeTryMemberExample {

	@BeforeTry
	int theAnswer = 42;

	@Property
	void theAnswerIsAlways42(@ForAll int addend) {
		Assertions.assertThat(theAnswer).isEqualTo(42);
		theAnswer += addend;
	}

	@Property
	@PerProperty(SucceedIfThrowsAssertionError.class)
	void expectToFail(@ForAll int aNumber) {
		Assertions.assertThat(aNumber).isNotEqualTo(1);
	}

	private class SucceedIfThrowsAssertionError implements PerProperty.Lifecycle {
		@Override
		public PropertyExecutionResult onFailure(PropertyExecutionResult propertyExecutionResult) {
			if (propertyExecutionResult.throwable().isPresent() &&
					propertyExecutionResult.throwable().get() instanceof AssertionError) {
				return propertyExecutionResult.mapToSuccessful();
			}
			return propertyExecutionResult;
		}
	}
}