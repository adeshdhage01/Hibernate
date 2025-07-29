package com.java.hibernate.states;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class StateDemo {

	public static void main(String[] args) {
		
		System.out.println("Project started.......");
		
		Configuration cfg = new Configuration();
		cfg.configure();
		SessionFactory factory = cfg.buildSessionFactory();
		
		//Now object is in transient state:
		
		Certificate cer = new Certificate();
		cer.setCourse("PPA");
		cer.setDuration(6);
	
		Student sobj = new Student();
		sobj.setId(121);
		sobj.setName("abhi");
		sobj.setCity("Pune");
		sobj.setCerti(cer);
		
		////////////////////////////////////////////////////////////
		
		//now object is in persistent state:
		
		Session sc = factory.openSession();	
		Transaction tx = sc.beginTransaction();
		sc.save(sobj);
		sobj.setName("Sahil");
		
		////////////////////////////////////////////////////////////
		
		tx.commit();
		
		//now object is in detached state:
		sc.close();
		sobj.setName("rahul");
		//////////////////////////////////////////////////////////
		
		
		
		factory.close();

	}

}
