package com.lapaix.hibernatedemo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.lapaix.entity.Student;

public class ReadStudents {

	public static void main(String[] args) {
		
		// create a session factory
		SessionFactory sessionFactory = new Configuration().configure().addAnnotatedClass(Student.class).buildSessionFactory();
		
		// create a session
		Session session = sessionFactory.getCurrentSession();
		
		try {
			// create a student object
			System.out.println("Creating new student object.");
			Student student = new Student("Daffy", "Dark", "daffy@gmail.com");
			
			// start a transaction
			session.beginTransaction();
			
			// save the student object
			System.out.println("Saving the student");
			session.save(student);
			
			// READING DATA
			
			// find out the student's id: primary key
			System.out.println("New student generated id is: "+ student.getId());
			
			//now get a new session and start transaction
			session = sessionFactory.getCurrentSession();
//			session.beginTransaction();
			
		    Student readStudent = session.get(Student.class, student.getId());
		    System.out.println("Found student:: "+readStudent);
			
			// retrieve student based on the id: primary key
			// commit transaction
			session.getTransaction().commit();
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
