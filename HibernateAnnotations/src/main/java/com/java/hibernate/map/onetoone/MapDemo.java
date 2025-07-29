package com.java.hibernate.map.onetoone;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class MapDemo {

    public static void main(String[] args) {
    	
    	Configuration cfg = new Configuration();
    	cfg.configure();
    	SessionFactory factory = cfg.buildSessionFactory();
    	
    	Question q1 = new Question();
    	q1.setQuestionId(11);
    	q1.setQuestion("What is Java ?");
    	
    	Answer answer = new Answer();
    	answer.setAnswerId(108);
    	answer.setAnswer("Java is programming language");
    	
    	q1.setAnswer(answer);
    	
    	
    	Question q2 = new Question();
    	q2.setQuestionId(21);
    	q2.setQuestion("What is netbeans?");
    	
    	Answer answer1 = new Answer();
    	answer1.setAnswerId(151);
    	answer1.setAnswer("It is an IDE");
    	
    	q2.setAnswer(answer1);
    	
    	
    	Session s = factory.openSession();
    	Transaction tx = s.beginTransaction();
    	
    	//Save Data
    	s.save(q1);
    	s.save(answer);
    	s.save(q2);
    	s.save(answer1);
    	tx.commit();
    	
    	//Fetching Data 
    	
    	Question result = (Question)s.get(Question.class, 11);
    	System.out.println(result.getQuestionId());
    	System.out.println(result.getQuestion());
    	System.out.println(result.getAnswer().getAnswer());
    	

    	s.close();
    	
    	
    	
    	
    	factory.close();

    }
}
