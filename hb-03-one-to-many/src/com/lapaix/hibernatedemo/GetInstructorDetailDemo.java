package com.lapaix.hibernatedemo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.lapaix.entity.Instructor;
import com.lapaix.entity.InstructorDetail;
import com.lapaix.entity.Student;

public class GetInstructorDetailDemo {

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
			
			// get the instructor detail object
			int theId = 2;
			InstructorDetail insDetail = session.get(InstructorDetail.class, theId);
			
			// print the instructor detail
			System.out.println("Instructor details" +insDetail);
			
			// get the associated instructor
			 System.out.println("Associated instructor: "+ insDetail.getInstructor());
			
			// commit transaction
			session.getTransaction().commit();
			System.out.println("Done!");
		}finally {
			sessionFactory.close();
		}
	}

}
