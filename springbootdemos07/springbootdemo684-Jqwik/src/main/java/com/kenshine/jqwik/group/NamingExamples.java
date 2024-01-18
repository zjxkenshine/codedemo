package com.kenshine.jqwik.group;

import net.jqwik.api.Example;
import net.jqwik.api.Group;
import net.jqwik.api.Label;
import net.jqwik.api.Property;

/**
 * @Label 测试命名
 * @author kenshine
 */
@Label("Naming")
public class NamingExamples {

	@Property
	@Label("a property")
	void aPropertyWithALabel() { }

	@Group
	@Label("A Group")
	class GroupWithLabel {
		@Example
		@Label("an example with äöüÄÖÜ")
		void anExampleWithALabel() { }
	}

    @Group
    class Group_with_spaces {
        @Example
        void example_with_spaces() { }
    }

}