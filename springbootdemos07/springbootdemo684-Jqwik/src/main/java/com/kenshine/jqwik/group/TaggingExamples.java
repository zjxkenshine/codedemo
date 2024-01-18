package com.kenshine.jqwik.group;

import net.jqwik.api.Example;
import net.jqwik.api.Property;
import net.jqwik.api.Tag;

/**
 * 标签测试
 * @author kenshine
 */
@Tag("integration-test")
public class TaggingExamples {

	@Property
	@Tag("fast")
	void aFastProperty() { }

	@Example
	@Tag("slow") @Tag("involved")
	void aSlowTest() { }
}