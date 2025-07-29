package com.java.hibernatebasics.HibernateAnnotations;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;


public class FetchData {

	public static void main(String[] args) {
		Configuration cfg = new Configuration();
		cfg.configure();
		SessionFactory factory = cfg.buildSessionFactory();
		
		Session sc = factory.openSession();
		
//		using get method
		Student sobj = (Student) sc.get(Student.class, 21);
		System.out.println(sobj);
		
//		using load method
		
		Student sobj1 = (Student) sc.load(Student.class, 11);
		System.out.println("id:11 city: "+ sobj1.getCity());
		
		
		
		
		sc.close();
		factory.close();
		
		

	}

}
