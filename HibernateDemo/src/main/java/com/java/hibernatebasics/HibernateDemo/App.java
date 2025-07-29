package com.java.hibernatebasics.HibernateDemo;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class App 
{
    public static void main( String[] args )
    {
        System.out.println( "Project Started...." );
       try { 
           Configuration cfg = new Configuration();
           cfg.configure();
           SessionFactory factory = cfg.buildSessionFactory();
           System.out.println(factory);
       }
       catch(Exception e)
       {
    	   System.out.println(e);
       }
       

        
        
        
        
      
    }
}
