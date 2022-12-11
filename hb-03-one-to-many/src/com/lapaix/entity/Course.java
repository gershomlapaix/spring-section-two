package com.lapaix.entity;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name="course")
public class Course {
	/**
	 *  define the fields
	 *  define constructors
	 *  define getter and setters
	 *  define toString()
	 *  annotate fields
	 * */
	
	private int id;
	private String title;
	private Instructor instructor;
	
	public Course() {}

	public Course(String title, Instructor instructor) {
		this.title = title;
		this.instructor = instructor;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public Instructor getInstructor() {
		return instructor;
	}

	public void setInstructor(Instructor instructor) {
		this.instructor = instructor;
	}

	@Override
	public String toString() {
		return "Course [id=" + id + ", title=" + title + ", instructor=" + instructor + "]";
	}
	
}
