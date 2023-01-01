package com.demo.hibernate;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.demo.hibernate.entity.Course;
import com.demo.hibernate.entity.Instructor;
import com.demo.hibernate.entity.InstructorDetail;


public class CreateCourseDemo {

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
			
			Course newCourse1 = new Course("Kung-fu");
			Course newCourse2 = new Course("taekwondo");
			Course newCourse3 = new Course("judo - utlimate guide");
			
			tempInstructor.add(newCourse1);
			tempInstructor.add(newCourse2);
			tempInstructor.add(newCourse3);
			
			session.save(newCourse1);
			session.save(newCourse2);
			session.save(newCourse3);
			
			session.getTransaction().commit();
			
			System.out.println("Done !!!");
		} finally {
			//clean up code
			session.close();
			factory.close();
		}
		
		
		
		
	}

}
