package com.lapaix.hibernatedemo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.lapaix.entity.Instructor;
import com.lapaix.entity.InstructorDetail;
import com.lapaix.entity.Student;

public class DeleteDemo {

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
			
			// create the objects
			Instructor instructor = new Instructor("Patrick", "Bisoso", "bisoso@gmail.com");
			InstructorDetail insDetail = new InstructorDetail("https://www.bisoso/youtube", "Patrick");
			
			//associate the objects
			instructor.setInstructorDetail(insDetail);
			
			// start transaction
			session.beginTransaction();
			
			
			//save the instructor
			// Note: this will also save the instructorDetail because of cascade
			System.out.println("Saving the instructor");
			session.save(instructor);
			
			// commit transaction
			session.getTransaction().commit();
			System.out.println("Done!");
		} finally {
			sessionFactory.close();
		}
	}

}
