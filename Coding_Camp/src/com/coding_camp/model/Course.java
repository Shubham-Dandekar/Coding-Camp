package com.coding_camp.model;

public class Course {
	private int id;
	private String name;
	private int fee;
	private String duration;
	
	public Course(int id, String name, int fee, String duration) {
		super();
		this.id = id;
		this.name = name;
		this.fee = fee;
		this.duration = duration;
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getFee() {
		return fee;
	}
	public void setFee(int fee) {
		this.fee = fee;
	}
	public String getDuration() {
		return duration;
	}
	public void setDuration(String duration) {
		this.duration = duration;
	}

	@Override
	public String toString() {
		return "Course [id=" + id + ", name=" + name + ", fee=" + fee + ", duration=" + duration + "]";
	}
		
}
