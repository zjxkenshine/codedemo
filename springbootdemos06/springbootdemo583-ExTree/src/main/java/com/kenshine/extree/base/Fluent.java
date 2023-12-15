package com.kenshine.extree.base;

import co.streamx.fluent.extree.expression.*;

import java.io.Serializable;
import java.lang.reflect.Member;
import java.util.function.Function;

/**
 * @author kenshine
 */
public class Fluent<T> {

	/**
	 * 此接口是使lambda序列化所必需的，这消除了对jdk.internal.lambda.dumpProxyClasses系统属性的需要
	 */
	public static interface Property<T, R> extends Function<T, R>, Serializable {
	}

	public Fluent<T> property1(Property<T, ?> propertyRef) {
		LambdaExpression<Function<T, ?>> parsed = LambdaExpression
				.parse(propertyRef);
		Expression body = parsed.getBody();
		Expression methodCall = body;

		// 一元运算表达式
		while (methodCall instanceof UnaryExpression) {
			methodCall = ((UnaryExpression) methodCall).getFirst();
		}

		// 省略了检查
		Member member = ((MemberExpression) ((InvocationExpression) methodCall).getTarget()).getMember();

		System.out.println(member.getName());
		return this;
	}

	private LambdaExpression<Function<T, ?>> parsed;
	private String member;

	public Fluent<T> property(Property<T, ?> propertyRef) {
		LambdaExpression<Function<T, ?>> parsed = LambdaExpression
				.parse(propertyRef);
		Expression body = parsed.getBody();
		Expression method = body;
		while (method instanceof UnaryExpression) {
			method = ((UnaryExpression) method).getFirst();
		}

		member = ((MemberExpression) ((InvocationExpression) method)
				.getTarget()).getMember().toString();
		this.parsed = parsed;
		return this;
	}

	public LambdaExpression<Function<T, ?>> getParsed() {
		return parsed;
	}

	public String getMember() {
		return member;
	}


}