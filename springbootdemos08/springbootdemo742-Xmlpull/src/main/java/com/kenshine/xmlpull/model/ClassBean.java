package com.kenshine.xmlpull.model;

import lombok.Data;

import java.util.List;

/**
 * 测试bean
 * @author kenshine
 */
@Data
public class ClassBean {
	private String id;
	private String name;
	private List<StudentBean> list;
}