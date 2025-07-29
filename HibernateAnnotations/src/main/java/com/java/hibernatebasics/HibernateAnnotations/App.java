package com.java.hibernatebasics.HibernateAnnotations;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Date;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;


public class App 
{
    public static void main( String[] args ) throws Exception
    {
    	
    	
        Configuration cfg = new Configuration();
        cfg.configure();
        SessionFactory factory = cfg.buildSessionFactory();
        
        
//        Creating Student Object
    	Student sobj = new Student();
    	sobj.setId(51);
    	sobj.setName("Gaurav");
    	sobj.setCity("Nagar");
    	
//    	Creating Address Object
    	Address ad = new Address();
    	ad.setStreet("JM Road");
    	ad.setCity("Pune");
    	ad.setOpen(true);
    	ad.setX(99.235);
    	ad.setAddedDate(new Date());
    	
//    	Reading Image
    	
    	FileInputStream img = new FileInputStream("src/main/java/JMRoad.jpg");
    	
    	byte data[] = new byte[img.available()];
    	img.read(data);
    	ad.setImage(data);
    	
    	Session sc = factory.openSession();
    	Transaction tx = sc.beginTransaction();
    	sc.save(sobj);
    	sc.save(ad);
    	tx.commit();
    	sc.close();
        

  
    }
}
