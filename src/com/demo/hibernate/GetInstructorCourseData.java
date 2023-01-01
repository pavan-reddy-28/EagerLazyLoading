
package com.demo.hibernate;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.demo.hibernate.entity.Course;
import com.demo.hibernate.entity.Instructor;
import com.demo.hibernate.entity.InstructorDetail;


public class GetInstructorCourseData {

	public static void main(String[] args) {
		
		// create SessionFactroy object
		
		SessionFactory factory = new Configuration()
									.configure("hibernate.cfg.xml")
									.addAnnotatedClass(Instructor.class)
									.addAnnotatedClass(InstructorDetail.class)
									.addAnnotatedClass(Course.class)
									.buildSessionFactory();
		
		//create session
		Session session = factory.getCurrentSession();
		try {
			Instructor tempInstructor;// = new Instructor("Danny","Rand","dannyRand@gmail.com");
			
			InstructorDetail tempDetails;// = new InstructorDetail("http://www.pavanreddy.youtube.com","Martial Arts");
			
			//tempInstructor.setInstructorDetailId(tempDetails);
//			
			session.beginTransaction();
			
			int theId = 1;
			
			tempInstructor = session.get(Instructor.class, theId);
			
			System.out.println(" getting instructor details based : instructor id :"+theId);
			
			System.out.println("Courses : "+tempInstructor.getCourses());
			
			
			session.getTransaction().commit();
			
			System.out.println("Done !!!");
		} finally {
			//clean up code
			session.close();
			factory.close();
		}
		
		
		
		
	}

}

