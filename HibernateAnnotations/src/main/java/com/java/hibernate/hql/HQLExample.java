package com.java.hibernate.hql;

import java.util.Arrays;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

import com.java.hibernate.states.Student;


public class HQLExample {
public static void main(String[] args) {
	Configuration cfg = new Configuration();
	cfg.configure();
	SessionFactory factory = cfg.buildSessionFactory();
	Session sc = factory.openSession();
	Transaction tx = sc.beginTransaction();
	 
	
	String query = "from Student as s where city = :x and name=:y";
	Query q = sc.createQuery(query);
	q.setParameter("x", "akole");
	q.setParameter("y", "yogesh");
	
	List<Student>ls = q.list();
	
	for(Student s: ls)
	{
		System.out.println(s.getName());
	}
	System.out.println("-----------------------------------------------");
	
	//Delete Query
//	Query q2 = sc.createQuery("delete from Student where city = 'Akole'");
//	q2.executeUpdate();
//	System.out.println("Deleted");
	
	//update query
//	Query q3 = sc.createQuery("update Student set city = 'Nashik' where name = 'sahil'");
//	q3.executeUpdate();
//	System.out.println("updated");
	
	
	//join query
	Query q4 = sc.createQuery("select q.question, q.questionId,a.answer from Question as q inner join q.answer as a");
	List<Object []>ls3 = q4.getResultList();
	for(Object[] arr: ls3)
	{
		System.out.println(Arrays.toString(arr	));
	}
	System.out.println("Joined column");
	
	tx.commit();
	sc.close();
	factory.close();
}
}
