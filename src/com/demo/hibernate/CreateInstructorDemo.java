package com.demo.hibernate;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.demo.hibernate.entity.Course;
import com.demo.hibernate.entity.Instructor;
import com.demo.hibernate.entity.InstructorDetail;


public class CreateInstructorDemo {

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
			Instructor tempInstructor = new Instructor("Danny","Rand","dannyRand@gmail.com");
			
			InstructorDetail tempDetails = new InstructorDetail("http://www.pavanreddy.youtube.com","Martial Arts");
			
			tempInstructor.setInstructorDetailId(tempDetails);
//			
			session.beginTransaction();
			System.out.println("save tempInstructor details : "+tempInstructor);
			session.save(tempInstructor);

	        
			session.getTransaction().commit();
			
			System.out.println("Done !!!");
		} finally {
			//clean up code
			session.close();
			factory.close();
		}
		
		
		
		
	}

}


/*
 * 
 *
 * Exception in thread "main" org.hibernate.AnnotationException: 
 * Illegal attempt to map a non collection as a @OneToMany, @ManyToMany or @CollectionOfElements: 
 * com.demo.hibernate.entity.Course.instructor
	at org.hibernate.cfg.annotations.CollectionBinder.getCollectionBinder(CollectionBinder.java:323)

 */
