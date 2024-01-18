package com.kenshine.jqwik.parameter;

import net.jqwik.api.*;
import net.jqwik.api.arbitraries.CharacterArbitrary;
import net.jqwik.api.arbitraries.StringArbitrary;
import net.jqwik.api.statistics.Statistics;

import java.io.Serializable;
import java.util.List;

/**
 * 处理类型变量和通配符类型
 * @author kenshine
 */
public class VariableTypedPropertyExamples {

	@Property
	<T> boolean unboundedGenericTypesAreResolved(@ForAll List<T> items, @ForAll T newItem) {
		items.add(newItem);
		return items.contains(newItem);
	}

	@Property
	<T extends Serializable & Comparable> void someBoundedGenericTypesCanBeResolved(@ForAll List<T> items, @ForAll T newItem) {
	}

	@Property
	void someWildcardTypesWithUpperBoundsCanBeResolved(@ForAll List<? extends Serializable> items) {
	}


	@Property
	void abcdWithFrequencies(@ForAll("abcdWeighted") String aString) {
		Statistics.collect(aString);
	}

	/**
	 * 加权概率
	 */
	@Provide
	Arbitrary<String> abcdWeighted() {
		return Arbitraries.frequency(
				Tuple.of(1, "a"),
				Tuple.of(5, "b"),
				Tuple.of(10, "c"),
				Tuple.of(20, "d")
		);
	}


	/**
	 * string与char生成器
	 */
	CharacterArbitrary chars = Arbitraries.chars()
			.numeric()
			.alpha()
			.with('.', ',', ';', '!', '?');

	StringArbitrary strings = Arbitraries.strings()
			.numeric()
			.alpha()
			.withChars('.', ',', ';', '!', '?');
}