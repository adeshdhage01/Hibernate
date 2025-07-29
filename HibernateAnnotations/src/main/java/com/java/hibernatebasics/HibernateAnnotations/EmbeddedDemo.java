package com.java.hibernatebasics.HibernateAnnotations;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;


public class EmbeddedDemo {
	public static void main(String[] args) 
	{
			Configuration cfg = new Configuration();
	        cfg.configure();
	        SessionFactory factory = cfg.buildSessionFactory();

	        
	        Certificate cobj = new Certificate();
	        cobj.setCourse("LSP");
	        cobj.setDuration(6);
	               
	        Student sobj = new Student();
	        sobj.setId(21);
	        sobj.setName("Amol");
	        sobj.setCity("Sangamner");
	        sobj.setCerti(cobj);
	        
	        Certificate cobj1 = new Certificate();
	        cobj1.setCourse("PPA");
	        cobj1.setDuration(4);
	        
	        Student sobj1 = new Student();
	        sobj1.setId(11);
	        sobj1.setName("Akash");
	        sobj1.setCity("pune");
	        sobj1.setCerti(cobj1);
	        
	        
	        Session sc = factory.openSession();
	        Transaction tx = sc.beginTransaction();
	        
	        
	        sc.save(sobj1);
	        sc.save(sobj);
	        
	        tx.commit();
	        sc.close();
	        factory.close();
	        
	}

}
