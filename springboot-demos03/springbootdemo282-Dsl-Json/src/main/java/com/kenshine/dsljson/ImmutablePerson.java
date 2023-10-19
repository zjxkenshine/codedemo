package com.kenshine.dsljson;

import com.dslplatform.json.CompiledJson;

public class ImmutablePerson {

	public final String firstName;
	public final String lastName;
	public final int age;

	// 多个构造函数，@CompiledJson注释可以用来指定合适的构造函数
	@CompiledJson(formats = {CompiledJson.Format.ARRAY, CompiledJson.Format.OBJECT})
	public ImmutablePerson(String firstName, String lastName, int age) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.age = age;
	}
}