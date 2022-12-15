package com.lapaix.hibernatedemo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

import com.lapaix.entity.Course;
import com.lapaix.entity.Instructor;
import com.lapaix.entity.InstructorDetail;
import com.lapaix.entity.Student;

public class FetchJoinDemo {

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
			
			/** THIS IS FOR RESOLVING THE ISSUE OF lazy load while session is close */
			
			int instructorId = 2;
			
			// hibernate query
			Query<Instructor> query = session.createQuery("select i from Instructor i "
					+"JOIN FETCH i.courses "
					+"where i.id=:theInstructorId", Instructor.class);
			
			// set parameter on a query
			query.setParameter("theInstructorId", instructorId);
			
			// execute the query
			Instructor tempInstructor = query.getSingleResult();
			
			System.out.println("lapaixOrg: Instructor : "+tempInstructor);
			
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
