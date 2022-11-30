package com.lapaix.entity;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name="student")
public class Student {
	
	String firstNaeme;
	String lastName;
	String email;
}
