package com.demo.hibernate;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.demo.hibernate.entity.Instructor;
import com.demo.hibernate.entity.InstructorDetail;


public class CreateDemo {

	public static void main(String[] args) {
		
		// create SessionFactroy object
		
		SessionFactory factory = new Configuration()
									.configure("hibernate.cfg.xml")
									.addAnnotatedClass(Instructor.class)
									.addAnnotatedClass(InstructorDetail.class)
									.buildSessionFactory();
		
		//create session
		Session session = factory.getCurrentSession();
		try {
			Instructor tempInstructor = new Instructor("Pavan","Reddy","pavan@gmail.com");
			
			InstructorDetail tempDetails = new InstructorDetail("http://www.pavanreddy.youtube.com","watch anime");
			
			tempInstructor.setInstructorDetailId(tempDetails);
//			
			session.beginTransaction();
			System.out.println("save student details : "+tempInstructor);
			session.save(tempInstructor);
			
//			Instructor tempInstructor =session.get(Instructor.class, 4);
//	        if(tempInstructor != null) {
//	        	session.delete(tempInstructor);
//	        }
	        
			session.getTransaction().commit();
			
			System.out.println("Done !!!");
		} finally {
			factory.close();
		}
		
		
		
		
	}

}
