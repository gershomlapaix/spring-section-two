package com.lapaix.hibernatedemo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.lapaix.entity.Student;

public class UpdateDataDemo {
	public static void main(String[] args) {
		SessionFactory sessionFactory = 
				new Configuration()
				.configure()
				.addAnnotatedClass(Student.class)
				.buildSessionFactory();
		
		Session session = sessionFactory.getCurrentSession();
		
		session.beginTransaction();
		
		try {
			int studentId = 1;
			
			System.out.println("Get student with id "+ studentId);
			Student myStudent = session.get(Student.class, studentId);
			
			System.out.println("Updating student's data...");
			myStudent.setEmail("1@lapaix.com");
			
			
			// update email for all students
			System.out.println("Update email for all the students");
			session.createQuery("update Student set email='foo@lapaix.com'").executeUpdate();
			
			session.getTransaction().commit();
			System.out.println("Done!");
	
		}
		finally {
			sessionFactory.close();
		}
		
	}
}
