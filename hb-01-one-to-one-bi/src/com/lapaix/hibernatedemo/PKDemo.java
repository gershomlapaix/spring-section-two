package com.lapaix.hibernatedemo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.lapaix.entity.Student;

public class PKDemo {

	public static void main(String[] args) {
		// create a session factory
				SessionFactory sessionFactory = new Configuration().configure().addAnnotatedClass(Student.class).buildSessionFactory();
				
				// create a session
				Session session = sessionFactory.getCurrentSession();
				
				try {
					// create a student object
					System.out.println("Creating new student object.");
					Student student1= new Student("Kalim", "Mario", "kalim@gmail.com");
					Student student2= new Student("Vandamme", "Bruce", "bruce@gmail.com");
					Student student3= new Student("Patrick", "Mas", "mas@gmail.com");
					
					// start a transaction
					session.beginTransaction();
					
					// save the student object
					System.out.println("Saving the student");
					session.save(student1);
					session.save(student2);
					session.save(student3);
					
					// commit transaction
					session.getTransaction().commit();
				} catch (Exception e) {
					e.printStackTrace();
				}
	}

}
