package com.kenshine.noson.entity;

import lombok.Data;

@Data
public class Cycle {

	private String id = null;

	private Cycle cycle = this;
}