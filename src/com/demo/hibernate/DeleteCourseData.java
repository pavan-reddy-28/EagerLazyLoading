package com.demo.hibernate;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.demo.hibernate.entity.Course;
import com.demo.hibernate.entity.Instructor;
import com.demo.hibernate.entity.InstructorDetail;




public class DeleteCourseData {

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
			
			List<Course> courses = tempInstructor.getCourses();
			
			if(courses != null) {
				
				Course data = courses.get(0);
				System.out.println(" COURSE DATA : \n "+data);
				data.setInstructor(null);
				session.delete(data);
				
			}

			
			tempInstructor = session.get(Instructor.class, theId);
			System.out.println("\n\n Courses : \n"+tempInstructor.getCourses());
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
