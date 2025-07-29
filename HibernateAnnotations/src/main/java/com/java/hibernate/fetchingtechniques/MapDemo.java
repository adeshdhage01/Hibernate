package com.java.hibernate.fetchingtechniques;

import java.util.ArrayList;
import java.util.List;

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
    	q1.setQuestionId(190);
    	q1.setQuestion("What is Java ?");
    	
    	Answer answer1 = new Answer();
    	answer1.setAnswerId(191);
    	answer1.setAnswer("Java is programming language");
    	answer1.setQuestion(q1);
    	
    	Answer answer2 = new Answer();
    	answer2.setAnswerId(192);
    	answer2.setAnswer("OOP language");
    	answer2.setQuestion(q1);
    	
    	Answer answer3 = new Answer();
    	answer3.setAnswerId(193);
    	answer3.setAnswer("VM based language");
    	answer3.setQuestion(q1);
    	
    	
    	List<Answer>ls = new ArrayList<>();
    	ls.add(answer1);
    	ls.add(answer2);
    	ls.add(answer3);
    	
    	q1.setAnswer(ls);
    	
    	Session s = factory.openSession();
    	Transaction tx = s.beginTransaction();
    	
    	s.save(q1);
    	s.save(answer1);
    	s.save(answer2);
    	s.save(answer3);
    	
    	//Save Data

    	tx.commit();
    	
    	//Fetching Data 
    	
    	Question q = (Question)s.get(Question.class,190);
    	
    	System.out.println(q.getQuestionId());
    	System.out.println(q.getQuestion());
 
    	

    	s.close();
    	
    	
    	
    	
    	factory.close();

    }
}
