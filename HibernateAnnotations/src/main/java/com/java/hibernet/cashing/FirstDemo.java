package com.java.hibernet.cashing;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.java.hibernate.states.Student;

public class FirstDemo {

	public static void main(String[] args) {
		Configuration cfg = new Configuration();
		cfg.configure();
		SessionFactory factory = cfg.buildSessionFactory();
		
		Session sc = factory.openSession();
		Student sobj = sc.get(Student.class, 121);
		System.out.println(sobj.getId()+":" +sobj.getName()+":" +sobj.getCity());
		
		System.out.println("Working continue....");
		
		Student sobj2 = sc.get(Student.class, 121);
		System.out.println(sobj2.getId()+":" +sobj2.getName()+":" +sobj2.getCity());
		
		factory.close();

	}

}
