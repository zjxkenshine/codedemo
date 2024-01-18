package com.kenshine.jqwik.group;

import net.jqwik.api.Disabled;
import net.jqwik.api.Property;

/**
 *
 * @author kenshine
 */
@Disabled("for whatever reason")
public class DisablingExamples {

	@Property
	@Disabled
	void aDisabledProperty() { }

}