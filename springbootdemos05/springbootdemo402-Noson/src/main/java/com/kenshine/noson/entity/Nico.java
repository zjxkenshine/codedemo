package com.kenshine.noson.entity;

import lombok.Data;


import java.util.Set;

@Data
public class Nico {

	private String name;

	private int age;

	private Set<String> skill;

	private double deposit;

	private Info info;

	public static class Info{

		private String address;

		private Job job;

		public String getAddress() {
			return address;
		}

		public void setAddress(String address) {
			this.address = address;
		}

		public Job getJob() {
			return job;
		}

		public void setJob(Job job) {
			this.job = job;
		}

		@Override
		public String toString() {
			return "info [address=" + address + ", job=" + job + "]";
		}

	}

	public static enum Job{

		IT,

		OTHER

	}
}