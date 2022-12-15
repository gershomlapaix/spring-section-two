package com.lapaix.hibernatedemo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.lapaix.entity.Course;
import com.lapaix.entity.Instructor;
import com.lapaix.entity.InstructorDetail;
import com.lapaix.entity.Student;

public class EagerLazyDemo {

	public static void main(String[] args) {
		
		// create a session factory
		SessionFactory sessionFactory = new Configuration()
				.configure()
				.addAnnotatedClass(Instructor.class)
				.addAnnotatedClass(InstructorDetail.class)
				.addAnnotatedClass(Course.class)
				.buildSessionFactory();
		
		// create a session
		Session session = sessionFactory.getCurrentSession();
		
		try {
			// start transaction
			session.beginTransaction();
			
			int instructorId = 2;
			Instructor tempInstructor = session.get(Instructor.class, instructorId);
			
			System.out.println("lapaixOrg: Instructor : "+tempInstructor);
			
			// get courses for the instructor
			System.out.println("lapaixOrg: Courses:  "+tempInstructor.getCourses());
			
			// commit transaction
			session.getTransaction().commit();
			session.close();
			
			// THE DATA WILL BE THERE BECAUSE IT IS LOADED IN THE MEMORY
			System.out.println("\nlapaixOrg: the session is now closed\n");
			System.out.println("lapaixOrg: Courses:  "+tempInstructor.getCourses());
			System.out.println("lapaixOrg: Done!");
		} finally {
			sessionFactory.close();
		}

	}

}
