package com.lapaix.hibernatedemo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.lapaix.entity.Instructor;
import com.lapaix.entity.InstructorDetail;
import com.lapaix.entity.Student;

public class CreateDemo {

	public static void main(String[] args) {
		
		// create a session factory
		SessionFactory sessionFactory = new Configuration()
				.configure()
				.addAnnotatedClass(Instructor.class)
				.addAnnotatedClass(InstructorDetail.class)
				.buildSessionFactory();
		
		// create a session
		Session session = sessionFactory.getCurrentSession();
		
		try {
			
			// start transaction
			session.beginTransaction();
			
			// get instructor using primary key
			int instructorId = 1;
			Instructor tempInstructor = session.get(Instructor.class, instructorId);
			
			// delete that instructor
			if(tempInstructor != null) {
				System.out.println("Deleting: "+tempInstructor);
				
				// this will also delete the instructor's details
				session.delete(tempInstructor);
			}
			else {
				System.out.println("No such instructor found");
			}
			
			// commit transaction
			session.getTransaction().commit();
			System.out.println("Done!");
		} finally {
			sessionFactory.close();
		}

	}

}
