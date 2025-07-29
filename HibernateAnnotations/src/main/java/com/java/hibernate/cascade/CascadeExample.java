package com.java.hibernate.cascade;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.java.hibernate.map.onetomany.Answer;
import com.java.hibernate.map.onetomany.Question;

public class CascadeExample {

	public static void main(String[] args)
	{
		Configuration cfg = new Configuration();
		cfg.configure();
		SessionFactory factory = cfg.buildSessionFactory();
		Session sc = factory.openSession();
		Transaction tx = sc.beginTransaction();
		
		Question q1 = new Question();
		q1.setQuestionId(924);
		q1.setQuestion("What is Swing");
		
		Answer a1 = new Answer();
		a1.setAnswerId(565);
		a1.setAnswer("It is use for Frontend ");
		
		Answer a2 = new Answer();
		a2.setAnswerId(578);
		a2.setAnswer("Second Answer");
		
		Answer a3 = new Answer();
		a3.setAnswerId(159);
		a3.setAnswer("Third Answer");
		
		List<Answer>ls= new ArrayList<>();
		ls.add(a1);
		ls.add(a2);
		ls.add(a3);
		
		q1.setAnswer(ls);
		
		sc.save(q1);
		
		tx.commit();
		sc.close();
		factory.close();

	}

}
