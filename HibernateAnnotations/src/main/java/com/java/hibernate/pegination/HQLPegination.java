package com.java.hibernate.pegination;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

import com.java.hibernate.states.Student;

public class HQLPegination 
{
	public static void main(String[] args) 
	{
		Configuration cfg = new Configuration();
		cfg.configure();
		SessionFactory factory = cfg.buildSessionFactory();
		Session sc = factory.openSession();
		
		Query q = sc.createQuery("from Student");
		
		//implementing pagination
		
		q.setFirstResult(0);
		q.setMaxResults(5);
		
		List<Student>ls = q.list();
		for(Student s: ls)
		{
			System.out.println(s.getId()+": "+s.getName());
		}
		
		factory.close();
	}

}
