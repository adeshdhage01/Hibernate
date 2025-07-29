package com.java.hibernate.sqlquery;

import java.util.Arrays;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.NativeQuery;

import com.java.hibernate.states.Student;

public class SQLExample {
	public static void main(String[] args) {
		
		Configuration cfg = new Configuration();
		cfg.configure();
		SessionFactory factory = cfg.buildSessionFactory();
		
		Session sc = factory.openSession();
		
		
		//SQL Queries
		String q = "select * from Student";
		NativeQuery nq = sc.createNativeQuery(q);
		
		List<Object []>ls=nq.list();
		
		for(Object[] s: ls)
		{
			System.out.println(Arrays.deepToString(s));
		}
		sc.close();
		factory.close();
		
	}
	

}
