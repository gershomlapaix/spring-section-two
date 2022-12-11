package com.lapaix.hibernatedemo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.lapaix.entity.Student;

public class CreateStudentDemo {

	public static void main(String[] args) {
		
		// create a session factory
		SessionFactory sessionFactory = new Configuration().configure().addAnnotatedClass(Student.class).buildSessionFactory();
		
		// create a session
		Session session = sessionFactory.getCurrentSession();
		
		try {
			// create a student object
			System.out.println("Creating new student object.");
			Student student = new Student("La paix", "Gersh", "gersh@gmail.com");
			
			// start a transaction
			session.beginTransaction();
			
			// save the student object
			System.out.println("Saving the student");
			session.save(student);
			
			// commit transaction
			session.getTransaction().commit();
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
