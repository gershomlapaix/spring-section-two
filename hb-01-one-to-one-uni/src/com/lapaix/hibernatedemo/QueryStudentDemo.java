package com.lapaix.hibernatedemo;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.lapaix.entity.Student;

public class QueryStudentDemo {

	public static void main(String[] args) {
		
		// create a session factory
		SessionFactory sessionFactory = new Configuration().configure().addAnnotatedClass(Student.class).buildSessionFactory();
		
		// create a session
		Session session = sessionFactory.getCurrentSession();
		
		try {
			
			// begin the transaction
			session.beginTransaction();
			
			// query students
			List<Student> theStudents = session.createQuery("from Student").list();
			
			// query students: lastName = "Doe" OR firstName="Daffy"
			theStudents = session.createQuery("from Student s where s.lastName='Doe' OR s.firstName='Daffy'").list();
			
			// query students whose email ends with gmail.com
//			theStudents = session.createQuery("from )
			
			// display the students
			for(Student tempStudent: theStudents) {
				System.out.println(tempStudent);
			}
			// commit transaction
			session.getTransaction().commit();
			
			System.out.println("Done!");
			
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
