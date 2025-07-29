package com.java.hibernate.map.manytomany;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.Transaction;

public class MapDemo {

	public static void main(String[] args) {
		
		Configuration cfg = new Configuration();
		cfg.configure();
		SessionFactory factory = cfg.buildSessionFactory();
		
		
		Emp e1 = new Emp();
		Emp e2 = new Emp();
		
		e1.setEid(34);
		e1.setName("Ram");
		e2.setEid(35);
		e2.setName("Shyam");
		
		
		Project p1 = new Project();
		Project p2 = new Project();
		
		p1.setPid(12121);
		p1.setProjectName("Library Manangement System");
		p2.setPid(14214);
		p2.setProjectName("ChatBot");
		
		
		List<Emp>ls1 = new ArrayList<>();	
		ls1.add(e1);
		ls1.add(e2);
		
		List<Project>ls2 = new ArrayList<>();
		ls2.add(p1);
		ls2.add(p2);
		
		
		e1.setProjects(ls2);
		p2.setEmployees(ls1);
		
		
		Session sc = factory.openSession();
		Transaction tx = sc.beginTransaction();
		
		sc.save(e1);
		sc.save(e2);
		sc.save(p1);
		sc.save(p2);		
		
		tx.commit();
		sc.close();
		
		factory.close();
	}

}
