package com.kenshine.extree.base;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(of = "name")
public class Person {
	private String name;
	private int age;
	private Integer height = 1;
	private Person parent;

	public boolean isAdult() {
		return age >= 18;
	}
}