package com.java.hibernatebasics.HibernateDataFetching;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class FetchDemo 
{
	public static void main(String[] args) 
	{
		Configuration cfg = new Configuration();
		cfg.configure();
		SessionFactory factory = cfg.buildSessionFactory();
		
		Session sc = factory.openSession();
		
		Student sobj = (Student) sc.get(Student.class, 21);
		
		System.out.println(sobj);
		
		
		
		
		sc.close();
		factory.close();
		
		
	}
	


}
