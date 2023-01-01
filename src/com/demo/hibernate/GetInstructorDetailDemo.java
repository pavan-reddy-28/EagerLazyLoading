package com.demo.hibernate;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.demo.hibernate.entity.Instructor;
import com.demo.hibernate.entity.InstructorDetail;


public class GetInstructorDetailDemo {

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
			session.beginTransaction();
			
			int id=81;
			InstructorDetail tempInstructorDetail = 
					session.get(InstructorDetail.class, id);
			
			System.out.println(" tempInstructorDetail : "+tempInstructorDetail);
			
			System.out.println("the associated Instructor : "+tempInstructorDetail.getInstructor());
			

			
			
			session.getTransaction().commit();
			
			System.out.println("Done !!!");
		}catch(Exception ex){
			ex.printStackTrace();
		}finally {
			session.close();
			factory.close();
		}
		
		
		
		
	}

}
