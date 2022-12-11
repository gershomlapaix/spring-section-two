package com.lapaix.hibernatedemo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.lapaix.entity.Course;
import com.lapaix.entity.Instructor;
import com.lapaix.entity.InstructorDetail;
import com.lapaix.entity.Student;

public class GetInstructorCoursesDemo {

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
			
			System.out.println("Instructor : "+tempInstructor);
			
			// get courses for the instructor
			System.out.println("Courses:  "+tempInstructor.getCourses());
			
			// commit transaction
			session.getTransaction().commit();
			System.out.println("Done!");
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
