package com.kenshine.dsljson;

import com.dslplatform.json.JsonValue;

import java.math.BigDecimal;

public enum SpecialNumber {
	ONE(BigDecimal.ONE),
	PI(BigDecimal.valueOf(3.14159)),
	E(BigDecimal.valueOf(2.71828)),
	ZERO(BigDecimal.ZERO);

	private final BigDecimal value;

	SpecialNumber(BigDecimal value) {
		this.value = value;
	}

	//Enum可以保存为一些特定的值，而不是通过它的名称
	@JsonValue
	public BigDecimal getValue() {
		return value;
	}
}